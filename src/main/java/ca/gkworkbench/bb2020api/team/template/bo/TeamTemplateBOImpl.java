package ca.gkworkbench.bb2020api.team.template.bo;

import ca.gkworkbench.bb2020api.team.template.dao.TeamTemplateDAO;
import ca.gkworkbench.bb2020api.team.template.vo.TeamTemplateVO;

import java.util.Map;

public class TeamTemplateBOImpl implements TeamTemplateBO {

    private TeamTemplateDAO ttDAO;

    public TeamTemplateBOImpl(TeamTemplateDAO ttDAO) {
        this.ttDAO = ttDAO;
    }

    public TeamTemplateVO getTeamTemplateByID(int teamTemplateId) throws Exception {
        return ttDAO.getTeamTemplateByID(teamTemplateId);
    }

    public Map<Integer, String> getTeamList() throws Exception {
        return null;
    }
}
