package ca.gkworkbench.bb2020api.auth.dao.impl;

import ca.gkworkbench.bb2020api.auth.AuthVO;
import ca.gkworkbench.bb2020api.auth.dao.AuthDAO;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthDAOImpl extends JdbcDaoSupport implements AuthDAO {

    private final String SELECT_AUTH_BY_ID = "SELECT coachId, bearer_token from coach_sessions where id = ?";
    @Override
    public AuthVO getAuthForCoachId(int coachId) throws Exception {
        return (AuthVO)getJdbcTemplate().queryForObject(SELECT_AUTH_BY_ID, new AuthDAOImpl.AuthVORowMapper(), new Object[]{coachId});
    }

    private final String SELECT_COACHID_BY_TOKEN = "SELECT coachId from coach_sessions where bearer_token = ?";
    @Override
    public Integer getCoachIdFromToken(String token) throws Exception {
        try {
            return (Integer) getJdbcTemplate().queryForObject(SELECT_COACHID_BY_TOKEN, new AuthDAOImpl.AuthVORowMapper(), new Object[]{token});
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    private final String DELETE_OLD_TOKENS_BY_COACHID = "DELETE FROM coach_sessions WHERE valid_to < CURRENT_TIMESTAMP";
    @Override
    public void deleteOldSessions(int coachId) throws Exception {
        getJdbcTemplate().update(DELETE_OLD_TOKENS_BY_COACHID, new Object[]{coachId});
    }

    @Override
    public boolean login(String username, String saltedPassword) throws Exception {
        return false;
    }


    //teamTemplateId, position, linemanFlag, QTY, cost, MA, ST, AG, PA, AV
    public class AuthVORowMapper implements RowMapper {
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            AuthVO aVO = new AuthVO(
                    rs.getInt("coachId"),
                    rs.getString("bearer_token")
            );
            return aVO;
        }
    }
}
