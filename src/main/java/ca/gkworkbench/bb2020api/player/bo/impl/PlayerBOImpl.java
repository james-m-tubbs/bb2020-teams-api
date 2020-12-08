package ca.gkworkbench.bb2020api.player.bo.impl;

import ca.gkworkbench.bb2020api.player.bo.PlayerBO;
import ca.gkworkbench.bb2020api.player.vo.PlayerTemplateVO;
import ca.gkworkbench.bb2020api.player.vo.PlayerVO;

import java.util.List;

public class PlayerBOImpl implements PlayerBO {
    @Override
    public List<PlayerVO> getPlayersByTeamId(int teamId) throws Exception {
        return null;
    }

    @Override
    public PlayerVO getPlayerById(int playerId) throws Exception {
        return null;
    }

    @Override
    public List<PlayerTemplateVO> getAvailablePlayersForTeam(int playerTemplateId) throws Exception {
        return null;
    }

    @Override
    public int createPlayerFromTemplate(int playerTemplateId) throws Exception {
        return 0;
    }
}
