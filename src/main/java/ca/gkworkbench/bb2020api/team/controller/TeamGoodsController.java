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
//    @Autowired
//    AuthBO authBO;

    @RequestMapping(value = "/api/team/goods/add/apoth/{teamId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String add_apoth_by_team_id(@PathVariable("teamId") int teamId) {
        try {
            //TODO Check Auth
            TeamVO tVO = tgBO.buyApothForTeam(teamId);
            return tBO.getJsonTeam(tVO);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not Found"
            );
        }
    }

    @RequestMapping(value = "/api/team/goods/remove/apoth/{teamId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String fire_apoth_for_team_id(@PathVariable("teamId") int teamId) {
        try {
            //TODO Check Auth
            TeamVO tVO = tgBO.fireApothForTeam(teamId);
            return tBO.getJsonTeam(tVO);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not Found"
            );
        }
    }

    @RequestMapping(value = "/api/team/goods/add/cheerleader/{teamId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String add_cheerleader_by_team_id(@PathVariable("teamId") int teamId) {
        try {
            //TODO Check Auth
            TeamVO tVO = tgBO.buyCheerleaderForTeam(teamId);
            return tBO.getJsonTeam(tVO);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not Found"
            );
        }
    }

    @RequestMapping(value = "/api/team/goods/remove/cheerleader/{teamId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String fire_cheerleader_for_team_id(@PathVariable("teamId") int teamId) {
        try {
            //TODO Check Auth
            TeamVO tVO = tgBO.fireApothForTeam(teamId);
            return tBO.getJsonTeam(tVO);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not Found"
            );
        }
    }

    @RequestMapping(value = "/api/team/goods/add/coach/{teamId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String add_coach_by_team_id(@PathVariable("teamId") int teamId) {
        try {
            //TODO Check Auth
            TeamVO tVO = tgBO.buyCoachForTeam(teamId);
            return tBO.getJsonTeam(tVO);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not Found"
            );
        }
    }

    @RequestMapping(value = "/api/team/goods/remove/coach/{teamId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String fire_coach_for_team_id(@PathVariable("teamId") int teamId) {
        try {
            //TODO Check Auth
            TeamVO tVO = tgBO.fireApothForTeam(teamId);
            return tBO.getJsonTeam(tVO);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not Found"
            );
        }
    }

    @RequestMapping(value = "/api/team/goods/add/reroll/{teamId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String add_reroll_by_team_id(@PathVariable("teamId") int teamId) {
        try {
            //TODO Check Auth
            TeamVO tVO = tgBO.buyRerollForTeam(teamId);
            return tBO.getJsonTeam(tVO);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not Found"
            );
        }
    }

    @RequestMapping(value = "/api/team/goods/remove/reroll/{teamId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String remove_reroll_for_team_id(@PathVariable("teamId") int teamId) {
        try {
            //TODO Check Auth
            TeamVO tVO = tgBO.removeRerollForTeam(teamId);
            return tBO.getJsonTeam(tVO);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not Found"
            );
        }
    }

    @RequestMapping(value = "/api/team/goods/add/fans/{teamId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String add_fans_for_team_id(@PathVariable("teamId") int teamId) {
        try {
            //TODO Check Auth
            TeamVO tVO = tgBO.buyDedicatedFans(teamId);
            return tBO.getJsonTeam(tVO);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not Found"
            );
        }
    }
}
