package ca.gkworkbench.bb2020api.auth.controller;

import ca.gkworkbench.bb2020api.auth.bo.AuthBO;
import ca.gkworkbench.bb2020api.auth.vo.TokenVO;
import ca.gkworkbench.bb2020api.exception.AuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class AuthController {

    @Autowired
    AuthBO authBO;

    @RequestMapping(value = "/api/user/login", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> loginUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        try {
            TokenVO tokenVO = authBO.login(username, password);
            if (tokenVO == null) throw new Exception("TokenVO is null");
            return new ResponseEntity<>(authBO.getJsonToken(tokenVO), HttpStatus.OK);
        } catch (AuthException e) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "An Error Occurred" + e.getMessage()
            );
        }
    }

    @RequestMapping(value = "/api/user/create", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        try {
            TokenVO tokenVO = authBO.createUser(username, password);
            if (tokenVO == null) throw new Exception("TokenVO is null");
            return new ResponseEntity<>(authBO.getJsonToken(tokenVO), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "An Error Occurred" + e.getMessage()
            );
        }
    }
}