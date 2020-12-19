package ca.gkworkbench.bb2020api.player.controller;

import ca.gkworkbench.bb2020api.player.bo.PlayerTemplateBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerTemplateController {

    @Autowired
    PlayerTemplateBO ptBO;

    @RequestMapping(value = "/api/player/template/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getPlayerTemplateById(@PathVariable("id") int playerTemplateId) {
        try {
            return ptBO.getJsonPlayerTemplateById(playerTemplateId);
        } catch (Exception e) {
            return "An Error Occurred: " + e.getMessage();
        }
    }

    @RequestMapping(value = "/api/player/template/team/{teamId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getPlayerTemplatesByTeamId(@PathVariable("teamId") int teamId) {
        try {
            return ptBO.getJsonPlayerTemplatesTeamId(teamId);
        } catch (Exception e) {
            return "An Error Occurred: " + e.getMessage();
        }
    }
}
