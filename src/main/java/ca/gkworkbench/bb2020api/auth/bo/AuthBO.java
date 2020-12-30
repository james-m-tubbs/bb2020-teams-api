package ca.gkworkbench.bb2020api.auth.bo;

import ca.gkworkbench.bb2020api.exception.WarnException;

public interface AuthBO {

    public int getUserId() throws WarnException;

    public boolean hasAccessToModifyTeam(int teamId) throws WarnException, Exception;
}
