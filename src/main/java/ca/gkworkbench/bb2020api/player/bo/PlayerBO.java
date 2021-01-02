package ca.gkworkbench.bb2020api.player.bo;

import ca.gkworkbench.bb2020api.player.vo.PlayerTemplateVO;
import ca.gkworkbench.bb2020api.player.vo.PlayerVO;

import java.util.List;

public interface PlayerBO {

    public List<PlayerVO> getPlayersByTeamId(int teamId) throws Exception;

    public PlayerVO getPlayerById(int playerId) throws Exception;

    public PlayerVO createPlayerFromTemplateId(int teamId, int teamTemplateId, int playerTemplateId, String playerName) throws Exception;

    boolean checkForHiringExceptions(int teamId, int teamTemplateId, PlayerTemplateVO ptVO) throws Exception;

    public boolean unhireRookiePlayerById(int playerId) throws Exception;

    public boolean firePlayerById(int playerId) throws Exception;

    public boolean temporarilyRetirePlayerById(int playerId) throws Exception;

    PlayerVO getPlayerDetails(PlayerVO pVO) throws Exception;
}
