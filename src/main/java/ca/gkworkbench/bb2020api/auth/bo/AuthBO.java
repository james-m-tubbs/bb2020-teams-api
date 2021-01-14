package ca.gkworkbench.bb2020api.auth.bo;

import ca.gkworkbench.bb2020api.auth.vo.TokenVO;
import ca.gkworkbench.bb2020api.exception.AuthException;
import ca.gkworkbench.bb2020api.exception.WarnException;

public interface AuthBO {

    public int getUserIdAndValidateToken(String token) throws WarnException, AuthException, Exception;

    public boolean hasAccessToModifyTeam(int coachId, int teamId) throws WarnException, Exception;

    public boolean hasAccessToModifyTeam(String token, int teamId) throws WarnException, Exception;

    public TokenVO login(String username, String password) throws WarnException, Exception;

    public TokenVO createUser(String username, String password) throws WarnException, Exception;

    public void deleteUser(int userId) throws WarnException;
}
