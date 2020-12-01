package ca.gkworkbench.bb2020api.player.template.dao;

import ca.gkworkbench.bb2020api.player.template.vo.PlayerTemplateVO;
import ca.gkworkbench.bb2020api.team.template.dao.TeamTemplateDAO;
import ca.gkworkbench.bb2020api.team.template.vo.TeamTemplateVO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PlayerTemplateDAOImpl extends JdbcDaoSupport implements PlayerTemplateDAO {

    private final String SELECT_BY_TEAM_SQL = "SELECT * FROM PlayerTemplate where teamTemplateID = ?;";

    @Override
    public List<PlayerTemplateVO> getPlayerTemplateListByTeamTemplateId(int teamTemplateId) throws Exception {
        return getJdbcTemplate().query(SELECT_BY_TEAM_SQL, new PlayerTemplateRowMapper(), new Object[]{teamTemplateId});
    }

    private final String SELECT_ONE_SQL = "SELECT * FROM PlayerTemplate where id = ?;";

    @Override
    public PlayerTemplateVO getPlayerTemplateVOById(int id) throws Exception {
        return (PlayerTemplateVO)getJdbcTemplate().queryForObject(SELECT_ONE_SQL, new PlayerTemplateRowMapper(), new Object[]{id});
    }

    //teamTemplateId, position, linemanFlag, QTY, cost, MA, ST, AG, PA, AV
    public class PlayerTemplateRowMapper implements RowMapper
    {
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
