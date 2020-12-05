package ca.gkworkbench.bb2020api.player.controller;

import ca.gkworkbench.bb2020api.player.bo.PlayerTemplateBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerTemplateController {

    @Autowired
    PlayerTemplateBO ptBO;

    @RequestMapping(value = "/player/template/{id}", method = RequestMethod.GET)
    public String templateMapper(@PathVariable("id") int id) {
        try {
            return ptBO.getJsonPlayerTemplateById(id);
        } catch (Exception e) {
            return "An Error Occurred: " + e.getMessage();
        }
    }
}
