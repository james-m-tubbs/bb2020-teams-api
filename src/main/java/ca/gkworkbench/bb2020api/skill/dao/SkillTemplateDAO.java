package ca.gkworkbench.bb2020api.skill.dao;

import ca.gkworkbench.bb2020api.skill.vo.SkillVO;

import java.util.List;

public interface SkillTemplateDAO {

    public List<SkillVO> getBaseSkillsByPlayerTemplateId(int id) throws Exception;

}
