package ca.gkworkbench.bb2020api.team.bo.impl;

import ca.gkworkbench.bb2020api.player.bo.PlayerTemplateBO;
import ca.gkworkbench.bb2020api.player.vo.PlayerTemplateVO;
import ca.gkworkbench.bb2020api.team.bo.TeamTemplateBO;
import ca.gkworkbench.bb2020api.team.dao.TeamTemplateDAO;
import ca.gkworkbench.bb2020api.team.vo.TeamTemplateVO;
import com.google.gson.Gson;

import java.util.List;

public class TeamTemplateBOImpl implements TeamTemplateBO {

    private TeamTemplateDAO ttDAO;
    private PlayerTemplateBO ptBO;
    private Gson gson;

    public TeamTemplateBOImpl(TeamTemplateDAO ttDAO, PlayerTemplateBO ptBO) {
        this.ttDAO = ttDAO;
        this.ptBO = ptBO;
        this.gson = new Gson();
    }

    public TeamTemplateVO getTeamTemplateByID(int teamTemplateId, boolean playerDetails) throws Exception {
        TeamTemplateVO ttVO = ttDAO.getTeamTemplateByID(teamTemplateId);
        if (playerDetails) {
            List<PlayerTemplateVO> ptVOs = ptBO.getPlayerTemplatesByTeamId(teamTemplateId);
            ttVO.setPtVOs(ptVOs);
        }
        return ttVO;
    }

    public String getJsonTeamTemplateByID(int teamTemplateId, boolean playerDetails) throws Exception {
        return gson.toJson(getTeamTemplateByID(teamTemplateId, playerDetails));
    }

    public List<TeamTemplateVO> getTeamList() throws Exception {
        return ttDAO.getTeamList();
    }

    public String getJsonTeamList() throws Exception {
        List<TeamTemplateVO> ttVOs = getTeamList();
        return gson.toJson(ttVOs);
    }

}
