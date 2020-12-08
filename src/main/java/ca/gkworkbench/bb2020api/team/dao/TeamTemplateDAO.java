package ca.gkworkbench.bb2020api.team.dao;

import ca.gkworkbench.bb2020api.team.vo.TeamTemplateVO;

import java.util.List;

public interface TeamTemplateDAO {

    /**
     * Get a single Team Template
     *
     * @param teamTemplateId
     * @return TeamTemplateVO
     * @throws Exception
     */
    public TeamTemplateVO getTeamTemplateByID(int teamTemplateId) throws Exception;

    /**
     * Get all Team Templates
     *
     * @return List<TeamTemplateVO>
     * @throws Exception
     */
    public List<TeamTemplateVO> getTeamList() throws Exception;
}
