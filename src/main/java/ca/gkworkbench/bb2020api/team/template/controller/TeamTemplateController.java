package ca.gkworkbench.bb2020api.team.template.controller;

import ca.gkworkbench.bb2020api.team.template.bo.TeamTemplateBO;
import ca.gkworkbench.bb2020api.team.template.vo.TeamTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class TeamTemplateController {

    @Autowired
    TeamTemplateBO ttBO;

    @RequestMapping(value = "/team/template", method = RequestMethod.GET)
    public String teamTemplate() {
        try {
            return ttBO.getJsonTeamList();
        } catch (Exception e) {
            return "An Error Occurred: " + e.getMessage();
        }
    }

    @RequestMapping(value = "/team/template/{id}", method = RequestMethod.GET)
    public String templateMapper(@PathVariable("id") int id) {
        try {
            return ttBO.getJsonTeamTemplateByID(id);
        } catch (Exception e) {
            return "An Error Occurred: " + e.getMessage();
        }
    }
}
