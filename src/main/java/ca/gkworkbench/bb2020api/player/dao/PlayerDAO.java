package ca.gkworkbench.bb2020api.player.dao;

import ca.gkworkbench.bb2020api.player.vo.PlayerVO;

import java.util.List;

public interface PlayerDAO {

    public void createPlayer(PlayerVO playerVO) throws Exception;

    public PlayerVO getPlayerById(int playerId) throws Exception;

    public boolean updatePlayer(PlayerVO playerVO) throws Exception;

    public boolean deletePlayer(int playerId) throws Exception;

    public List<PlayerVO> getPlayersForTeamId(int teamId) throws Exception;

    public PlayerVO getPlayerForNameAndTeam(int teamId, String name) throws Exception;
}
