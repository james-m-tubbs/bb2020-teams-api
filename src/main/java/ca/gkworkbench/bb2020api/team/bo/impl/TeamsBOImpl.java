package ca.gkworkbench.bb2020api.team.bo.impl;

import ca.gkworkbench.bb2020api.exception.WarnException;
import ca.gkworkbench.bb2020api.player.bo.PlayerBO;
import ca.gkworkbench.bb2020api.player.vo.PlayerVO;
import ca.gkworkbench.bb2020api.team.bo.TeamTemplateBO;
import ca.gkworkbench.bb2020api.team.bo.TeamsBO;
import ca.gkworkbench.bb2020api.team.dao.TeamsDAO;
import ca.gkworkbench.bb2020api.team.vo.TeamVO;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public TeamVO updateTeamWithGeneratedTV(TeamVO tVO) throws Exception {
        if (tVO.getTeamTemplateVO() == null) {
            ttBO.getTeamTemplateByID(tVO.getTeamTemplateId(), false);
        }
        tVO = fillTeamValues(tVO);
        tDAO.updateTeamVO(tVO);
        System.out.println("Updating TeamVO:"+tVO);
        return getTeamById(tVO.getId(), false);
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

    private TeamVO fillTeamValues(TeamVO tVO) throws Exception {
        //we need the team template to calculate tv
        if (tVO.getTeamTemplateVO() == null) {
            tVO.setTeamTemplateVO(ttBO.getTeamTemplateByID(tVO.getTeamTemplateId(), false));
        }

        //need the players to calculate of it
        if (tVO.getPlayers() == null) {
            pBO.getPlayersByTeamId(tVO.getId());
        }

        int totalValue = 0;
        totalValue = totalValue + (10000 * tVO.getCheerleaders());
        totalValue = totalValue + (10000 * tVO.getCoaches());
        if (tVO.hasApothecary()) totalValue = totalValue + 50000;
        totalValue = totalValue + (tVO.getTeamTemplateVO().getRerollCost() * tVO.getRerolls());

        List<PlayerVO> players = tVO.getPlayers();
        int ctvValue = totalValue;
        for (int i=0; i<players.size(); i++) {
            PlayerVO player = players.get(i);
            totalValue = totalValue + player.getCurrentValue();
            if (!player.isDrafted() || !player.isInjured()) {
                ctvValue = ctvValue + player.getCurrentValue();
            }
        }

        tVO.setCurrentTeamValue(ctvValue);
        tVO.setTeamValue(totalValue);

        return tVO;
    }
}
