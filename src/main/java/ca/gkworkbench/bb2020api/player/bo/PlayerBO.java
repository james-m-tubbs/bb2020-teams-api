package ca.gkworkbench.bb2020api.player.bo;

import ca.gkworkbench.bb2020api.player.vo.PlayerTemplateVO;
import ca.gkworkbench.bb2020api.player.vo.PlayerVO;

import java.util.List;

public interface PlayerBO {

    public List<PlayerVO> getPlayersByTeamId(int teamId) throws Exception;

    public PlayerVO getPlayerById(int playerId) throws Exception;

    public List<PlayerTemplateVO> getAvailablePlayersForTeam(int playerTemplateId) throws Exception;

    public int createPlayerFromTemplate(int playerTemplateId) throws Exception;
}
