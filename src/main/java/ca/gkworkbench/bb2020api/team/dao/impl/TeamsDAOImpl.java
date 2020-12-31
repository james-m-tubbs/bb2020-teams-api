package ca.gkworkbench.bb2020api.team.dao.impl;

import ca.gkworkbench.bb2020api.team.dao.TeamsDAO;
import ca.gkworkbench.bb2020api.team.vo.TeamVO;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TeamsDAOImpl extends JdbcDaoSupport implements TeamsDAO {

    //private final String SELECT_ONE_SQL = "SELECT * FROM Teams where id = ?";
    private final String SELECT_ONE_SQL_BY_TEAM_ID = "SELECT * from Teams where id = ?";
    @Override
    public TeamVO getTeamById(int teamId) throws Exception {
        try {
            return (TeamVO) getJdbcTemplate().queryForObject(SELECT_ONE_SQL_BY_TEAM_ID, new TeamsDAOImpl.TeamRowMapper(), new Object[]{teamId});
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    private final String SELECT_ONE_SQL_BY_TEAMNAME = "SELECT * from Teams where teamName = ?";
    @Override
    public TeamVO getTeamByName(String teamName) throws Exception {
        try {
            return (TeamVO)getJdbcTemplate().queryForObject(SELECT_ONE_SQL_BY_TEAMNAME, new TeamsDAOImpl.TeamRowMapper(), new Object[]{teamName});
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    private final String SELECT_TEAMS_BY_COACH = "SELECT * FROM Teams where CoachId = ?";
    @Override
    public List<TeamVO> getTeamVOsByCoachId(int coachId) throws Exception {
        try {
            return (List<TeamVO>)getJdbcTemplate().query(SELECT_TEAMS_BY_COACH, new TeamsDAOImpl.TeamRowMapper(), new Object[]{coachId});
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    private final String INSERT_ONE_QUERY = "INSERT INTO Teams (coachId, teamTemplateId, teamName, totalCas, totalTouchdowns, treasury, leaguePoints, rerolls, coaches, cheerleaders, apothecaryFlag, teamValue, currentTeamValue, dedicatedFans) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    @Override
    public void insertTeamVO(TeamVO teamVO) throws Exception {
        String apoth = "N";
        if (teamVO.hasApothecary()) apoth = "Y";
        getJdbcTemplate().update(
                INSERT_ONE_QUERY,
                teamVO.getCoachId(),
                teamVO.getTeamTemplateId(),
                teamVO.getTeamName(),
                teamVO.getTotalCAS(),
                teamVO.getTotalTouchdowns(),
                teamVO.getTreasury(),
                teamVO.getLeaguePoints(),
                teamVO.getRerolls(),
                teamVO.getCoaches(),
                teamVO.getCheerleaders(),
                apoth,
                teamVO.getTeamValue(),
                teamVO.getCurrentTeamValue(),
                teamVO.getDedicatedFans()
                );
    }

    private final String UPDATE_ONE_QUERY = "UPDATE Teams set coachId = ?, teamTemplateId = ?, teamName = ?, totalCas = ?, totalTouchdowns = ?, treasury = ?, leaguePoints = ?, rerolls = ?, coaches = ?, cheerleaders = ?, apothecaryFlag = ?, teamValue= ?, currentTeamValue = ?, dedicatedFans = ? WHERE id = ?";
    @Override
    public boolean updateTeamVO(TeamVO teamVO) throws Exception {
        String apoth = "N";
        if (teamVO.hasApothecary()) apoth = "Y";
        return getJdbcTemplate().update(
                UPDATE_ONE_QUERY,
                teamVO.getCoachId(),
                teamVO.getTeamTemplateId(),
                teamVO.getTeamName(),
                teamVO.getTotalCAS(),
                teamVO.getTotalTouchdowns(),
                teamVO.getTreasury(),
                teamVO.getLeaguePoints(),
                teamVO.getRerolls(),
                teamVO.getCoaches(),
                teamVO.getCheerleaders(),
                apoth,
                teamVO.getTeamValue(),
                teamVO.getCurrentTeamValue(),
                teamVO.getDedicatedFans(),
                teamVO.getId()
        ) == 1;
    }

    private final String DELETE_ONE_QUERY = "DELETE FROM Teams where id = ?";

    @Override
    public boolean deleteTeamVO(int teamId) throws Exception {
        return getJdbcTemplate().update(DELETE_ONE_QUERY, teamId) == 1;
    }

    /***********************************
     * RowMapper
     ************************************/
    public class TeamRowMapper implements RowMapper
    {
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            boolean apothecary = false;
            if (rs.getString("apothecaryFlag").equalsIgnoreCase("Y")) apothecary = true;

            TeamVO tVO = new TeamVO(
                    //CREATE TABLE Teams(id int NOT NULL AUTO_INCREMENT,
                    rs.getInt("id"),
                    // BBUserId int NOT NULL,
                    rs.getInt("coachId"),
                    // teamTemplateId int NOT NULL,
                    rs.getInt("teamTemplateId"),
                    //Team Type
                    rs.getString("teamName"),
                    // totalCas int NOT NULL DEFAULT 0,
                    rs.getInt("totalCas"),
                    // totalTouchdowns int NOT NULL DEFAULT 0,
                    rs.getInt("totalTouchdowns"),
                    // treasury int NOT NULL DEFAULT 1000000,
                    rs.getInt("treasury"),
                    // leaguePoints int NOT NULL DEFAULT 0,
                    rs.getInt("leaguePoints"),
                    // rerolls int NOT NULL DEFAULT 0,
                    rs.getInt("rerolls"),
                    // coaches int NOT NULL DEFAULT 0,
                    rs.getInt("coaches"),
                    // cheerleaders int NOT NULL DEFAULT 0,
                    rs.getInt("cheerleaders"),
                    // apothecaryFlag char(1),
                    apothecary,
                    // teamValue int NOT NULL DEFAULT 0,
                    rs.getInt("teamValue"),
                    // currentTeamValue int NOT NULL DEFAULT 0
                    rs.getInt("currentTeamValue"),
                    // dedicatedFans
                    rs.getInt("dedicatedFans"),
                    // we don't know the players yet
                    null,
                    null
            );
            return tVO;
        }

    }
}