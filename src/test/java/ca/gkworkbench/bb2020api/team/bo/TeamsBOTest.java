package ca.gkworkbench.bb2020api.team.bo;

import ca.gkworkbench.bb2020api.config.bb2020TestConfig;
import ca.gkworkbench.bb2020api.team.vo.TeamVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= bb2020TestConfig.class)
public class TeamsBOTest {

    @Autowired
    TeamsBO tBO;

    @Test
    public void select_rookie_testers_by_team_by_id() {
        try {
            TeamVO tVO = tBO.getTeamById(1);
            System.err.println(tVO);
            Assert.assertTrue(tVO.getId() == 1);
            Assert.assertTrue(tVO.getTeamTemplateId() == 1);
            Assert.assertTrue(tVO.getTeamName().equals("The Rookie Testers"));
            Assert.assertTrue(tVO.getCoachId() == 1);
            Assert.assertFalse(tVO.isHasApothecary());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void select_missing_team_by_id() {
        try {
            TeamVO tVO = tBO.getTeamById(-1);
            System.err.println(tVO);
            Assert.fail();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            //expected
        }
    }

    @Test
    public void create_orc_team_and_validate_result() {
        try {
            TeamVO tVO = tBO.createNewTeamFromTemplateId("The Veteran JUnits", 1, 2, 1100000);
            System.err.println(tVO);
            Assert.assertTrue(tVO.getTeamName().equals("The Veteran JUnits"));
            Assert.assertTrue(tVO.getId() > 1);
            Assert.assertTrue(tVO.getTeamTemplateId() == 2);
            Assert.assertTrue(tVO.getCoachId() == 1);
            Assert.assertTrue(tVO.getTreasury() == 1100000);
            Assert.assertFalse(tVO.isHasApothecary());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void create_chaos_chosen_team_and_validate_result() {
        try {
            TeamVO tVO = tBO.createNewTeamFromTemplateIdDefaultTreasury("The Chaos Defaults", 1, 3);
            System.err.println(tVO);
            Assert.assertTrue(tVO.getTeamName().equals("The Chaos Defaults"));
            Assert.assertTrue(tVO.getId() > 1);
            Assert.assertTrue(tVO.getTeamTemplateId() == 3);
            Assert.assertTrue(tVO.getCoachId() == 1);
            Assert.assertTrue(tVO.getTreasury() == 1100000);
            Assert.assertFalse(tVO.isHasApothecary());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            Assert.fail();
        }
    }
}
