package ca.gkworkbench.bb2020api.player.template.bo;

import ca.gkworkbench.bb2020api.player.template.vo.PlayerTemplateVO;

import java.util.List;

public interface PlayerTemplateBO {

    public List<PlayerTemplateVO> getPlayerTemplatesByTeamId(int teamId);
}
