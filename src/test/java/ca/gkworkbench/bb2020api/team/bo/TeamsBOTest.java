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

import java.util.List;

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
            Assert.assertTrue(tVO.getCurrentTeamValue()==0);
            Assert.assertTrue(tVO.getDedicatedFans()==1);
            Assert.assertFalse(tVO.hasApothecary());
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
            Assert.assertTrue(tVO.getCurrentTeamValue()==0);
            Assert.assertTrue(tVO.getDedicatedFans()==1);
            Assert.assertFalse(tVO.hasApothecary());
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
            Assert.assertNull(tVO);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void select_missing_team_by_name_and_fail() {
        try {
            TeamVO tVO = tBO.getTeamByName("The Norland Nobodies", false);
            Assert.assertNull(tVO);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
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
            Assert.assertFalse(tVO.hasApothecary());
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
            Assert.assertFalse(tVO.hasApothecary());
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
            Assert.assertFalse(tVO.hasApothecary());
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
            Assert.assertNull(tVO);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            Assert.fail();
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
            tVO.setDedicatedFans(4);
            //total 170k
            tVO = tBO.updateTeamWithGeneratedTV(tVO);
            Assert.assertTrue(tVO.getTeamValue()==170000);
            Assert.assertTrue(tVO.getCurrentTeamValue()==170000);

            TeamVO qVO = tBO.getTeamById(tVO.getId(), true);
            Assert.assertTrue(tVO.getId()==qVO.getId());
            Assert.assertTrue(tVO.getTeamValue()==qVO.getTeamValue());
            Assert.assertTrue(tVO.getCurrentTeamValue()==qVO.getCurrentTeamValue());
            Assert.assertTrue(tVO.getDedicatedFans()==qVO.getDedicatedFans());
        } catch (Exception e) {
            System.err.print(e.getMessage());
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void get_all_teams_for_user() {
        try {
            List<TeamVO> tVOs = tBO.getTeamsForCoachId(2);
            Assert.assertTrue(tVOs.size() == 2);
            for (int i=0; i<tVOs.size();i++) {
                TeamVO tVO = tVOs.get(i);
                Assert.assertTrue(tVO.getCoachId()==2);
                Assert.assertNull(tVO.getTeamTemplateVO());
                Assert.assertTrue(tVO.getPlayers().size() == 0);

                if (tVO.getId() == 2) {
                    Assert.assertTrue(tVO.getTeamName().equalsIgnoreCase("The Orcy Orcsters"));
                    Assert.assertTrue(tVO.getTeamTemplateId() == 2);
                }
                if (tVO.getId() == 3) {
                    Assert.assertTrue(tVO.getTeamName().equalsIgnoreCase("Da Hoomies"));
                    Assert.assertTrue(tVO.getTeamTemplateId() == 1);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void create_chaos_chosen_team_and_hire_players_then_validate_result() {
        try {
            TeamVO tVO = tBO.createNewTeamFromTemplateIdDefaultTreasury("1milTV Chaos Team", 1, 3);
            System.err.println(tVO);
            Assert.assertTrue(tVO.getTeamName().equals("1milTV Chaos Team"));
            Assert.assertTrue(tVO.getId() > 1);
            Assert.assertTrue(tVO.getTeamTemplateId() == 3);
            Assert.assertTrue(tVO.getCoachId() == 1);
            Assert.assertTrue(tVO.getTreasury() == 1000000);
            Assert.assertFalse(tVO.hasApothecary());

            for (int i=0;i<7;i++) {
                tVO = tBO.hireRookiePlayerFromTemplateId(tVO, 13, "Bestman:"+(i+1));
            }

            for (int i=0;i<4;i++) {
                tVO = tBO.hireRookiePlayerFromTemplateId(tVO, 14, "Chaos Warrior:"+(i+1));
            }

            Assert.assertTrue(tVO.getTreasury()==180000);
            Assert.assertTrue(tVO.getCurrentTeamValue()==820000);
            Assert.assertTrue(tVO.getPlayers().size()==11);
            System.err.println(tVO);

        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            Assert.fail();
        }
    }
}

