package ca.gkworkbench.bb2020api.team.controller;

import ca.gkworkbench.bb2020api.team.bo.TeamsBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {

    @Autowired
    TeamsBO tBO;

    @RequestMapping(value = "/team/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getTeamById(@PathVariable("id") int id) {
        try {
            return tBO.getJsonTeam(tBO.getTeamById(id, false));
        } catch (Exception e) {
            e.printStackTrace();
            return "An Error Occurred: " + e.getMessage();
        }
    }

    @RequestMapping(value = "/team/details/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getTeamByIdWithDetails(@PathVariable("id") int id) {
        try {
            return tBO.getJsonTeam(tBO.getTeamById(id, true));
        } catch (Exception e) {
            e.printStackTrace();
            return "An Error Occurred: " + e.getMessage();
        }
    }
}
