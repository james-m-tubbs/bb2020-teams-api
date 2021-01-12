package ca.gkworkbench.bb2020api.auth.bo.impl;

import ca.gkworkbench.bb2020api.auth.AuthVO;
import ca.gkworkbench.bb2020api.auth.bo.AuthBO;
import ca.gkworkbench.bb2020api.auth.dao.AuthDAO;
import ca.gkworkbench.bb2020api.exception.AuthException;
import ca.gkworkbench.bb2020api.exception.WarnException;
import ca.gkworkbench.bb2020api.team.bo.TeamsBO;
import ca.gkworkbench.bb2020api.team.dao.TeamsDAO;
import ca.gkworkbench.bb2020api.team.vo.TeamVO;

public class AuthBOImpl implements AuthBO {
    TeamsDAO tDAO;
    AuthDAO aDAO;

    public AuthBOImpl(TeamsDAO tDAO, AuthDAO aDAO) {
        this.tDAO = tDAO;
        this.aDAO = aDAO;
    }


    @Override
    public int getUserId(String token) throws WarnException, AuthException, Exception {
        if (token == null) throw new AuthException("");
        Integer coachId = aDAO.getCoachIdFromToken(token);
        if (coachId == null) throw new AuthException(""); // if the
        aDAO.deleteOldSessions();
        AuthVO aVO = aDAO.getAuthForCoachId(coachId);
        if (aVO == null) throw new AuthException("");
        return aVO.getCoachId();
    }

    @Override
    public boolean hasAccessToModifyTeam(String token, int teamId) throws WarnException, AuthException, Exception {
        int coachId = getUserId(token);
        return hasAccessToModifyTeam(coachId, teamId);
    }

    @Override
    public boolean hasAccessToModifyTeam(int coachId, int teamId) throws WarnException, AuthException, Exception {
        TeamVO tVO = tDAO.getTeamById(teamId);
        if (tVO == null) throw new AuthException("Team doesn't exist");
        boolean isAdmin = false; //TODO create an admin check here
        if (tVO.getCoachId() != coachId && !isAdmin) throw new AuthException("No access to modify team");
        return true;
    }

    @Override
    public AuthVO login(String username, String password) throws WarnException {
        return null;
    }
}
