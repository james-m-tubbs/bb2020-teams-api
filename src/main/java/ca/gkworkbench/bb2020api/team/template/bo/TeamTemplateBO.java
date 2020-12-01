package ca.gkworkbench.bb2020api.team.template.bo;

import ca.gkworkbench.bb2020api.team.template.vo.TeamTemplateVO;

import java.util.List;
import java.util.Map;

public interface TeamTemplateBO {

    // ** Single Query **
    public TeamTemplateVO getTeamTemplateByID(int teamTemplateId) throws Exception;
    public String getJsonTeamTemplateByID(int teamTemplateId) throws Exception;

    // ** Everything **
    public List<TeamTemplateVO> getTeamList() throws Exception;
    public String getJsonTeamList() throws Exception;

}
