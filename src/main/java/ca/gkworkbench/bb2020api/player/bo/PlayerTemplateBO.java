package ca.gkworkbench.bb2020api.player.bo;

import ca.gkworkbench.bb2020api.player.vo.PlayerTemplateVO;

import java.util.List;

public interface PlayerTemplateBO {

    public List<PlayerTemplateVO> getPlayerTemplatesByTeamId(int teamId) throws Exception;

    public PlayerTemplateVO getPlayerTemplateById(int id) throws Exception;

    public String getJsonPlayerTemplateById(int id) throws Exception;
}
