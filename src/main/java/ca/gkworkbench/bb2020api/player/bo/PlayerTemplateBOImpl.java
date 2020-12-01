package ca.gkworkbench.bb2020api.player.bo;

import ca.gkworkbench.bb2020api.player.dao.PlayerTemplateDAO;
import ca.gkworkbench.bb2020api.player.vo.PlayerTemplateVO;
import ca.gkworkbench.bb2020api.skill.dao.SkillTemplateDAO;
import com.google.gson.Gson;

import java.util.List;

public class PlayerTemplateBOImpl implements PlayerTemplateBO {

    private PlayerTemplateDAO ptDAO;
    private SkillTemplateDAO stDAO;
    private Gson gson;

    public PlayerTemplateBOImpl(PlayerTemplateDAO ptDAO) {
        this.ptDAO = ptDAO;
        gson = new Gson();
    }

    @Override
    public List<PlayerTemplateVO> getPlayerTemplatesByTeamId(int teamId) throws Exception {
        return ptDAO.getPlayerTemplateListByTeamTemplateId(teamId);
    }

    @Override
    public PlayerTemplateVO getPlayerTemplateById(int id) throws Exception {
        return ptDAO.getPlayerTemplateVOById(id);
    }

    @Override
    public String getJsonPlayerTemplateById(int id) throws Exception {
        PlayerTemplateVO ptVO = ptDAO.getPlayerTemplateVOById(id);
        return gson.toJson(ptVO);
    }
}
