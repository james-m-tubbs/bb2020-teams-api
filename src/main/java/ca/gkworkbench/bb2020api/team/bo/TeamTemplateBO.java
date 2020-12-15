package ca.gkworkbench.bb2020api.team.bo;

import ca.gkworkbench.bb2020api.team.vo.TeamTemplateVO;

import java.util.List;

public interface TeamTemplateBO {

    // ** Single Query **
    public TeamTemplateVO getTeamTemplateByID(int teamTemplateId, boolean playerDetails) throws Exception;
    public String getJsonTeamTemplateByID(int teamTemplateId, boolean playerDetails) throws Exception;

    // ** Everything **
    public List<TeamTemplateVO> getTeamList() throws Exception;
    public String getJsonTeamList() throws Exception;

}
