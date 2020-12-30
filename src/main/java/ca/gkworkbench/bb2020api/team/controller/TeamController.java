package ca.gkworkbench.bb2020api.team.controller;

import ca.gkworkbench.bb2020api.auth.bo.AuthBO;
import ca.gkworkbench.bb2020api.team.bo.TeamsBO;
import ca.gkworkbench.bb2020api.team.vo.TeamVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class TeamController {

    @Autowired
    TeamsBO tBO;

    @Autowired
    AuthBO authBO;

    @RequestMapping(value = "/api/team/{teamId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getTeamById(@PathVariable("teamId") int teamId) {
        try {
            return tBO.getJsonTeam(tBO.getTeamById(teamId, false));
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not Found"
            );
        }
    }

    @RequestMapping(value = "/api/team/create/{teamTemplateId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String createTeam(@PathVariable("teamTemplateId") int teamTemplateId, @RequestParam(name = "teamName") String teamName, @RequestParam(name="treasury", required = false) Integer treasury) {
        try {
            int coachId = authBO.getUserId();
            teamName = teamName.replaceAll("%20", " ");
            TeamVO teamVO;
            if (treasury != null && treasury >= 0) {
                teamVO = tBO.createNewTeamFromTemplateId(teamName, coachId, teamTemplateId, treasury);
            } else {
                teamVO = tBO.createNewTeamFromTemplateIdDefaultTreasury(teamName, coachId, teamTemplateId);
            }
            return tBO.getJsonTeam(teamVO);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "An Error Occurred" + e.getMessage()
            );
        }
    }

    @RequestMapping(value = "/api/team/delete/{teamId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteTeam(@PathVariable("teamId") int teamId) {
        try {
            tBO.deleteTeam(teamId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "An Error Occurred" + e.getMessage()
            );
        }
    }

    @RequestMapping(value = "/api/team/details/{teamId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getTeamByIdWithDetails(@PathVariable("teamId") int teamId) {
        try {
            return tBO.getJsonTeam(tBO.getTeamById(teamId, true));
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not Found"
            );
        }
    }
}
