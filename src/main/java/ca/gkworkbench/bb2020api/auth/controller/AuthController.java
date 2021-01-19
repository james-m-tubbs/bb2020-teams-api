package ca.gkworkbench.bb2020api.auth.controller;

import ca.gkworkbench.bb2020api.auth.bo.AuthBO;
import ca.gkworkbench.bb2020api.auth.vo.LoginVO;
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

    @RequestMapping(value = "/api/user/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> loginUser(@RequestBody LoginVO loginVO) {
        try {
            if (loginVO.getUsername() == null
                    || loginVO.getUsername().length()<6
                    || loginVO.getPassword() == null
                    || loginVO.getPassword().length() < 8
            ) throw new AuthException(("username or password invalid"));
            TokenVO tokenVO = authBO.login(loginVO.getUsername(), loginVO.getPassword());
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

    @RequestMapping(value = "/api/user/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createUser(@RequestBody LoginVO loginVO) {
        try {
            //validate
            if (loginVO.getUsername() == null || loginVO.getUsername().length() < 6) {
                return new ResponseEntity<>("usernames must be at least 6 characters", HttpStatus.BAD_REQUEST);
            }
            if (loginVO.getPassword() == null || loginVO.getPassword().length() < 8) {
                return new ResponseEntity<>("passwords must be at least 8 characters", HttpStatus.BAD_REQUEST);
            }
            TokenVO tokenVO = authBO.createUser(loginVO.getUsername(), loginVO.getPassword());
            if (tokenVO == null) throw new Exception("TokenVO is null");
            return new ResponseEntity<>(authBO.getJsonToken(tokenVO), HttpStatus.OK);
        } catch (AuthException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "An Error Occurred" + e.getMessage()
            );
        }
    }
}
