package ca.gkworkbench.bb2020api.team.template.bo;

import ca.gkworkbench.bb2020api.team.template.vo.TeamTemplateVO;

import java.util.Map;

public interface TeamTemplateBO {

    public TeamTemplateVO getTeamTemplateByID(int teamTemplateId) throws Exception;
    public Map<Integer, String> getTeamList() throws Exception;

}
