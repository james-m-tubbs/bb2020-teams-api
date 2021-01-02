package ca.gkworkbench.bb2020api.team.bo.impl;

import ca.gkworkbench.bb2020api.exception.WarnException;
import ca.gkworkbench.bb2020api.player.bo.PlayerBO;
import ca.gkworkbench.bb2020api.player.vo.PlayerTemplateVO;
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
        if (tVO != null && withDetails) tVO = getTeamDetails(tVO);
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
        tVO.setDedicatedFans(1);
        tVO = getTeamDetails(tVO);
        try {
            tDAO.insertTeamVO(tVO);
        } catch (Exception e) {
            if (e.getMessage().contains("Unique index or primary key violation")) throw new WarnException("Team Name Exists: " +teamName);
            throw e;
        }

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
        if (!tDAO.updateTeamVO(tVO)) return null; // if there is no team to update return null
        return getTeamById(tVO.getId(), false);
    }

    @Override
    public void deleteTeam(int teamId) throws Exception {
        tDAO.deleteTeamVO(teamId);
    }

    @Override
    public PlayerVO hireRookiePlayerFromTemplateId(int teamId, int playerTemplateId, String playerName) throws Exception {
//        //get the team plus details
//        TeamVO tVO = getTeamById(teamId, false);
//        if (tVO == null) throw new WarnException("Could not find team for id:"+teamId);
//
//        //validate we have the cash
//        if (tVO.getTreasury() < ptVO.getCost()) throw new WarnException("Not enough funds");
//
//        //validate we have spots on the team
//        if (!canHirePlayer(tVO, ptVO)) throw new WarnException("No More Positionals Available");
//
//        //validate if the player name is in use
//        if (pDAO.getPlayerForNameAndTeam(teamId, playerName) != null) throw new WarnException("Player name in use");
//
//        //create the player
//        PlayerVO pVO = new PlayerVO(
//                ptVO.getPlayerTemplateId(),
//                ptVO.getTeamTemplateId(),
//                ptVO.getPosition(),
//                ptVO.isLinemanFlag(),
//                ptVO.getQty(),
//                ptVO.getCost(),
//                ptVO.getMA(),
//                ptVO.getST(),
//                ptVO.getAG(),
//                ptVO.getPA(),
//                ptVO.getAV(),
//                ptVO.getBaseSkills(),
//                ptVO.getPrimary(),
//                ptVO.getSecondary(),
//                -1,
//                teamId,
//                playerName,
//                0,
//                ptVO.getCost(),
//                0,
//                0,
//                0,
//                0,
//                0,
//                false,
//                false,
//                false,
//                null);
//        pDAO.createPlayer(pVO);
//
//        //requery the player to make sure they've been created correctly
//        PlayerVO rookiePVO = pDAO.getPlayerForNameAndTeam(teamId, playerName);
//        if (rookiePVO == null) throw new WarnException("Unable to query new player");
//
//        //update the treasury
//        tVO.setTreasury(tVO.getTreasury() - ptVO.getCost());
//        tBO.updateTeamWithGeneratedTV(tVO);
//
//        //return the new player
//        return rookiePVO;
        return null;
    }

    @Override
    public PlayerVO getHireablePlayerList(int teamId) throws Exception {
        return null;
    }

    @Override
    public List<TeamVO> getTeamsForCoachId(int coachId) throws Exception {
        return tDAO.getTeamVOsByCoachId(coachId);
    }

    @Override
    public TeamVO redraftTeamFromTeamId(int teamId, int treasury) throws Exception {
        TeamVO tVO = tDAO.getTeamById(teamId);
        //reset all players to "temp retired" status
        //reset the treasury to the desired amount
        //hire from the team template or from temp retired players
        //remove injuries
        return tVO;
    }

    @Override
    public String getJsonTeam(TeamVO tVO) throws Exception {
        return gson.toJson(tVO);
    }

    @Override
    public String getJsonTeamList(List<TeamVO> tVOs) throws Exception {
        return gson.toJson(tVOs);
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

        //query players for the team in case we hired any new ones
        tVO.setPlayers(pBO.getPlayersByTeamId(tVO.getId()));

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
            if (!player.isFired() && !player.isInjured() && !player.isTempRetired()) {
                ctvValue = ctvValue + player.getCurrentValue();
            }
        }

        tVO.setCurrentTeamValue(ctvValue);
        tVO.setTeamValue(totalValue);

        return tVO;
    }
}
