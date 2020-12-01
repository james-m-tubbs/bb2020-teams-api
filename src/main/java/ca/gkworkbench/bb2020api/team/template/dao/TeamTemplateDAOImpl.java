package ca.gkworkbench.bb2020api.team.template.dao;

import ca.gkworkbench.bb2020api.team.template.vo.TeamTemplateVO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TeamTemplateDAOImpl extends JdbcDaoSupport implements TeamTemplateDAO {

//        teamTemplateID int NOT NULL AUTO_INCREMENT, -- PK ID
//        teamTemplateName varchar(255) NOT NULL, -- dwarves
//        rerollCost int NOT NULL, -- 50k
//        tier int NOT NULL, -- i don't know what this is yet?
//        specialRules varchar(255),

    private final String SELECT_ONE_SQL = "SELECT * FROM TeamTemplate where id = ?;";

    @Override
    public TeamTemplateVO getTeamTemplateByID(int teamTemplateId) throws Exception {
        return (TeamTemplateVO)getJdbcTemplate().queryForObject(SELECT_ONE_SQL, new TeamTemplateRowMapper(), new Object[]{teamTemplateId});
    }

    private final String SELECT_ALL_SQL = "SELECT * FROM TeamTemplate;";

    @Override
    public List<TeamTemplateVO> getTeamList() throws Exception {
        return getJdbcTemplate().query(SELECT_ALL_SQL, new TeamTemplateRowMapper());
    }

    public class TeamTemplateRowMapper implements RowMapper
    {
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            boolean apothecary = false;
            if (rs.getString("apothecary").equalsIgnoreCase("Y")) apothecary = true;

            TeamTemplateVO ttVO = new TeamTemplateVO(
                    rs.getInt("id"),
                    rs.getString("teamTemplateName"),
                    rs.getInt("rerollCost"),
                    rs.getInt("tier"),
                    rs.getString("specialRules"),
                    apothecary,
                    null
            );
            return ttVO;
        }

    }
}
