package ca.gkworkbench.bb2020api.team.dao.impl;

import ca.gkworkbench.bb2020api.team.dao.TeamsDAO;
import ca.gkworkbench.bb2020api.team.vo.TeamVO;
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
        return (TeamVO)getJdbcTemplate().queryForObject(SELECT_ONE_SQL_BY_TEAM_ID, new TeamsDAOImpl.TeamRowMapper(), new Object[]{teamId});
    }

    private final String SELECT_ONE_SQL_BY_TEAMNAME = "SELECT * from Teams where teamName = ?";
    @Override
    public TeamVO getTeamByName(String teamName) throws Exception {
        return (TeamVO)getJdbcTemplate().queryForObject(SELECT_ONE_SQL_BY_TEAMNAME, new TeamsDAOImpl.TeamRowMapper(), new Object[]{teamName});
    }

    private final String SELECT_TEAMS_BY_COACH = "SELECT * FROM Teams where CoachId = ?";
    @Override
    public List<TeamVO> getTeamVOsByCoachId(int coachId) throws Exception {
        return (List<TeamVO>)getJdbcTemplate().queryForObject(SELECT_TEAMS_BY_COACH, new TeamsDAOImpl.TeamRowMapper(), new Object[]{coachId});
    }

    private final String INSERT_ONE_QUERY = "INSERT INTO Teams (coachId, teamTemplateId, teamName, totalCas, totalTouchdowns, treasury, leaguePoints, rerolls, coaches, cheerleaders, apothecaryFlag, teamValue) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    @Override
    public void insertTeamVO(TeamVO teamVO) throws Exception {
        String apoth = "N";
        if (teamVO.isHasApothecary()) apoth = "Y";
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
                teamVO.getTeamValue()
                );
    }

    private final String UPDATE_ONE_QUERY = "UPDATE Teams set (coachId, teamTemplateId, teamName, totalCas, totalTouchdowns, treasury, leaguePoints, rerolls, coaches, cheerleaders, apothecaryFlag, teamValue) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) WHERE id = ?";
    @Override
    public void updateTeamVO(TeamVO teamVO) throws Exception {
        String apoth = "N";
        if (teamVO.isHasApothecary()) apoth = "Y";
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
                teamVO.getId()
        );
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
                    // we don't know the players yet
                    null,
                    null
            );
            return tVO;
        }

    }
}