package ca.gkworkbench.bb2020api.team.template.bo;

import ca.gkworkbench.bb2020api.player.template.bo.PlayerTemplateBO;
import ca.gkworkbench.bb2020api.team.template.dao.TeamTemplateDAO;
import ca.gkworkbench.bb2020api.team.template.vo.TeamTemplateVO;
import com.google.gson.Gson;

import java.util.List;
import java.util.Map;

public class TeamTemplateBOImpl implements TeamTemplateBO {

    private TeamTemplateDAO ttDAO;
    private PlayerTemplateBO ptBO;
    private Gson gson;

    public TeamTemplateBOImpl(TeamTemplateDAO ttDAO, PlayerTemplateBO ptBO) {
        this.ttDAO = ttDAO;
        this.ptBO = ptBO;
        this.gson = new Gson();
    }

    public TeamTemplateVO getTeamTemplateByID(int teamTemplateId) throws Exception {
        return ttDAO.getTeamTemplateByID(teamTemplateId);
    }

    public String getJsonTeamTemplateByID(int teamTemplateId) throws Exception {
        TeamTemplateVO ttVO = ttDAO.getTeamTemplateByID(teamTemplateId);
        return gson.toJson(ttVO);
    }

    public List<TeamTemplateVO> getTeamList() throws Exception {
        //List<TeamTemplateVO> ttVOs = null;
        return null;
    }

    public String getJsonTeamList() throws Exception {
        List<TeamTemplateVO> ttVOs = getTeamList();
        return gson.toJson(ttVOs);
    }

}
