package ca.gkworkbench.bb2020api.player.controller;

import ca.gkworkbench.bb2020api.player.bo.PlayerBO;
import ca.gkworkbench.bb2020api.player.vo.PlayerVO;
import ca.gkworkbench.bb2020api.team.vo.TeamVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    PlayerBO pBO;

    @RequestMapping(value = "/api/player/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPlayerById(@PathVariable("id") int playerId) {
        try {
            PlayerVO pVO = pBO.getPlayerById(playerId);
            if (pVO != null) {
                return new ResponseEntity<>(pBO.getJsonPlayer(pVO), HttpStatus.OK);
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
}
