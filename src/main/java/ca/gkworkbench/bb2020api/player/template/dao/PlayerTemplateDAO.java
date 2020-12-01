package ca.gkworkbench.bb2020api.player.template.dao;

import ca.gkworkbench.bb2020api.player.template.vo.PlayerTemplateVO;
import ca.gkworkbench.bb2020api.team.template.vo.TeamTemplateVO;

import java.util.List;

public interface PlayerTemplateDAO {

    public List<PlayerTemplateVO> getPlayerTemplateListByTeamTemplateId(int teamTemplateId) throws Exception;

    public PlayerTemplateVO getPlayerTemplateVOById(int id) throws Exception;
}
