package ca.gkworkbench.bb2020api.team.bo.impl;

import ca.gkworkbench.bb2020api.player.bo.PlayerBO;
import ca.gkworkbench.bb2020api.team.bo.TeamTemplateBO;
import ca.gkworkbench.bb2020api.team.bo.TeamsBO;
import ca.gkworkbench.bb2020api.team.dao.TeamTemplateDAO;
import ca.gkworkbench.bb2020api.team.dao.TeamsDAO;
import ca.gkworkbench.bb2020api.team.vo.TeamVO;
import com.google.gson.Gson;

public class TeamsBOImpl implements TeamsBO {

    private TeamsDAO tDAO;
    private TeamTemplateBO ttBO;
    private PlayerBO pBO;
    private Gson gson;

    public TeamsBOImpl(TeamsDAO tDAO, TeamTemplateBO ttBO, PlayerBO pBO) {
        this.tDAO = tDAO;
        this.ttBO = ttBO;
        this.pBO = pBO;
        this.gson = new Gson();
    }

    @Override
    public TeamVO getTeamById(int teamId, boolean withDetails) throws Exception {
        TeamVO tVO = tDAO.getTeamById(teamId);
        if (withDetails) tVO = getTeamDetails(tVO);
        return tVO;
    }

    @Override
    public TeamVO getTeamByName(String teamName, boolean withDetails) throws Exception {
        TeamVO tVO = tDAO.getTeamByName(teamName);
        if (withDetails) tVO = getTeamDetails(tVO);
        return tVO;
    }

    @Override
    public TeamVO createNewTeamFromTemplateId(String teamName, int coachId, int teamTemplateId, int treasury) throws Exception {
        //create the new team
        TeamVO tVO = new TeamVO(coachId, teamTemplateId, teamName, treasury);
        tVO = getTeamDetails(tVO);
        tDAO.insertTeamVO(tVO);

        //immediately query back
        return getTeamByName(teamName, true);

    }

    @Override
    public TeamVO createNewTeamFromTemplateIdDefaultTreasury(String teamName, int coachId, int teamTemplateId) throws Exception {
        return createNewTeamFromTemplateId(teamName, coachId, teamTemplateId, 1000000);
    }

    @Override
    public TeamVO redraftTeamFromTeamId(int teamId, int treasury) throws Exception {
        TeamVO tVO = tDAO.getTeamById(teamId);
        //reset all players to "inactive" status
        //reset the treasury to the desired amount
        return tVO;
    }

    @Override
    public String getJsonTeam(TeamVO tVO) throws Exception {
        return gson.toJson(tVO);
    }

    private TeamVO getTeamDetails(TeamVO teamVO) throws Exception {
        teamVO.setPlayers(pBO.getPlayersByTeamId(teamVO.getId()));
        teamVO.setTeamTemplateVO(ttBO.getTeamTemplateByID(teamVO.getTeamTemplateId(), false));
        return teamVO;
    }
}
