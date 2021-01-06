package ca.gkworkbench.bb2020api.player.dao.impl;

import ca.gkworkbench.bb2020api.player.dao.PlayerTemplateDAO;
import ca.gkworkbench.bb2020api.player.vo.PlayerTemplateVO;
import org.springframework.dao.EmptyResultDataAccessException;
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
        try {
            return (PlayerTemplateVO) getJdbcTemplate().queryForObject(SELECT_ONE_SQL, new PlayerTemplateRowMapper(), new Object[]{id});
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    //teamTemplateId, position, linemanFlag, QTY, cost, MA, ST, AG, PA, AV
    public class PlayerTemplateRowMapper implements RowMapper
    {
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            boolean linemanFlag = false;
            if (rs.getString("linemanFlag").equalsIgnoreCase("Y")) linemanFlag = true;
            boolean bigGuyFlag = false;
            if (rs.getString("bigGuyFlag").equalsIgnoreCase("Y")) bigGuyFlag = true;

            PlayerTemplateVO ptVO = new PlayerTemplateVO(
                    rs.getInt("id"),
                    rs.getInt("teamTemplateId"),
                    rs.getString("position"),
                    linemanFlag,
                    bigGuyFlag,
                    rs.getInt("qty"),
                    rs.getInt("cost"),
                    rs.getInt("ma"),
                    rs.getInt("st"),
                    rs.getInt("ag"),
                    rs.getInt("pa"),
                    rs.getInt("av"),
                    null,
                    rs.getString("primarySkills"),
                    rs.getString("secondarySkills")
            );
            return ptVO;
        }

    }
}
