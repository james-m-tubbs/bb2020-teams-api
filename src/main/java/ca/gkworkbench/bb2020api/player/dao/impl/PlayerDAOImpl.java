package ca.gkworkbench.bb2020api.player.dao.impl;

import ca.gkworkbench.bb2020api.player.dao.PlayerDAO;
import ca.gkworkbench.bb2020api.player.vo.PlayerVO;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PlayerDAOImpl extends JdbcDaoSupport implements PlayerDAO {

    public final String INSERT_NEW_PLAYER_SQL = "INSERT INTO Players(teamId, playerTemplateId, name) values (?, ?, ?);";
    @Override
    public void createPlayer(PlayerVO playerVO) throws Exception {
        getJdbcTemplate().update(
                INSERT_NEW_PLAYER_SQL,
                playerVO.getTeamId(),
                playerVO.getPlayerTemplateId(),
                playerVO.getName()
        );
    }

    private final String SELECT_ONE_SQL = "SELECT p.id as playerId, pt.id as playerTemplateId, p.teamId, p.name, p.spp, p.currentValue, p.cp, p.pi, p.cas, p.td, p.td, p.mvp, p.injuredFlag, p.tempRetiredFlag, p.firedFlag, pt.teamTemplateId, pt.position, pt.linemanFlag, pt.qty, pt.cost, pt.ma, pt.st, pt.ag, pt.pa, pt.av, pt.primarySkills, pt.secondarySkills, pt.onePerTeamFlag from Players p, PlayerTemplate pt where p.playerTemplateId = pt.id and p.id = ?";
    @Override
    public PlayerVO getPlayerById(int playerId) throws Exception {
        try {
            return (PlayerVO) getJdbcTemplate().queryForObject(SELECT_ONE_SQL, new PlayerDAOImpl.PlayerRowMapper(), new Object[]{playerId});
        } catch (EmptyResultDataAccessException e) {
                return null;
        }
    }

    @Override
    public boolean updatePlayer(PlayerVO playerVO) throws Exception {
        return false;
    }

    @Override
    public boolean deletePlayer(int playerId) throws Exception {
        return false;
    }

    private final String SELECT_BY_TEAM_SQL = "SELECT p.id as playerId, pt.id as playerTemplateId, p.teamId, p.name, p.spp, p.currentValue, p.cp, p.pi, p.cas, p.td, p.td, p.mvp, p.injuredFlag, p.tempRetiredFlag, p.firedFlag, pt.teamTemplateId, pt.position, pt.linemanFlag, pt.qty, pt.cost, pt.ma, pt.st, pt.ag, pt.pa, pt.av, pt.primarySkills, pt.secondarySkills, pt.onePerTeamFlag from Players p, PlayerTemplate pt where p.playerTemplateId = pt.id and p.teamId = ?";
    @Override
    public List<PlayerVO> getPlayersForTeamId(int teamId) throws Exception {
        return (List<PlayerVO>)getJdbcTemplate().query(SELECT_BY_TEAM_SQL, new PlayerDAOImpl.PlayerRowMapper(), new Object[]{teamId});
    }

    private final String SELECT_BY_NAME_AND_TEAM = "SELECT p.id as playerId, pt.id as playerTemplateId, p.teamId, p.name, p.spp, p.currentValue, p.cp, p.pi, p.cas, p.td, p.td, p.mvp, p.injuredFlag, p.tempRetiredFlag, p.firedFlag, pt.teamTemplateId, pt.position, pt.linemanFlag, pt.qty, pt.cost, pt.ma, pt.st, pt.ag, pt.pa, pt.av, pt.primarySkills, pt.secondarySkills, pt.onePerTeamFlag from Players p, PlayerTemplate pt where p.playerTemplateId = pt.id and p.teamId = ? and p.name = ?";
    @Override
    public PlayerVO getPlayerForNameAndTeam(int teamId, String name) throws Exception {
        try {
            return (PlayerVO) getJdbcTemplate().queryForObject(SELECT_BY_NAME_AND_TEAM, new PlayerDAOImpl.PlayerRowMapper(), new Object[]{teamId, name});
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public class PlayerRowMapper implements RowMapper
    {
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            boolean linemanFlag = false;
            if (rs.getString("linemanFlag").equalsIgnoreCase("Y")) linemanFlag = true;

            boolean injuredFlag = false;
            if (rs.getString("injuredFlag").equalsIgnoreCase("Y")) injuredFlag = true;

            boolean tempRetiredFlag = false;
            if (rs.getString("tempRetiredFlag").equalsIgnoreCase("Y")) tempRetiredFlag = true;

            boolean firedFlag = false;
            if (rs.getString("firedFlag").equalsIgnoreCase("Y")) firedFlag = true;

            boolean onePerTeam = false;
            if (rs.getString("onePerTeamFlag").equalsIgnoreCase("Y")) onePerTeam = true;


            PlayerVO pVO = new PlayerVO(
                //int playerTemplateId,
                    rs.getInt("playerTemplateId"),
                    // int teamTemplateId,
                    rs.getInt("teamTemplateId"),
                    // String position,
                    rs.getString("position"),
                    // boolean linemanFlag,
                    linemanFlag,
                    // int qty,
                    rs.getInt("qty"),
                    // int cost,
                    rs.getInt("cost"),
                    // int MA,
                    rs.getInt("ma"),
                    // int ST,
                    rs.getInt("st"),
                    // int AG,
                    rs.getInt("ag"),
                    // int PA,
                    rs.getInt("pa"),
                    // int AV,
                    rs.getInt("av"),
                    // List<SkillVO > baseSkills,
                    null,
                    // String primary,
                    rs.getString("primarySkills"),
                    // String secondary,
                    rs.getString("secondarySkills"),
                    //onePerTeamFlag
                    onePerTeam,
                    // int playerId,
                    rs.getInt("playerId"),
                    // int teamId,
                    rs.getInt("teamId"),
                    // String name,
                    rs.getString("name"),
                    // int spp,
                    rs.getInt("spp"),
                    // int currentValue,
                    rs.getInt("currentValue"),
                    // int cp,
                    rs.getInt("cp"),
                    // int pi,
                    rs.getInt("pi"),
                    // int cas,
                    rs.getInt("cas"),
                    // int td,
                    rs.getInt("td"),
                    // int mvp,
                    rs.getInt("mvp"),
                    injuredFlag,
                    tempRetiredFlag,
                    firedFlag,
                    null
            );
            return pVO;
        }

    }
}
