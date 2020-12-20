package ca.gkworkbench.bb2020api.team.controller;

import ca.gkworkbench.bb2020api.team.bo.TeamTemplateBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class TeamTemplateController {

    @Autowired
    TeamTemplateBO ttBO;

    @RequestMapping(value = "/api/team/template", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String teamTemplate() {
        try {
            return ttBO.getJsonTeamList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Not Found"
            );
        }
    }

    @RequestMapping(value = "/api/team/template/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String templateMapper(@PathVariable("id") int id) {
        try {
            return ttBO.getJsonTeamTemplateByID(id, true);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not Found"
            );
        }
    }
}
