package ca.gkworkbench.bb2020api.team.bo;

import ca.gkworkbench.bb2020api.config.bb2020TestConfig;
import ca.gkworkbench.bb2020api.exception.WarnException;
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
            TeamVO tVO = tBO.getTeamById(1, false);
            System.err.println(tVO);
            Assert.assertTrue(tVO.getId() == 1);
            Assert.assertTrue(tVO.getTeamTemplateId() == 1);
            Assert.assertTrue(tVO.getTeamName().equals("The Rookie Testers"));
            Assert.assertTrue(tVO.getCoachId() == 1);
            Assert.assertTrue(tVO.getCoaches()==0);
            Assert.assertTrue(tVO.getCheerleaders()==0);
            Assert.assertTrue(tVO.getTotalCAS()==0);
            Assert.assertTrue(tVO.getTotalTouchdowns()==0);
            Assert.assertTrue(tVO.getCurrentTeamValue()==0);
            Assert.assertTrue(tVO.getLeaguePoints()==0);
            Assert.assertTrue(tVO.getRerolls()==0);
            Assert.assertTrue(tVO.getTeamValue()==0);
            Assert.assertFalse(tVO.isHasApothecary());
            Assert.assertNull(tVO.getTeamTemplateVO());
            Assert.assertNotNull(tVO.getPlayers());
            Assert.assertTrue(tVO.getPlayers().size()==0);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void select_rookie_testers_by_team_by_team_name() {
        try {
            TeamVO tVO = tBO.getTeamByName("The Rookie Testers", false);
            System.err.println(tVO);
            Assert.assertTrue(tVO.getId() == 1);
            Assert.assertTrue(tVO.getTeamTemplateId() == 1);
            Assert.assertTrue(tVO.getTeamName().equals("The Rookie Testers"));
            Assert.assertTrue(tVO.getCoachId() == 1);
            Assert.assertTrue(tVO.getCoaches()==0);
            Assert.assertTrue(tVO.getCheerleaders()==0);
            Assert.assertTrue(tVO.getTotalCAS()==0);
            Assert.assertTrue(tVO.getTotalTouchdowns()==0);
            Assert.assertTrue(tVO.getCurrentTeamValue()==0);
            Assert.assertTrue(tVO.getLeaguePoints()==0);
            Assert.assertTrue(tVO.getRerolls()==0);
            Assert.assertTrue(tVO.getTeamValue()==0);
            Assert.assertFalse(tVO.isHasApothecary());
            Assert.assertNull(tVO.getTeamTemplateVO());
            Assert.assertNotNull(tVO.getPlayers());
            Assert.assertTrue(tVO.getPlayers().size()==0);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void select_missing_team_by_id_and_fail() {
        try {
            TeamVO tVO = tBO.getTeamById(-1, false);
            System.err.println(tVO);
            Assert.fail();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            //expected
        }
    }

    @Test
    public void select_missing_team_by_name_and_fail() {
        try {
            TeamVO tVO = tBO.getTeamByName("The Norland Nobodies", false);
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
            Assert.assertTrue(tVO.getTreasury() == 1000000);
            Assert.assertFalse(tVO.isHasApothecary());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void create_two_teams_with_same_name_and_fail() {
        try {
            TeamVO tVO = tBO.createNewTeamFromTemplateIdDefaultTreasury("The Dwarf Doubles", 1, 6);
            System.err.println(tVO);
            Assert.assertTrue(tVO.getTeamName().equals("The Dwarf Doubles"));
            Assert.assertTrue(tVO.getId() > 1);
            Assert.assertTrue(tVO.getTeamTemplateId() == 6);
            Assert.assertTrue(tVO.getCoachId() == 1);
            Assert.assertTrue(tVO.getTreasury() == 1000000);
            Assert.assertFalse(tVO.isHasApothecary());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            Assert.fail();
        }

        try {
            TeamVO tVO = tBO.createNewTeamFromTemplateIdDefaultTreasury("The Dwarf Doubles", 1, 6);
            Assert.fail();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            //expected
        }

    }
    
    @Test
    public void update_missing_team_and_fail() {
        try {
            TeamVO tVO = tBO.getTeamById(1, false);
            tVO.setId(-1);
            tVO = tBO.updateTeamWithGeneratedTV(tVO);
            Assert.fail();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            //expected
        }
    }

    @Test
    public void create_team_add_coaching_items_and_update_with_value() {
        try {
            TeamVO tVO = tBO.createNewTeamFromTemplateIdDefaultTreasury("Uthers Updates", 1, 1);
            System.err.println(tVO);
            Assert.assertTrue(tVO.getTeamName().equals("Uthers Updates"));
            Assert.assertTrue(tVO.getId() > 1);
            Assert.assertTrue(tVO.getTeamTemplateId() == 1);
            Assert.assertTrue(tVO.getCoachId() == 1);
            Assert.assertTrue(tVO.getTreasury() == 1000000);

            tVO.setRerolls(2); //100k
            tVO.setHasApothecary(true); //50k
            tVO.setCoaches(1); //10k
            tVO.setCheerleaders(2); //20k
            //total 180k
            tVO = tBO.updateTeamWithGeneratedTV(tVO);
            System.err.println(tVO);
            Assert.assertTrue(tVO.getTeamValue()==180000);
            Assert.assertTrue(tVO.getCurrentTeamValue()==180000);
        } catch (Exception e) {
            System.err.print(e.getMessage());
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void create_team_add_coaching_items_and_update_then_query() {
        try {
            TeamVO tVO = tBO.createNewTeamFromTemplateIdDefaultTreasury("Questing Queries", 1, 2);
            System.err.println(tVO);
            Assert.assertTrue(tVO.getTeamName().equals("Questing Queries"));
            Assert.assertTrue(tVO.getId() > 1);
            Assert.assertTrue(tVO.getTeamTemplateId() == 2);
            Assert.assertTrue(tVO.getCoachId() == 1);
            Assert.assertTrue(tVO.getTreasury() == 1000000);

            tVO.setRerolls(2); //120k
            tVO.setHasApothecary(false); //50k
            tVO.setCoaches(3); //30k
            tVO.setCheerleaders(2); //20k
            //total 170k
            tVO = tBO.updateTeamWithGeneratedTV(tVO);
            Assert.assertTrue(tVO.getTeamValue()==170000);
            Assert.assertTrue(tVO.getCurrentTeamValue()==170000);

            TeamVO qVO = tBO.getTeamById(tVO.getId(), true);
            Assert.assertTrue(tVO.getId()==qVO.getId());
            Assert.assertTrue(tVO.getTeamValue()==qVO.getTeamValue());
        } catch (Exception e) {
            System.err.print(e.getMessage());
            e.printStackTrace();
            Assert.fail();
        }
    }

}

