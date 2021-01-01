package ca.gkworkbench.bb2020api.skill.dao.impl;

import ca.gkworkbench.bb2020api.skill.dao.SkillTemplateDAO;
import ca.gkworkbench.bb2020api.skill.vo.SkillVO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SkillTemplateDAOImpl extends JdbcDaoSupport implements SkillTemplateDAO {

    private final String SELECT_SKILLS_BY_PLAYER_ID = "SELECT S.id as id, s.skill as skill, s.type as type, st.skillValue as skillValue FROM SKILLS S, SKILLTEMPLATE ST WHERE S.id = ST.skillId AND ST.playerTemplateId = ? ORDER BY ID;";

    @Override
    public List<SkillVO> getBaseSkillsByPlayerTemplateId(int id) throws Exception {
        return getJdbcTemplate().query(SELECT_SKILLS_BY_PLAYER_ID, new SkillTemplateDAOImpl.SkillRowMapper(), new Object[]{id});
    }

    //teamTemplateId, position, linemanFlag, QTY, cost, MA, ST, AG, PA, AV
    public class SkillRowMapper implements RowMapper {
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            SkillVO sVO = new SkillVO(
                    rs.getInt("id"),
                    rs.getString("skill"),
                    rs.getString("type")
            );
            String skillValue = rs.getString("skillValue");
            if (skillValue != null && skillValue.length() > 0) {
                sVO.setSkill(sVO.getSkill()+"("+skillValue+")");
            }
            return sVO;
        }
    }
}
