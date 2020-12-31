package ca.gkworkbench.bb2020api.team.bo;

import ca.gkworkbench.bb2020api.player.vo.PlayerVO;
import ca.gkworkbench.bb2020api.team.vo.TeamVO;

import java.util.List;

public interface TeamsBO {

    //get team methods
    public TeamVO getTeamById(int teamId, boolean withDetails) throws Exception;
    public TeamVO getTeamByName(String teamName, boolean withDetails) throws Exception;
    public List<TeamVO> getTeamsForCoachId(int coachId) throws Exception;
    public String getJsonTeam(TeamVO tVO) throws Exception;
    public String getJsonTeamList(List<TeamVO> tVOs) throws Exception;

    //create team methods
    public TeamVO createNewTeamFromTemplateId(String teamName, int coachId, int teamTemplateId, int treasury) throws Exception;
    public TeamVO createNewTeamFromTemplateIdDefaultTreasury(String teamName, int coachId, int teamTemplateId) throws Exception;
    public TeamVO redraftTeamFromTeamId(int teamId, int treasury) throws Exception;

    //calculate updated TV and save
    public TeamVO updateTeamWithGeneratedTV(TeamVO tVO) throws Exception;

    //delete team
    public void deleteTeam(int teamId) throws Exception;

    //get all teams for userId
}
