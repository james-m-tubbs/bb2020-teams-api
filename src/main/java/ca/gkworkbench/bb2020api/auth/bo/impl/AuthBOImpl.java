package ca.gkworkbench.bb2020api.auth.bo.impl;

import ca.gkworkbench.bb2020api.auth.vo.TokenVO;
import ca.gkworkbench.bb2020api.auth.bo.AuthBO;
import ca.gkworkbench.bb2020api.auth.dao.AuthDAO;
import ca.gkworkbench.bb2020api.auth.vo.UserVO;
import ca.gkworkbench.bb2020api.exception.AuthException;
import ca.gkworkbench.bb2020api.exception.WarnException;
import ca.gkworkbench.bb2020api.team.dao.TeamsDAO;
import ca.gkworkbench.bb2020api.team.vo.TeamVO;
import com.google.gson.Gson;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

public class AuthBOImpl implements AuthBO {
    TeamsDAO tDAO;
    AuthDAO aDAO;
    Gson gson;

    public AuthBOImpl(TeamsDAO tDAO, AuthDAO aDAO) {
        this.tDAO = tDAO;
        this.aDAO = aDAO;
        gson = new Gson();
    }

    @Override
    public int getUserIdAndValidateToken(String token) throws WarnException, AuthException, Exception {
        if (token == null) throw new AuthException("");
        Integer coachId = aDAO.getCoachIdFromToken(token);
        if (coachId == null) throw new AuthException(""); // if the
        aDAO.deleteOldSessions();
        TokenVO aVO = aDAO.getAuthForCoachId(coachId);
        if (aVO == null) throw new AuthException("");
        return aVO.getCoachId();
    }

    @Override
    public boolean hasAccessToModifyTeam(String token, int teamId) throws WarnException, AuthException, Exception {
        int coachId = getUserIdAndValidateToken(token);
        return hasAccessToModifyTeam(coachId, teamId);
    }

    @Override
    public boolean hasAccessToModifyTeam(int coachId, int teamId) throws WarnException, AuthException, Exception {
        TeamVO tVO = tDAO.getTeamById(teamId);
        if (tVO == null) throw new AuthException("Team doesn't exist");

        //check if admin
        boolean isAdmin = false;
        UserVO uVO = aDAO.getUserVOForCoachId(coachId);
        if (uVO != null && uVO.isAdminFlag()) isAdmin = true;
        //TODO create a test that validates this

        if (tVO.getCoachId() != coachId && !isAdmin) throw new AuthException("No access to modify team");
        return true;
    }

    @Override
    public TokenVO login(String username, String password) throws Exception {
        String errorString = "Username or password invalid";

        UserVO userVO = aDAO.getUserVOForCoachName(username);
        if (userVO == null) throw new WarnException(errorString);

        //compare the passwords
        byte[] hashedPass = saltPassword(password, userVO.getSalt());
        if (!Arrays.equals(hashedPass, (userVO.getSaltPwd()))) throw new AuthException(errorString); // i think .equals is right here
        return generateToken(userVO.getCoachId());
    }

    @Override
    public TokenVO createUser(String username, String password) throws Exception {
        //create the user
        byte[] salt = generateSalt();
        byte[] hashPassword = saltPassword(password, salt);
        UserVO userVO = new UserVO(-1, salt, hashPassword, false, username);
        aDAO.insertUser(userVO); //TODO

        //create the token
        userVO = aDAO.getUserVOForCoachName(username);
        return generateToken(userVO.getCoachId());
    }

    @Override
    public void deleteUser(int userId) throws WarnException {
        //TODO
    }

    @Override
    public String getJsonToken(TokenVO tokenVO) {
        return gson.toJson(tokenVO);
    }

    private byte[] generateSalt() throws Exception {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        return salt;
    }

    private byte[] saltPassword(String password, byte[] salt) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(salt);

        return md.digest(password.getBytes(StandardCharsets.UTF_8));
    }

    private TokenVO generateToken(int coachId) throws Exception {
        String authToken = generateRandomString(32);
        aDAO.deleteOldSessionsByCoachId(coachId);
        aDAO.insertAuthForCoachId(coachId, authToken);
        return aDAO.getAuthForCoachId(coachId);
    }

    private String generateRandomString(int length) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = length;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }
}
