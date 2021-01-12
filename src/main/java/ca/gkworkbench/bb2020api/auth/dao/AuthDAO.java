package ca.gkworkbench.bb2020api.auth.dao;

import ca.gkworkbench.bb2020api.auth.AuthVO;

public interface AuthDAO {

    public AuthVO getAuthForCoachId(int coachId) throws Exception;

    public void deleteOldSessions() throws Exception;

    public boolean login(String username, String saltedPassword) throws Exception;

    public Integer getCoachIdFromToken(String token) throws Exception;
}
