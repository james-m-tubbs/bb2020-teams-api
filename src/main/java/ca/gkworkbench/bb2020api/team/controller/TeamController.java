package ca.gkworkbench.bb2020api.team.controller;

import ca.gkworkbench.bb2020api.team.bo.TeamsBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {

    @Autowired
    TeamsBO tBO;

    @RequestMapping(value = "/team/{id}", method = RequestMethod.GET)
    public String getTeamById(@PathVariable("id") int id) {
        try {
            return tBO.getJsonTeam(tBO.getTeamById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return "An Error Occurred: " + e.getMessage();
        }
    }

    @RequestMapping(value = "/team/{tId}/buy/template/{ptId}", method = RequestMethod.GET)
    public String getTeamById(@PathVariable("tId") int teamId, @PathVariable("ptId") int playerTemplateId) {
        try {
            return tBO.getJsonTeam(tBO.buyPlayerFromTemplate(teamId, playerTemplateId));
        } catch (Exception e) {
            e.printStackTrace();
            return "An Error Occurred: " + e.getMessage();
        }
    }
}
