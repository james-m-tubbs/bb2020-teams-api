package ca.gkworkbench.bb2020api.team.bo.impl;

import ca.gkworkbench.bb2020api.exception.WarnException;
import ca.gkworkbench.bb2020api.player.vo.PlayerVO;
import ca.gkworkbench.bb2020api.team.bo.TeamGoodsBO;
import ca.gkworkbench.bb2020api.team.bo.TeamsBO;
import ca.gkworkbench.bb2020api.team.vo.TeamVO;

public class TeamGoodsBOImpl implements TeamGoodsBO {
    
    TeamsBO tBO;

    public TeamGoodsBOImpl(TeamsBO tBO) {
        this.tBO = tBO;
    }

    @Override
    public PlayerVO buyRookiePlayerForTeam(int teamId, int playerTemplateId, String playerName) throws Exception {
        return null; //TODO
    }

    @Override
    public TeamVO buyCheerleaderForTeam(int teamId) throws Exception {
        TeamVO tVO = tBO.getTeamById(teamId, false);
        if (tVO.getCheerleaders() == 10) throw new WarnException("Cheerleaders at max");
        if (tVO.getTreasury() < 10000) throw new WarnException("Not enough funds");
        tVO.setTreasury(tVO.getTreasury()-10000);
        tVO.setCheerleaders(tVO.getCheerleaders()+1);
        return tBO.updateTeamWithGeneratedTV(tVO);
    }

    @Override
    public TeamVO fireCheerleaderForTeam(int teamId) throws Exception {
        TeamVO tVO = tBO.getTeamById
(teamId, false);
        if (tVO.getCheerleaders() < 1) throw new WarnException("Cheerleaders at 0");
        tVO.setCheerleaders(tVO.getCheerleaders()-1);
        return tBO.updateTeamWithGeneratedTV(tVO);
    }

    @Override
    public TeamVO buyCoachForTeam(int teamId) throws Exception {
        TeamVO tVO = tBO.getTeamById
(teamId, false);
        if (tVO.getCoaches() == 6) throw new WarnException("Coaches at max");
        if (tVO.getTreasury() < 10000) throw new WarnException("Not enough funds");
        tVO.setTreasury(tVO.getTreasury()-10000);
        tVO.setCoaches(tVO.getCoaches()+1);
        return tBO.updateTeamWithGeneratedTV(tVO);
    }

    @Override
    public TeamVO fireCoachForTeam(int teamId) throws Exception {
        TeamVO tVO = tBO.getTeamById
(teamId, false);
        if (tVO.getCoaches() < 1) throw new WarnException("Coaches at 0");
        tVO.setCoaches(tVO.getCoaches()-1);
        return tBO.updateTeamWithGeneratedTV(tVO);
    }

    @Override
    public TeamVO buyApothForTeam(int teamId) throws Exception {
        TeamVO tVO = tBO.getTeamById(teamId, false);
        if (tVO.isHasApothecary()) throw new WarnException("Apothecary Exists");
        if (tVO.getTreasury() < 50000) throw new WarnException("Not enough funds");
        tVO.setTreasury(tVO.getTreasury()-50000);
        tVO.setHasApothecary(true);
        System.err.print("Saving:"+tVO);
        return tBO.updateTeamWithGeneratedTV(tVO);
    }

    @Override
    public TeamVO fireApothForTeam(int teamId) throws Exception {
        TeamVO tVO = tBO.getTeamById
(teamId, false);
        if (!tVO.isHasApothecary()) throw new WarnException("Apothecary Does't Exist");
        tVO.setHasApothecary(false);
        return tBO.updateTeamWithGeneratedTV(tVO);
    }

    @Override
    public TeamVO removeRerollForTeam(int teamId) throws Exception {
        TeamVO tVO = tBO.getTeamById(teamId, true);
        if (tVO.getRerolls() < 1) throw new WarnException("Can't remove more rerolls");;
        tVO.setRerolls(tVO.getRerolls()-1);
        return tBO.updateTeamWithGeneratedTV(tVO);
    }

    @Override
    public TeamVO buyRerollForTeam(int teamId) throws Exception {
        TeamVO tVO = tBO.getTeamById(teamId, true);
        if (tVO.getRerolls() >= 8) throw new WarnException("Rerolls maxed");
        int rerollCost = tVO.getTeamTemplateVO().getRerollCost();
        if (isExperienced()) { rerollCost = rerollCost*2; }
        if (tVO.getTreasury() < rerollCost) throw new WarnException("Not enough funds");
        tVO.setRerolls(tVO.getRerolls()+1);
        return tBO.updateTeamWithGeneratedTV(tVO);
    }

    private boolean isExperienced() {
        return true;
    }

    @Override
    public PlayerVO unhireRookiePlayerForTeam(int playerId) throws Exception {
        return null;
    }    
}
