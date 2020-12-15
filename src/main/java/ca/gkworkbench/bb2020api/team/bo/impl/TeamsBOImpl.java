package ca.gkworkbench.bb2020api.team.bo.impl;

import ca.gkworkbench.bb2020api.player.bo.PlayerBO;
import ca.gkworkbench.bb2020api.team.bo.TeamsBO;
import ca.gkworkbench.bb2020api.team.dao.TeamTemplateDAO;
import ca.gkworkbench.bb2020api.team.dao.TeamsDAO;
import ca.gkworkbench.bb2020api.team.vo.TeamVO;
import com.google.gson.Gson;

public class TeamsBOImpl implements TeamsBO {

    private TeamsDAO tDAO;
    private TeamTemplateDAO ttDAO;
    private PlayerBO pBO;
    private Gson gson;

    public TeamsBOImpl(TeamsDAO tDAO, TeamTemplateDAO ttDAO) {
        this.tDAO = tDAO;
        this.ttDAO = ttDAO;
        this.gson = new Gson();
    }

    @Override
    public TeamVO getTeamById(int teamId) throws Exception {
        TeamVO tVO = tDAO.getTeamById(teamId);
        //tVO.setPlayers(pBO.getPlayersByTeamId(teamId));
        return tVO;
    }

    @Override
    public TeamVO buyPlayerFromTemplate(int teamId, int playerId) throws Exception {
        return null;
    }

    @Override
    public String getJsonTeam(TeamVO tVO) throws Exception {
        return gson.toJson(tVO);
    }
}