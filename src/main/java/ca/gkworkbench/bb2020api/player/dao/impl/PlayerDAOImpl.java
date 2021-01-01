package ca.gkworkbench.bb2020api.player.dao.impl;

import ca.gkworkbench.bb2020api.player.dao.PlayerDAO;
import ca.gkworkbench.bb2020api.player.vo.PlayerTemplateVO;
import ca.gkworkbench.bb2020api.player.vo.PlayerVO;
import ca.gkworkbench.bb2020api.skill.vo.SkillVO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PlayerDAOImpl extends JdbcDaoSupport implements PlayerDAO {
    @Override
    public PlayerVO createPlayer(PlayerVO playerVO) throws Exception {
        return null;
    }

    //id int NOT NULL AUTO_INCREMENT, teamId int NOT NULL, PlayerTemplateId int NOT NULL, name VARCHAR(255), spp int NOT NULL DEFAULT 0, currentValue int NOT NULL default 0, cp int NOT NULL default 0, pi int NOT NULL default 0, cas int NOT NULL default 0, td int NOT NULL default 0, mvp cas int NOT NULL default 0, injuredFlag char(1) NOT NULL DEFAULT 'N', tempRetiredFlag char(1) NOT NULL DEFAULT 'N', firedFlag char(1) NOT NULL DEFAULT 'N', PRIMARY KEY(id), FOREIGN KEY (TeamId) REFERENCES Teams(id), FOREIGN KEY(PlayerTemplateId) REFERENCES PlayerTemplate(id));
    //id int NOT NULL AUTO_INCREMENT, teamTemplateId int NOT NULL, position varchar(255) NOT NULL, linemanFlag char(1) NOT NULL, qty int NOT NULL, cost int NOT NULL, ma int NOT NULL, st int NOT NULL, ag int NOT NULL, pa int NOT NULL, av int NOT NULL, primary_skills VARCHAR(255), secondary_skills VARCHAR(255), PRIMARY KEY (id), FOREIGN KEY(teamTemplateId) REFERENCES TeamTemplate(id));
    private final String SELECT_ONE_SQL = "SELECT p.id as playerId, pt.id as playerTemplateId, p.teamId, p.name, p.spp, p.currentValue, p.cp, p.pi, p.cas, p.td, p.td, p.mvp, p.injuredFlag, p.tempRetiredFlag, p.firedFlag, pt.teamTemplateId, pt.position, pt.linemanFlag, pt.qty, pt.cost, pt.ma, pt.st, pt.ag, pt.pa, pt.av, pt.primary_skills, pt.secondary_skills from Players p, PlayerTemplate pt where p.playerTemplateId = pt.id and p.id = ?";
    @Override
    public PlayerVO getPlayerById(int playerId) throws Exception {
        return (PlayerVO)getJdbcTemplate().queryForObject(SELECT_ONE_SQL, new PlayerDAOImpl.PlayerRowMapper(), new Object[]{playerId});
    }

    @Override
    public boolean updatePlayer(PlayerVO playerVO) throws Exception {
        return false;
    }

    @Override
    public boolean deletePlayer(int playerId) throws Exception {
        return false;
    }

    @Override
    public List<PlayerVO> getPlayersForTeamId(int teamId) throws Exception {
        return null;
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
                    rs.getString("primary_skills"),
                    // String secondary,
                    rs.getString("secondary_skills"),
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
