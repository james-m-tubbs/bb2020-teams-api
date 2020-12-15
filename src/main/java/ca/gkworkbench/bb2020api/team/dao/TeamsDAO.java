package ca.gkworkbench.bb2020api.team.dao;

import ca.gkworkbench.bb2020api.team.vo.TeamVO;

import java.util.List;

public interface TeamsDAO {

    public TeamVO getTeamById(int teamId) throws Exception;

    public void insertTeamVO(TeamVO teamVO) throws Exception;

    public void updateTeamVO(TeamVO teamVO) throws Exception;

    public List<TeamVO> getTeamVOsByCoachId(int coachId) throws Exception;
}