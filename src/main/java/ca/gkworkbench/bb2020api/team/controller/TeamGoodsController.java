package ca.gkworkbench.bb2020api.team.controller;

import ca.gkworkbench.bb2020api.team.bo.TeamGoodsBO;
import ca.gkworkbench.bb2020api.team.bo.TeamsBO;
import ca.gkworkbench.bb2020api.team.vo.TeamVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class TeamGoodsController {

    @Autowired
    TeamGoodsBO tgBO;
    @Autowired
    TeamsBO tBO;

    @RequestMapping(value = "/api/team/goods/add/apoth/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String add_apoth_by_team_id(@PathVariable("id") int teamId) {
        try {
            TeamVO tVO = tgBO.buyApothForTeam(teamId);
            return tBO.getJsonTeam(tVO);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not Found"
            );
        }
    }

    @RequestMapping(value = "/api/team/goods/remove/apoth/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String fire_apoth_for_team_id(@PathVariable("id") int teamId) {
        try {
            TeamVO tVO = tgBO.fireApothForTeam(teamId);
            return tBO.getJsonTeam(tVO);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not Found"
            );
        }
    }
}
