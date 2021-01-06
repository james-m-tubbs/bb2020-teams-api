package ca.gkworkbench.bb2020api.player.dao.impl;

import ca.gkworkbench.bb2020api.player.dao.PlayerDAO;
import ca.gkworkbench.bb2020api.player.vo.PlayerVO;
import ca.gkworkbench.bb2020api.team.vo.TeamVO;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PlayerDAOImpl extends JdbcDaoSupport implements PlayerDAO {

    private final String INSERT_NEW_PLAYER_SQL = "INSERT INTO Players(teamId, playerTemplateId, name, currentValue) values (?, ?, ?, ?);";
    @Override
    public void createPlayer(PlayerVO playerVO) throws Exception {
        getJdbcTemplate().update(
                INSERT_NEW_PLAYER_SQL,
                playerVO.getTeamId(),
                playerVO.getPlayerTemplateId(),
                playerVO.getName(),
                playerVO.getCurrentValue()
        );
    }

    private final String SELECT_ONE_SQL = "SELECT p.id as playerId, pt.id as playerTemplateId, p.teamId, p.name, p.spp, p.currentValue, p.cp, p.pi, p.cas, p.td, p.mvp, p.injuredFlag, p.tempRetiredFlag, p.firedFlag, pt.teamTemplateId, pt.position, pt.linemanFlag, pt.bigGuyFlag, pt.qty, pt.cost, pt.ma, pt.st, pt.ag, pt.pa, pt.av, pt.primarySkills, pt.secondarySkills, p.gamesPlayed from Players p, PlayerTemplate pt where p.playerTemplateId = pt.id and p.id = ?";
    @Override
    public PlayerVO getPlayerById(int playerId) throws Exception {
        try {
            return (PlayerVO) getJdbcTemplate().queryForObject(SELECT_ONE_SQL, new PlayerDAOImpl.PlayerRowMapper(), new Object[]{playerId});
        } catch (EmptyResultDataAccessException e) {
                return null;
        }
    }

    //p.id as playerId, pt.id as playerTemplateId, p.teamId, p.name, p.spp, p.currentValue, p.cp, p.pi, p.cas, p.td, p.td, p.mvp, p.injuredFlag, p.tempRetiredFlag, p.firedFlag
    private final String UPDATE_ONE_QUERY = "UPDATE Players set teamId = ?, name = ?, spp = ?, currentValue = ?, cp = ?, pi = ?, cas = ?, td = ?, mvp = ?, injuredFlag = ?, tempRetiredFlag = ?, firedFlag= ?, gamesPlayed = ? WHERE id = ?";
    @Override
    public boolean updatePlayer(PlayerVO playerVO) throws Exception {
        String injuredFlag = "N";
        if (playerVO.isInjured()) injuredFlag = "Y";
        String tempRetiredFlag = "N";
        if (playerVO.isTempRetired()) tempRetiredFlag = "Y";
        String firedFlag = "N";
        if (playerVO.isFired()) firedFlag = "Y";

        return getJdbcTemplate().update(
                UPDATE_ONE_QUERY,
                playerVO.getTeamId(),
                playerVO.getName(),
                playerVO.getSpp(),
                playerVO.getCurrentValue(),
                playerVO.getCp(),
                playerVO.getPi(),
                playerVO.getCas(),
                playerVO.getTd(),
                playerVO.getMvp(),
                injuredFlag,
                tempRetiredFlag,
                firedFlag,
                playerVO.getGamesPlayed(),
                playerVO.getPlayerId()
        ) == 1;

    }

    private final String SELECT_BY_TEAM_SQL = "SELECT p.id as playerId, pt.id as playerTemplateId, p.teamId, p.name, p.spp, p.currentValue, p.cp, p.pi, p.cas, p.td, p.td, p.mvp, p.injuredFlag, p.tempRetiredFlag, p.firedFlag, pt.teamTemplateId, pt.position, pt.linemanFlag, pt.bigGuyFlag, pt.qty, pt.cost, pt.ma, pt.st, pt.ag, pt.pa, pt.av, pt.primarySkills, pt.secondarySkills, p.gamesPlayed from Players p, PlayerTemplate pt where p.playerTemplateId = pt.id and p.teamId = ?";
    @Override
    public List<PlayerVO> getPlayersForTeamId(int teamId) throws Exception {
        return (List<PlayerVO>)getJdbcTemplate().query(SELECT_BY_TEAM_SQL, new PlayerDAOImpl.PlayerRowMapper(), new Object[]{teamId});
    }

    private final String SELECT_BY_NAME_AND_TEAM = "SELECT p.id as playerId, pt.id as playerTemplateId, p.teamId, p.name, p.spp, p.currentValue, p.cp, p.pi, p.cas, p.td, p.td, p.mvp, p.injuredFlag, p.tempRetiredFlag, p.firedFlag, pt.teamTemplateId, pt.position, pt.linemanFlag, pt.bigGuyFlag, pt.qty, pt.cost, pt.ma, pt.st, pt.ag, pt.pa, pt.av, pt.primarySkills, pt.secondarySkills, p.gamesPlayed from Players p, PlayerTemplate pt where p.playerTemplateId = pt.id and p.teamId = ? and p.name = ?";
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

            boolean bigGuyFlag = false;
            if (rs.getString("bigGuyFlag").equalsIgnoreCase("Y")) bigGuyFlag = true;

            boolean injuredFlag = false;
            if (rs.getString("injuredFlag").equalsIgnoreCase("Y")) injuredFlag = true;

            boolean tempRetiredFlag = false;
            if (rs.getString("tempRetiredFlag").equalsIgnoreCase("Y")) tempRetiredFlag = true;

            boolean firedFlag = false;
            if (rs.getString("firedFlag").equalsIgnoreCase("Y")) firedFlag = true;

            PlayerVO pVO = new PlayerVO(
                //int playerTemplateId,
                    rs.getInt("playerTemplateId"),
                    // int teamTemplateId,
                    rs.getInt("teamTemplateId"),
                    // String position,
                    rs.getString("position"),
                    // boolean linemanFlag,
                    linemanFlag,
                    // boolean bigGuyFlag,
                    bigGuyFlag,
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
                    null,
                    rs.getInt("gamesPlayed")
            );
            return pVO;
        }

    }
}
