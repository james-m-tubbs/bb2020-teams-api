package ca.gkworkbench.bb2020api.player.template.bo;

import ca.gkworkbench.bb2020api.player.template.dao.PlayerTemplateDAO;
import ca.gkworkbench.bb2020api.player.template.vo.PlayerTemplateVO;
import com.google.gson.Gson;

import java.util.List;

public class PlayerTemplateBOImpl implements PlayerTemplateBO {

    private PlayerTemplateDAO ptDAO;
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
}
