package ca.gkworkbench.bb2020api.skill.dao;

import ca.gkworkbench.bb2020api.skill.vo.SkillVO;

import java.util.List;

public interface PlayerSkillsDAO {
    public List<SkillVO> getPrimarySkillsByPlayerTemplateId(int playerTemplateId) throws Exception ;
    public List<SkillVO> getSecondarySkillsByPlayerTemplateId(int playerTemplateId) throws Exception ;

    public SkillVO addPlayerSkill(SkillVO skillVO, int playerId, int cost);
}
