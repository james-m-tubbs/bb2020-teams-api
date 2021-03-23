package ca.gkworkbench.bb2020api.skill.dao.impl;

import ca.gkworkbench.bb2020api.skill.dao.PlayerSkillsDAO;
import ca.gkworkbench.bb2020api.skill.vo.SkillVO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PlayerSkillsDAOImpl extends JdbcDaoSupport  implements PlayerSkillsDAO {

    private final String SELECT_PRIMARY_SKILLS_BY_PLAYER_TEMPLATE_ID =
    "SELECT " +
            "S.id as id, " +
            "s.skill as skill, " +
            "s.type as type, " +
            "st.skillValue as skillValue " +
            "FROM " +
            "SKILLS S, " +
            "SKILLTEMPLATE ST " +
            "WHERE " +
            "S.id = ST.skillId " +
            "AND ST.playerTemplateId = ? " +
            "AND s.type in (" +
            "select primarySkills from PlayerTemplate where id = ?)" +
            "ORDER BY ID;";

    @Override
    public List<SkillVO> getPrimarySkillsByPlayerTemplateId(int playerTemplateId) throws Exception {
        return getJdbcTemplate().query(SELECT_PRIMARY_SKILLS_BY_PLAYER_TEMPLATE_ID, new PlayerSkillsDAOImpl.SkillRowMapper(), new Object[]{playerTemplateId, playerTemplateId});
    }

    private final String SELECT_SECONDARY_SKILLS_BY_PLAYER_TEMPLATE_ID =
            "SELECT " +
                    "S.id as id, " +
                    "s.skill as skill, " +
                    "s.type as type, " +
                    "st.skillValue as skillValue " +
                    "FROM " +
                    "SKILLS S, " +
                    "SKILLTEMPLATE ST " +
                    "WHERE " +
                    "S.id = ST.skillId " +
                    "AND ST.playerTemplateId = ? " +
                    "AND s.type in (" +
                    "select secondarySkills from PlayerTemplate where id = ?)" +
                    "ORDER BY ID;";
    @Override
    public List<SkillVO> getSecondarySkillsByPlayerTemplateId(int playerTemplateId) throws Exception {
        List<SkillVO> returnSkills = getJdbcTemplate().query(SELECT_SECONDARY_SKILLS_BY_PLAYER_TEMPLATE_ID, new PlayerSkillsDAOImpl.SkillRowMapper(), new Object[]{playerTemplateId, playerTemplateId});
        for (int i=0; i<returnSkills.size(); i++) {
            returnSkills.get(i).setSecondary(true);
        }
        return returnSkills;
    }

    @Override
    public SkillVO addPlayerSkill(SkillVO skillVO, int playerId, int cost) {
        return null;
    }

    //teamTemplateId, position, linemanFlag, QTY, cost, MA, ST, AG, PA, AV
    public class SkillRowMapper implements RowMapper {
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            SkillVO sVO = new SkillVO(
                    rs.getInt("id"),
                    rs.getString("skill"),
                    rs.getString("type"),
                    false
            );
            String skillValue = rs.getString("skillValue");
            if (skillValue != null && skillValue.length() > 0) {
                sVO.setSkill(sVO.getSkill()+" ("+skillValue+")");
            }
            return sVO;
        }
    }
}
