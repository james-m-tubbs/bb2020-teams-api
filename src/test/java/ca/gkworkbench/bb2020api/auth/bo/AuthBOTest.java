package ca.gkworkbench.bb2020api.auth.bo;

import ca.gkworkbench.bb2020api.auth.AuthVO;
import ca.gkworkbench.bb2020api.auth.dao.AuthDAO;
import ca.gkworkbench.bb2020api.config.bb2020TestConfig;
import ca.gkworkbench.bb2020api.exception.AuthException;
import ca.gkworkbench.bb2020api.exception.WarnException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= bb2020TestConfig.class)
public class AuthBOTest {

    @Autowired
    AuthBO authBO;

    @Autowired
    AuthDAO authDAO;

//    public int getUserId(String token) throws WarnException, AuthException, Exception;
    @Test
    public void testValidToken() {
        try {
            int coachId = authBO.getUserId("thisisaworkingtoken");
            Assert.assertTrue(coachId == 1);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testInvalidToken() {
        try {
            int coachId = authBO.getUserId("this is not a token at all");
            Assert.fail("Shouldn't get here");
        } catch (AuthException e) {
            Assert.assertTrue(e.getMessage().equalsIgnoreCase(""));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNullToken() {
        try {
            int coachId = authBO.getUserId(null);
            Assert.fail("Shouldn't get here");
        } catch (AuthException e) {
            Assert.assertTrue(e.getMessage().equalsIgnoreCase(""));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    //  public boolean hasAccessToModifyTeam(int coachId, int teamId) throws WarnException, Exception;
    @Test
    public void test_access_to_modify_team_success() {
        try {
            Assert.assertTrue(authBO.hasAccessToModifyTeam(1, 1));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test_access_to_modify_team_fail_coach_team_mismatch() {
        try {
            Assert.assertTrue(authBO.hasAccessToModifyTeam(2, 1));
            Assert.fail("Shouldn't get here");
        } catch (AuthException e) {
            Assert.assertTrue(e.getMessage().equalsIgnoreCase("No access to modify team"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test_access_to_modify_team_fail_missing_team() {
        try {
            authBO.hasAccessToModifyTeam(2, 99999);
            Assert.fail("Shouldn't get here");
        } catch (AuthException e) {
            System.err.println(e.getMessage());
            Assert.assertTrue(e.getMessage().equalsIgnoreCase("Team doesn't exist"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test_access_to_modify_team_fail_missing_coach() {
        try {
            authBO.hasAccessToModifyTeam(999999, 1);
            Assert.fail("Shouldn't get here");
        } catch (AuthException e) {
            Assert.assertTrue(e.getMessage().equalsIgnoreCase("No access to modify team"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }
//
//    public boolean hasAccessToModifyTeam(String token, int teamId) throws WarnException, Exception;
    private final String auth_token = "thisisaworkingtoken";

    @Test
    public void test_access_to_modify_team_success_with_good_token() {
        try {
            Assert.assertTrue(authBO.hasAccessToModifyTeam(auth_token, 1));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test_access_to_modify_team_fail_with_bad_token() {
        try {
            authBO.hasAccessToModifyTeam("notatokenthiswillbreak", 1);
        } catch (AuthException e) {
            System.err.println(e.getMessage());
            Assert.assertTrue(e.getMessage().equalsIgnoreCase(""));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

//
//    public AuthVO login(String username, String password) throws WarnException;
}
