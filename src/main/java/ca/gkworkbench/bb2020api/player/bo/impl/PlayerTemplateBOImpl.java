package ca.gkworkbench.bb2020api.player.bo.impl;

import ca.gkworkbench.bb2020api.player.bo.PlayerTemplateBO;
import ca.gkworkbench.bb2020api.player.dao.PlayerTemplateDAO;
import ca.gkworkbench.bb2020api.player.vo.PlayerTemplateVO;
import ca.gkworkbench.bb2020api.skill.dao.SkillTemplateDAO;
import ca.gkworkbench.bb2020api.skill.vo.SkillVO;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class PlayerTemplateBOImpl implements PlayerTemplateBO {

    private PlayerTemplateDAO ptDAO;
    private SkillTemplateDAO stDAO;
    private Gson gson;

    public PlayerTemplateBOImpl(PlayerTemplateDAO ptDAO, SkillTemplateDAO stDAO) {
        this.ptDAO = ptDAO;
        this.stDAO = stDAO;
        gson = new Gson();
    }

    @Override
    public List<PlayerTemplateVO> getPlayerTemplatesByTeamId(int teamId) throws Exception {
        List<PlayerTemplateVO> ptVOs = ptDAO.getPlayerTemplateListByTeamTemplateId(teamId);
        List<PlayerTemplateVO> returnList = new ArrayList<PlayerTemplateVO>();
        for (int i=0; i<ptVOs.size(); i++) {
            returnList.add(getSkillsForPlayerTemplateVO(ptVOs.get(i)));
        }
        if (returnList.size() < 1) throw new Exception("Error - Empty Resultset. Is the teamId correct? teamId:"+teamId);
        return returnList;
    }

    @Override
    public String getJsonPlayerTemplatesTeamId(int id) throws Exception {
        return gson.toJson(getPlayerTemplatesByTeamId(id));
    }

    @Override
    public PlayerTemplateVO getPlayerTemplateById(int id) throws Exception {
        PlayerTemplateVO ptVO = ptDAO.getPlayerTemplateVOById(id);
        ptVO = getSkillsForPlayerTemplateVO(ptVO);
        return ptVO;
    }

    @Override
    public String getJsonPlayerTemplateById(int id) throws Exception {
        PlayerTemplateVO ptVO = getPlayerTemplateById(id);
        return gson.toJson(ptVO);
    }

    private PlayerTemplateVO getSkillsForPlayerTemplateVO(PlayerTemplateVO ptVO) throws Exception{
        List<SkillVO> skillVOs = stDAO.getBaseSkillsByPlayerTemplateId(ptVO.getId());
        ptVO.setSkills(skillVOs);
        return ptVO;
    }
}
