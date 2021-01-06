package ca.gkworkbench.bb2020api.player.bo.impl;

import ca.gkworkbench.bb2020api.exception.WarnException;
import ca.gkworkbench.bb2020api.player.bo.PlayerBO;
import ca.gkworkbench.bb2020api.player.bo.PlayerTemplateBO;
import ca.gkworkbench.bb2020api.player.dao.PlayerDAO;
import ca.gkworkbench.bb2020api.player.dao.PlayerTemplateDAO;
import ca.gkworkbench.bb2020api.player.vo.PlayerTemplateVO;
import ca.gkworkbench.bb2020api.player.vo.PlayerVO;
import ca.gkworkbench.bb2020api.skill.dao.SkillTemplateDAO;
import ca.gkworkbench.bb2020api.skill.vo.SkillVO;
import ca.gkworkbench.bb2020api.team.bo.TeamsBO;
import ca.gkworkbench.bb2020api.team.dao.TeamTemplateDAO;
import ca.gkworkbench.bb2020api.team.vo.TeamTemplateVO;
import ca.gkworkbench.bb2020api.team.dao.TeamsDAO;
import ca.gkworkbench.bb2020api.team.vo.TeamVO;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerBOImpl implements PlayerBO {

    private PlayerDAO pDAO;
    private PlayerTemplateDAO ptDAO;
    private SkillTemplateDAO stDAO;
    private TeamTemplateDAO ttDAO;
    private Gson gson;

    public PlayerBOImpl(PlayerDAO pDAO, SkillTemplateDAO stDAO, PlayerTemplateDAO ptDAO, TeamTemplateDAO ttDAO) {
        this.pDAO = pDAO;
        this.stDAO = stDAO;
        this.ptDAO = ptDAO;
        this.ttDAO = ttDAO;
        this.gson = new Gson();
    }

    @Override
    public List<PlayerVO> getPlayersByTeamId(int teamId) throws Exception {
        List<PlayerVO> pVOs = pDAO.getPlayersForTeamId(teamId);
        return getPlayerListDetails(pVOs);
    }

    @Override
    public String getJsonPlayerList(List<PlayerVO> pVOs) throws Exception {
        return gson.toJson(pVOs);
    }

    @Override
    public PlayerVO getPlayerById(int playerId) throws Exception {
        PlayerVO pVO = pDAO.getPlayerById(playerId);
        return getPlayerDetails(pVO);
    }

    @Override
    public String getJsonPlayer(PlayerVO pVO) throws Exception {
        return gson.toJson(pVO);
    }

    @Override
    public PlayerVO createPlayerFromTemplateId(int teamId, int teamTemplateId, int playerTemplateId, String playerName) throws Exception {
        //get the player template
        PlayerTemplateVO ptVO = ptDAO.getPlayerTemplateVOById(playerTemplateId);
        if (ptVO == null) throw new WarnException("Could not find playerTemplate for id:"+playerTemplateId);

        //validate if the player name is in use
        if (pDAO.getPlayerForNameAndTeam(teamId, playerName) != null) throw new WarnException("Player name in use");

        //this guy throws an exception (and will bubble it up) if there's an issue with hiring
        checkForHiringExceptions(teamId, teamTemplateId, ptVO);

        //create the player
        PlayerVO pVO = new PlayerVO(
                ptVO.getPlayerTemplateId(),
                ptVO.getTeamTemplateId(),
                ptVO.getPosition(),
                ptVO.isLinemanFlag(),
                ptVO.isBigGuyFlag(),
                ptVO.getQty(),
                ptVO.getCost(),
                ptVO.getMA(),
                ptVO.getST(),
                ptVO.getAG(),
                ptVO.getPA(),
                ptVO.getAV(),
                ptVO.getBaseSkills(),
                ptVO.getPrimary(),
                ptVO.getSecondary(),
                -1,
                teamId,
                playerName,
                0,
                ptVO.getCost(),
                0,
                0,
                0,
                0,
                0,
                false,
                false,
                false,
                null,
                0);
        pDAO.createPlayer(pVO);

        //requery the player to make sure they've been created correctly
        PlayerVO rookiePVO = pDAO.getPlayerForNameAndTeam(teamId, playerName);
        if (rookiePVO == null) throw new WarnException("Unable to query new player");

        rookiePVO = getPlayerDetails(rookiePVO);

        //return the new player
        return rookiePVO;
    }

    @Override
    public boolean checkForHiringExceptions(int teamId, int teamTemplateId, PlayerTemplateVO ptVO) throws Exception {
        List<PlayerVO> players = pDAO.getPlayersForTeamId(teamId);

        //Does the player templateId match the input templateId
        if (teamTemplateId != ptVO.getTeamTemplateId()) throw new WarnException("Player ("+ptVO.getPosition()+") cannot be hired by team");

        TeamTemplateVO team = ttDAO.getTeamTemplateByID(teamTemplateId);

        //if the team is empty hiring is allowed
        if (players == null || players.size() == 0) return true;
        int currentCount = 0;
        int totalCount = 0;
        int bigGuyCount = 0;
        for (int i=0;i<players.size();i++) {
            PlayerVO pVO = players.get(i);
            if (!pVO.isFired()) {
                if (pVO.isBigGuyFlag() && team.getBigGuyMax() > 0) bigGuyCount++;
                if (pVO.getPosition() == ptVO.getPosition()) currentCount++;
                totalCount++;
            }
        }
        if (totalCount >= 16) throw new WarnException("Can't Hire Player - Full Roster");
        if (currentCount >= ptVO.getQty()) throw new WarnException("Positional Count Reached for "+ptVO.getPosition());
        if (bigGuyCount > 0 && bigGuyCount >= team.getBigGuyMax() && team.getBigGuyMax() > 0) throw new WarnException("Big Guy Limit Reached for "+ptVO.getPosition());

        return true;
    }

    @Override
    public boolean firePlayerVO(PlayerVO pVO) throws Exception {
        pVO.setFired(true);
        return pDAO.updatePlayer(pVO);
    }

    @Override
    public boolean temporarilyRetirePlayerVO(PlayerVO pVO) throws Exception {
        pVO.setTempRetired(true);
        return pDAO.updatePlayer(pVO);
    }

    private List<PlayerVO> getPlayerListDetails(List<PlayerVO> inPlayerVOs) throws Exception {
        if (inPlayerVOs == null) return null;
        List<PlayerVO> outPlayerVOs = new ArrayList<PlayerVO>();
        for (int i=0;i<inPlayerVOs.size();i++) {
            PlayerVO pVO = inPlayerVOs.get(i);
            outPlayerVOs.add(getPlayerDetails(pVO));
        }
        return outPlayerVOs;
    }

    @Override
    public PlayerVO getPlayerDetails(PlayerVO pVO) throws Exception {
        //set base skills
        if (pVO != null) {
            pVO.setBaseSkills(stDAO.getBaseSkillsByPlayerTemplateId(pVO.getPlayerTemplateId()));
            pVO.setBoughtSkills(new ArrayList<SkillVO>());
            //TODO set injuries
            //TODO set stat upgrades
        }
        return pVO;
    }
}
