package ca.gkworkbench.bb2020api.skill.dao;

import ca.gkworkbench.bb2020api.player.vo.PlayerTemplateVO;
import ca.gkworkbench.bb2020api.skill.vo.SkillTemplateVO;
import ca.gkworkbench.bb2020api.skill.vo.SkillVO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SkillTemplateDAOImpl extends JdbcDaoSupport implements SkillTemplateDAO {

    private final String SELECT_SKILLS_BY_PLAYER_ID = "SELECT * FROM SKILLS WHERE id IN (select skillId from skilltemplate where playerTemplateId = ?);";

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
            return sVO;
        }
    }
}
