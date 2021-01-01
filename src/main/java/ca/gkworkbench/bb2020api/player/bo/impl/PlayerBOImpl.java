package ca.gkworkbench.bb2020api.player.bo.impl;

import ca.gkworkbench.bb2020api.player.bo.PlayerBO;
import ca.gkworkbench.bb2020api.player.dao.PlayerDAO;
import ca.gkworkbench.bb2020api.player.dao.PlayerTemplateDAO;
import ca.gkworkbench.bb2020api.player.vo.PlayerTemplateVO;
import ca.gkworkbench.bb2020api.player.vo.PlayerVO;
import ca.gkworkbench.bb2020api.skill.dao.SkillTemplateDAO;

import java.util.ArrayList;
import java.util.List;

public class PlayerBOImpl implements PlayerBO {

    private PlayerDAO pDAO;
    private SkillTemplateDAO stDAO;

    public PlayerBOImpl(PlayerDAO pDAO, SkillTemplateDAO stDAO) {
        this.pDAO = pDAO;
        this.stDAO = stDAO;
    }

    @Override
    public List<PlayerVO> getPlayersByTeamId(int teamId) throws Exception {
        List<PlayerVO> pVOs = pDAO.getPlayersForTeamId(teamId);
        return getPlayerListDetails(pVOs);
    }

    @Override
    public PlayerVO getPlayerById(int playerId) throws Exception {
        PlayerVO pVO = pDAO.getPlayerById(playerId);
        return getPlayerDetails(pVO);
    }

    private List<PlayerVO> getPlayerListDetails(List<PlayerVO> inPlayerVOs) throws Exception {
        List<PlayerVO> outPlayerVOs = new ArrayList<PlayerVO>();
        for (int i=0;i<inPlayerVOs.size();i++) {
            PlayerVO pVO = inPlayerVOs.get(i);
            outPlayerVOs.add(getPlayerDetails(pVO));
        }
        return outPlayerVOs;
    }

    private PlayerVO getPlayerDetails(PlayerVO pVO) throws Exception {
        //set base skills
        pVO.setBaseSkills(stDAO.getBaseSkillsByPlayerTemplateId(pVO.getPlayerTemplateId()));
        //TODO set bought skills
        //TODO set injuries
        //TODO set stat upgrades
        return pVO;
    }
}
