package ca.gkworkbench.bb2020api.team.controller;

import ca.gkworkbench.bb2020api.auth.bo.AuthBO;
import ca.gkworkbench.bb2020api.exception.WarnException;
import ca.gkworkbench.bb2020api.player.bo.PlayerBO;
import ca.gkworkbench.bb2020api.player.vo.PlayerVO;
import ca.gkworkbench.bb2020api.team.bo.TeamsBO;
import ca.gkworkbench.bb2020api.team.vo.TeamVO;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class TeamController {

    @Autowired
    TeamsBO tBO;

    @Autowired
    AuthBO authBO;

    @Autowired
    PlayerBO pBO;

    @RequestMapping(value = "/api/team/{teamId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTeamById(@PathVariable("teamId") int teamId) {
        try {
            TeamVO tVO = tBO.getTeamById(teamId, false);
            if (tVO != null) {
                return new ResponseEntity<>(tBO.getJsonTeam(tVO), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "An Error Occurred" + e.getMessage()
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
        } catch (WarnException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage()
            );
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "An Error Occurred" + e.getMessage()
            );
        }
    }

    @RequestMapping(value = "/api/team/{teamId}/delete", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteTeam(@PathVariable("teamId") int teamId) {
        try {
            if (authBO.hasAccessToModifyTeam(teamId)) {
                tBO.deleteTeam(teamId);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "An Error Occurred" + e.getMessage()
            );
        }
    }

    @RequestMapping(value = "/api/team/{teamId}/details", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTeamByIdWithDetails(@PathVariable("teamId") int teamId) {
        try {
            TeamVO tVO = tBO.getTeamById(teamId, true);
            if (tVO != null) {
                return new ResponseEntity<>(tBO.getJsonTeam(tVO), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "An Error Occurred" + e.getMessage()
            );
        }
    }

    @RequestMapping(value = "/api/team/coach/{coachId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTeamsByCoachId(@PathVariable("coachId") int coachId) {
        try {
            List<TeamVO> teamVOs = tBO.getTeamsForCoachId(coachId);
            if (teamVOs != null) {
                return new ResponseEntity<>(tBO.getJsonTeamList(teamVOs), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "An Error Occurred" + e.getMessage()
            );
        }
    }

    @RequestMapping(value = "/api/team/{teamId}/players", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPlayersByTeamId(@PathVariable("teamId") int teamId) {
        try {
            //check if team exists
            TeamVO tVO = tBO.getTeamById(teamId, false);
            if (tVO != null) {
                List<PlayerVO> pVOs = pBO.getPlayersByTeamId(teamId);
                return new ResponseEntity<>(pBO.getJsonPlayerList(pVOs), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "An Error Occurred" + e.getMessage()
            );
        }
    }

    @RequestMapping(value = "/api/team/{teamId}/players/hire/{playerTemplateId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> hirePlayerByTemplateId(@PathVariable("teamId") int teamId, @PathVariable("playerTemplateId") int playerTemplateId, @RequestParam("name") String playerName) {
        try {
            //check if team exists
            TeamVO tVO = tBO.getTeamById(teamId, true);
            if (tVO != null) {
                playerName = playerName.replaceAll("%20", " ");
                tVO = tBO.hireRookiePlayerFromTemplateId(tVO, playerTemplateId, playerName);
                return new ResponseEntity<>(tBO.getJsonTeam(tVO), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (WarnException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage()
            );
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "An Error Occurred" + e.getMessage()
            );
        }
    }

    @RequestMapping(value = "/api/team/{teamId}/players/fire/{playerId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> firePlayerById(@PathVariable("teamId") int teamId, @PathVariable("playerId") int playerId) {
        try {
            //check if team exists
            TeamVO tVO = tBO.getTeamById(teamId, true);
            if (tVO != null) {
                tVO = tBO.firePlayerByPlayerId(tVO, playerId);
                return new ResponseEntity<>(tBO.getJsonTeam(tVO), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (WarnException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage()
            );
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "An Error Occurred" + e.getMessage()
            );
        }
    }
}
