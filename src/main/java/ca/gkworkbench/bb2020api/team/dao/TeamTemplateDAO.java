package ca.gkworkbench.bb2020api.team.dao;

import ca.gkworkbench.bb2020api.team.vo.TeamTemplateVO;

import java.util.List;

public interface TeamTemplateDAO {

    public TeamTemplateVO getTeamTemplateByID(int teamTemplateId) throws Exception;
    public List<TeamTemplateVO> getTeamList() throws Exception;
}
