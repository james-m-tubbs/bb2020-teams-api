package ca.gkworkbench.bb2020api.team.template.dao;

import ca.gkworkbench.bb2020api.team.template.vo.TeamTemplateVO;

import java.util.List;
import java.util.Map;

public interface TeamTemplateDAO {

    public TeamTemplateVO getTeamTemplateByID(int teamTemplateId) throws Exception;
    public List<TeamTemplateVO> getTeamList() throws Exception;
}
