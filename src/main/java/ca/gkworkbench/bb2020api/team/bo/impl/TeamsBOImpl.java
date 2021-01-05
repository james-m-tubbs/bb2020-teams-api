package ca.gkworkbench.bb2020api.team.bo.impl;

import ca.gkworkbench.bb2020api.exception.WarnException;
import ca.gkworkbench.bb2020api.player.bo.PlayerBO;
import ca.gkworkbench.bb2020api.player.dao.PlayerTemplateDAO;
import ca.gkworkbench.bb2020api.player.vo.PlayerTemplateVO;
import ca.gkworkbench.bb2020api.player.vo.PlayerVO;
import ca.gkworkbench.bb2020api.team.bo.TeamTemplateBO;
import ca.gkworkbench.bb2020api.team.bo.TeamsBO;
import ca.gkworkbench.bb2020api.team.dao.TeamsDAO;
import ca.gkworkbench.bb2020api.team.vo.TeamVO;
import com.google.gson.Gson;

import java.util.List;

public class TeamsBOImpl implements TeamsBO {

    private TeamsDAO tDAO;
    private TeamTemplateBO ttBO;
    private PlayerBO pBO;
    private PlayerTemplateDAO ptDAO;
    private Gson gson;

    public TeamsBOImpl(TeamsDAO tDAO, TeamTemplateBO ttBO, PlayerBO pBO, PlayerTemplateDAO ptDAO) {
        this.tDAO = tDAO;
        this.ttBO = ttBO;
        this.pBO = pBO;
        this.ptDAO = ptDAO;
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
        return getTeamById(tVO.getId(), true);
    }

    @Override
    public void deleteTeam(int teamId) throws Exception {
        tDAO.deleteTeamVO(teamId);
    }

    @Override
    public TeamVO hireRookiePlayerFromTemplateId(TeamVO tVO, int playerTemplateId, String playerName) throws Exception {

        //get the player template id
        PlayerTemplateVO ptVO = ptDAO.getPlayerTemplateVOById(playerTemplateId);
        if (ptVO == null) throw new WarnException("Invalid Player Template ID");

        //validate we have the cash
        if (tVO.getTreasury() < ptVO.getCost()) throw new WarnException("Insufficent Funds");

        //buy the player
        PlayerVO pVO = pBO.createPlayerFromTemplateId(tVO.getId(), tVO.getTeamTemplateId(), playerTemplateId, playerName);

        //update the treasury
        tVO.setTreasury(tVO.getTreasury() - ptVO.getCost());
        tVO = updateTeamWithGeneratedTV(tVO);
        return getTeamDetails(tVO);
    }

    @Override
    public TeamVO firePlayerByPlayerId(TeamVO tVO, int playerId) throws Exception {
        PlayerVO pVO = pBO.getPlayerById(playerId);
        if (pVO == null || pVO.getTeamId() != tVO.getId()) throw new WarnException("Player ID not found");
        if (pVO.isFired()) return updateTeamWithGeneratedTV(tVO);

        //fire the player
        if (!pBO.firePlayerVO(pVO)) throw new Exception("Can't fire player: " + pVO);

        //check if they get a refund
        if (pVO.getGamesPlayed() < 1) {
            tVO.setTreasury(tVO.getTreasury() + pVO.getCost());
        }
        return updateTeamWithGeneratedTV(tVO);
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
            if (!player.isFired()) {
                totalValue = totalValue + player.getCurrentValue();
                if (!player.isInjured() && !player.isTempRetired()) {
                    ctvValue = ctvValue + player.getCurrentValue();
                }
            }
        }

        tVO.setCurrentTeamValue(ctvValue);
        tVO.setTeamValue(totalValue);

        return tVO;
    }
}
