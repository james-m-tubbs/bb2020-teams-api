package ca.gkworkbench.bb2020api.player.dao;

import ca.gkworkbench.bb2020api.player.vo.PlayerTemplateVO;

import java.util.List;

public interface PlayerTemplateDAO {

    public List<PlayerTemplateVO> getPlayerTemplateListByTeamTemplateId(int teamTemplateId) throws Exception;

    public PlayerTemplateVO getPlayerTemplateVOById(int id) throws Exception;
}
