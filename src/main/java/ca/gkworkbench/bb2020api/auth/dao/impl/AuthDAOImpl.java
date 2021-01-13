package ca.gkworkbench.bb2020api.auth.dao.impl;

import ca.gkworkbench.bb2020api.auth.vo.TokenVO;
import ca.gkworkbench.bb2020api.auth.dao.AuthDAO;
import ca.gkworkbench.bb2020api.auth.vo.UserVO;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthDAOImpl extends JdbcDaoSupport implements AuthDAO {

    private final String SELECT_AUTH_BY_ID = "SELECT coachId, bearer_token from coach_sessions where coachId = ?";
    @Override
    public TokenVO getAuthForCoachId(int coachId) throws Exception {
        return (TokenVO)getJdbcTemplate().queryForObject(SELECT_AUTH_BY_ID, new AuthDAOImpl.AuthVORowMapper(), new Object[]{coachId});
    }

    private final String SELECT_COACHID_BY_TOKEN = "SELECT coachId, bearer_token from coach_sessions where bearer_token = ?";
    @Override
    public Integer getCoachIdFromToken(String token) throws Exception {
        try {
            TokenVO authVO = (TokenVO) getJdbcTemplate().queryForObject(SELECT_COACHID_BY_TOKEN, new AuthDAOImpl.AuthVORowMapper(), new Object[]{token});
            if (authVO != null) return authVO.getCoachId();
            return null;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    //CREATE TABLE IF NOT EXISTS coaches(`id` int NOT NULL AUTO_INCREMENT, username VARCHAR(255) NOT NULL, `password` VARCHAR(255) NOT NULL, adminFlag CHAR(1), salt VARCHAR(255), validatedFlag CHAR(1), PRIMARY KEY(`id`), UNIQUE(salt));
    private final String SELECT_BY_COACH_ID = "SELECT id, username, password, adminFlag, salt, from coaches where id = ?";
    @Override
    public UserVO getUserVOForCoachId(int coachId) throws Exception {
        try {
            return (UserVO) getJdbcTemplate().queryForObject(SELECT_BY_COACH_ID, new AuthDAOImpl.UserVORowMapper(), new Object[]{coachId});
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    //CREATE TABLE IF NOT EXISTS coaches(`id` int NOT NULL AUTO_INCREMENT, username VARCHAR(255) NOT NULL, `password` VARCHAR(255) NOT NULL, adminFlag CHAR(1), salt VARCHAR(255), validatedFlag CHAR(1), PRIMARY KEY(`id`), UNIQUE(salt));
    private final String SELECT_BY_COACH_NAME = "SELECT id, username, password, adminFlag, salt, from coaches where username = ?";
    @Override
    public UserVO getUserVOForCoachName(String username) throws Exception {
        try {
            return (UserVO) getJdbcTemplate().queryForObject(SELECT_BY_COACH_NAME, new AuthDAOImpl.UserVORowMapper(), new Object[]{username});
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    private final String DELETE_OLD_TOKENS_BY_COACHID = "DELETE FROM coach_sessions WHERE valid_to < CURRENT_TIMESTAMP";
    @Override
    public void deleteOldSessions() throws Exception {
        getJdbcTemplate().update(DELETE_OLD_TOKENS_BY_COACHID);
    }

    @Override
    public boolean login(String username, String saltedPassword) throws Exception {
        return false;
    }


    //teamTemplateId, position, linemanFlag, QTY, cost, MA, ST, AG, PA, AV
    public class AuthVORowMapper implements RowMapper {
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            TokenVO aVO = new TokenVO(
                    rs.getInt("coachId"),
                    rs.getString("bearer_token")
            );
            return aVO;
        }
    }

    //teamTemplateId, position, linemanFlag, QTY, cost, MA, ST, AG, PA, AV
    public class UserVORowMapper implements RowMapper {
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            boolean adminFlag = false;
            if (rs.getString("adminFlag").equalsIgnoreCase("Y")) adminFlag = true;
            UserVO uVO = new UserVO(
                    rs.getInt("id"),
                    rs.getBytes("salt"),
                    rs.getBytes("password"),
                    adminFlag,
                    rs.getString("username")
            );
            return uVO;
        }
    }
}
