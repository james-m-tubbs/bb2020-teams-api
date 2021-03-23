package ca.gkworkbench.bb2020api.player.bo;

import ca.gkworkbench.bb2020api.player.vo.PlayerTemplateVO;
import ca.gkworkbench.bb2020api.player.vo.PlayerVO;
import ca.gkworkbench.bb2020api.skill.vo.SkillVO;

import java.util.List;

public interface PlayerBO {

    public List<PlayerVO> getPlayersByTeamId(int teamId) throws Exception;

    public String getJsonPlayerList(List<PlayerVO> pVOs) throws Exception;

    public PlayerVO getPlayerById(int playerId) throws Exception;

    public String getJsonPlayer(PlayerVO pVO) throws Exception;

    public PlayerVO createPlayerFromTemplateId(int teamId, int teamTemplateId, int playerTemplateId, String playerName) throws Exception;

    public boolean checkForHiringExceptions(int teamId, int teamTemplateId, PlayerTemplateVO ptVO) throws Exception;

    public boolean firePlayerVO(PlayerVO pVO) throws Exception;

    public boolean temporarilyRetirePlayerVO(PlayerVO pVO) throws Exception;

    public PlayerVO getPlayerDetails(PlayerVO pVO) throws Exception;

    public List<SkillVO> getAvailablePlayerSkills(int playerId) throws Exception;

    public PlayerVO buyPlayerSkill(int skillId) throws Exception;

    public PlayerVO buyRandomPrimarySkill(PlayerVO pVO, boolean isSecondary) throws Exception;

    public PlayerVO addInjury(int injuryId) throws Exception;
}
