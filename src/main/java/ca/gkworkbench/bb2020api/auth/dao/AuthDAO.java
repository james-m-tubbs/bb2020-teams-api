package ca.gkworkbench.bb2020api.auth.dao;

import ca.gkworkbench.bb2020api.auth.vo.TokenVO;
import ca.gkworkbench.bb2020api.auth.vo.UserVO;

public interface AuthDAO {

    public TokenVO getAuthForCoachId(int coachId) throws Exception;

    public void deleteOldSessions() throws Exception;

    public boolean login(String username, String saltedPassword) throws Exception;

    public Integer getCoachIdFromToken(String token) throws Exception;

    public UserVO getUserVOForCoachId(int coachId) throws Exception;

    public UserVO getUserVOForCoachName(String username) throws Exception;
}
