package ca.gkworkbench.bb2020api.skill.dao;

import ca.gkworkbench.bb2020api.player.vo.PlayerTemplateVO;
import ca.gkworkbench.bb2020api.skill.vo.SkillVO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SkillTemplateDAOImpl extends JdbcDaoSupport implements SkillTemplateDAO {

    private final String SELECT_SKILL_BY_ID = "SELECT * FROM skillTemplate where id = ?;";

    @Override
    public List<SkillVO> getSkillTemplateByPlayerID(int id) throws Exception {
        //return (PlayerTemplateVO)getJdbcTemplate().queryForObject(SELECT_ONE_SQL, new PlayerTemplateDAOImpl.PlayerTemplateRowMapper(), new Object[]{id});
        return null;
    }

    //teamTemplateId, position, linemanFlag, QTY, cost, MA, ST, AG, PA, AV
    public class PlayerTemplateRowMapper implements RowMapper {
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            boolean linemanFlag = false;
            if (rs.getString("linemanFLag").equalsIgnoreCase("Y")) linemanFlag = true;

            PlayerTemplateVO ptVO = new PlayerTemplateVO(
                    rs.getInt("id"),
                    rs.getInt("teamTemplateId"),
                    rs.getString("position"),
                    linemanFlag,
                    rs.getInt("qty"),
                    rs.getInt("cost"),
                    rs.getInt("ma"),
                    rs.getInt("st"),
                    rs.getInt("ag"),
                    rs.getInt("pa"),
                    rs.getInt("av"),
                    null,
                    null,
                    null
            );
            return ptVO;
        }
    }
}
