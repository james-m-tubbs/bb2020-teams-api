package ca.gkworkbench.bb2020api.team.bo;

import ca.gkworkbench.bb2020api.team.vo.TeamVO;

public interface TeamsBO {

    public TeamVO getTeamById(int teamId, boolean withDetails) throws Exception;

    public TeamVO getTeamByName(String teamName, boolean withDetails) throws Exception;

    public TeamVO createNewTeamFromTemplateId(String teamName, int coachId, int teamTemplateId, int treasury) throws Exception;

    public TeamVO createNewTeamFromTemplateIdDefaultTreasury(String teamName, int coachId, int teamTemplateId) throws Exception;

    public TeamVO redraftTeamFromTeamId(int teamId, int treasury) throws Exception;

    public String getJsonTeam(TeamVO tVO) throws Exception;
}
