package ca.gkworkbench.bb2020api.auth.bo.impl;

import ca.gkworkbench.bb2020api.auth.bo.AuthBO;
import ca.gkworkbench.bb2020api.exception.WarnException;
import ca.gkworkbench.bb2020api.team.bo.TeamsBO;
import ca.gkworkbench.bb2020api.team.vo.TeamVO;

public class AuthBOImpl implements AuthBO {
    TeamsBO tBO;

    public AuthBOImpl(TeamsBO tBO) {
        this.tBO = tBO;
    }

    @Override
    public int getUserId() throws WarnException {
        //TODO derive this from auth object
        return 1;
    }

    @Override
    public boolean hasAccessToModifyTeam(int teamId) throws WarnException, Exception {
        TeamVO tVO = tBO.getTeamById(teamId, false);
        if (tVO != null && tVO.getCoachId() == getUserId()) return true;
        //if (admin) return true;
        return false;
    }
}
