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
public class TeamGoodsBOTest {

    @Autowired
    public TeamGoodsBO tgBO;
    @Autowired
    public TeamsBO tBO;

    @Test
    public void create_team_buy_apoth_and_query() {
        try {
            TeamVO tVO = tBO.createNewTeamFromTemplateIdDefaultTreasury("Sporting Spenders", 1, 1);
            System.err.println(tVO);
            Assert.assertTrue(tVO.getTeamName().equals("Sporting Spenders"));
            Assert.assertTrue(tVO.getId() > 1);
            Assert.assertTrue(tVO.getTeamTemplateId() == 1);
            Assert.assertTrue(tVO.getCoachId() == 1);
            Assert.assertTrue(tVO.getTreasury() == 1000000);
            Assert.assertFalse(tVO.hasApothecary());

            tVO = tgBO.buyApothForTeam(tVO.getId());
            System.err.println(tVO);
            Assert.assertTrue(tVO.getTeamValue() == 50000);
            Assert.assertTrue(tVO.getCurrentTeamValue() == 50000);
            Assert.assertTrue(tVO.getTreasury() == 950000);
            Assert.assertTrue(tVO.hasApothecary());
        } catch (Exception e) {
            System.err.print(e.getMessage());
            e.printStackTrace();
            Assert.fail();
        }
    }

//    @Test
//    public void create_buy_apoth_not_allowed() {
//        try {
//            TeamVO tVO = tBO.createNewTeamFromTemplateIdDefaultTreasury("Sporting Spenders", 1, 1);
//            System.err.println(tVO);
//            Assert.assertTrue(tVO.getTeamName().equals("Sporting Spenders"));
//            Assert.assertTrue(tVO.getId() > 1);
//            Assert.assertTrue(tVO.getTeamTemplateId() == 1);
//            Assert.assertTrue(tVO.getCoachId() == 1);
//            Assert.assertTrue(tVO.getTreasury() == 1000000);
//            Assert.assertFalse(tVO.hasApothecary());
//
//            tVO = tgBO.buyApothForTeam(tVO.getId());
//            System.err.println(tVO);
//            Assert.assertTrue(tVO.getTeamValue() == 50000);
//            Assert.assertTrue(tVO.getCurrentTeamValue() == 50000);
//            Assert.assertTrue(tVO.getTreasury() == 950000);
//            Assert.assertTrue(tVO.hasApothecary());
//        } catch (Exception e) {
//            System.err.print(e.getMessage());
//            e.printStackTrace();
//            Assert.fail();
//        }
//    }

    @Test
    public void create_poor_team_fail_pass_fail_buy_goods_due_to_budget() {
        int teamId = 0;
        try {
            TeamVO tVO = tBO.createNewTeamFromTemplateId("Peniless Pinchers", 1, 1, 10000);
            System.err.println(tVO);
            Assert.assertTrue(tVO.getTeamName().equals("Peniless Pinchers"));
            Assert.assertTrue(tVO.getId() > 1);
            Assert.assertTrue(tVO.getTeamTemplateId() == 1);
            Assert.assertTrue(tVO.getCoachId() == 1);
            Assert.assertTrue(tVO.getTreasury() == 10000);
            Assert.assertFalse(tVO.hasApothecary());
            teamId = tVO.getId();
        } catch (Exception e) {
            System.err.print(e.getMessage());
            e.printStackTrace();
            Assert.fail();
        }

        //buy an apoth, expected fail
        try {
            tgBO.buyApothForTeam(teamId);
            Assert.fail();
        } catch (WarnException e) {
            System.err.print(e.getMessage());
            e.printStackTrace();
            //expected
        } catch (Exception e) {
            System.err.print(e.getMessage());
            e.printStackTrace();
            Assert.fail();
        }

        //buy a coach, pass!
        try {
            TeamVO tVO = tgBO.buyCoachForTeam(teamId);
            TeamVO queryVO = tBO.updateTeamWithGeneratedTV(tVO);
            Assert.assertTrue(tVO.getId()==queryVO.getId());
            Assert.assertTrue(queryVO.getTreasury()==0);
            Assert.assertTrue(queryVO.getTeamValue()==10000);
        } catch (Exception e) {
            System.err.print(e.getMessage());
            e.printStackTrace();
            Assert.fail();
        }

        //buy a cheerleader  fail
        try {
            tgBO.buyCheerleaderForTeam(teamId);
            Assert.fail();
        } catch (WarnException e) {
            System.err.print(e.getMessage());
            e.printStackTrace();
            //expected
        } catch (Exception e) {
            System.err.print(e.getMessage());
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void buy_goods_check_tv_fire_goods_check_tv() {
        try {
            TeamVO tVO = tBO.createNewTeamFromTemplateIdDefaultTreasury("Givers and Goers", 1, 1);
            System.err.println(tVO);
            Assert.assertTrue(tVO.getTeamName().equals("Givers and Goers"));
            Assert.assertTrue(tVO.getId() > 1);
            Assert.assertTrue(tVO.getTeamTemplateId() == 1);
            Assert.assertTrue(tVO.getCoachId() == 1);
            Assert.assertTrue(tVO.getTreasury() == 1000000);
            Assert.assertFalse(tVO.hasApothecary());

            tVO = tgBO.buyApothForTeam(tVO.getId());
            Assert.assertTrue(tVO.getTeamValue() == 50000);
            Assert.assertTrue(tVO.getCurrentTeamValue() == 50000);
            Assert.assertTrue(tVO.getTreasury() == 950000);
            Assert.assertTrue(tVO.hasApothecary());

            tVO = tgBO.fireApothForTeam(tVO.getId());
            Assert.assertTrue(tVO.getTeamValue() == 0);
            Assert.assertTrue(tVO.getCurrentTeamValue() == 0);
            Assert.assertTrue(tVO.getTreasury() == 950000);
            Assert.assertFalse(tVO.hasApothecary());

        } catch (Exception e) {
            System.err.print(e.getMessage());
            e.printStackTrace();
            Assert.fail();
        }
    }


    @Test
    public void buy_9_rerolls_new_team_and_fail() {
        try {
            TeamVO tVO = tBO.createNewTeamFromTemplateIdDefaultTreasury("Too many cooks", 1, 1);
            System.err.println(tVO);
            Assert.assertTrue(tVO.getTeamName().equals("Too many cooks"));
            Assert.assertTrue(tVO.getId() > 1);
            Assert.assertTrue(tVO.getTeamTemplateId() == 1);
            Assert.assertTrue(tVO.getCoachId() == 1);
            Assert.assertTrue(tVO.getTreasury() == 1000000);
            for (int i = 0; i < 9; i++) {
                tVO = tgBO.buyRerollForTeam(tVO.getId());
            }
            Assert.fail();
        } catch (WarnException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            //expected!
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void buy_8_rerolls_new_team_and_success() {
        try {
            TeamVO tVO = tBO.createNewTeamFromTemplateIdDefaultTreasury("8 rerolls?!", 1, 1);
            System.err.println(tVO);
            Assert.assertTrue(tVO.getTeamName().equals("8 rerolls?!"));
            Assert.assertTrue(tVO.getId() > 1);
            Assert.assertTrue(tVO.getTeamTemplateId() == 1);
            Assert.assertTrue(tVO.getCoachId() == 1);
            Assert.assertTrue(tVO.getTreasury() == 1000000);
            for (int i = 0; i < 8; i++) {
                tVO = tgBO.buyRerollForTeam(tVO.getId());
            }
            Assert.assertTrue(tVO.getRerolls()==8);
            Assert.assertTrue(tVO.getTeamValue()==400000);
            Assert.assertTrue(tVO.getCurrentTeamValue()==400000);

        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void buy_reroll_verify_delete_verify_new_team_and_success() {
        try {
            TeamVO tVO = tBO.createNewTeamFromTemplateIdDefaultTreasury("buy reroll and delete", 1, 1);
            System.err.println(tVO);
            Assert.assertTrue(tVO.getTeamName().equals("buy reroll and delete"));
            Assert.assertTrue(tVO.getId() > 1);
            Assert.assertTrue(tVO.getTeamTemplateId() == 1);
            Assert.assertTrue(tVO.getCoachId() == 1);
            Assert.assertTrue(tVO.getTreasury() == 1000000);
            for (int i = 0; i < 8; i++) {
                tVO = tgBO.buyRerollForTeam(tVO.getId());
            }
            Assert.assertTrue(tVO.getRerolls()==8);
            Assert.assertTrue(tVO.getTeamValue()==400000);
            Assert.assertTrue(tVO.getCurrentTeamValue()==400000);
            Assert.assertTrue(tVO.getTreasury()==600000);

            for (int i = 0; i < 8; i++) {
                tVO = tgBO.removeRerollForTeam(tVO.getId());
            }
            Assert.assertTrue(tVO.getRerolls()==0);
            Assert.assertTrue(tVO.getTeamValue()==0);
            Assert.assertTrue(tVO.getCurrentTeamValue()==0);
            Assert.assertTrue(tVO.getTreasury()==600000); //TODO we may want to make it so teams can "un-buy" goods too

        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void buy_1_rerolls_poor_team_and_fail() {
        try {
            TeamVO tVO = tBO.createNewTeamFromTemplateId("Pour Boys", 1, 1, 0);
            System.err.println(tVO);
            Assert.assertTrue(tVO.getTeamName().equals("Pour Boys"));
            Assert.assertTrue(tVO.getId() > 1);
            Assert.assertTrue(tVO.getTeamTemplateId() == 1);
            Assert.assertTrue(tVO.getCoachId() == 1);
            Assert.assertTrue(tVO.getTreasury() == 0);
            tgBO.buyRerollForTeam(tVO.getId());
            Assert.fail();
        } catch (WarnException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            //expected!
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void remove_missing_reroll_fail() {
        try {
            TeamVO tVO = tBO.createNewTeamFromTemplateId("Norolls", 1, 1, 0);
            System.err.println(tVO);
            Assert.assertTrue(tVO.getTeamName().equals("Norolls"));
            Assert.assertTrue(tVO.getId() > 1);
            Assert.assertTrue(tVO.getTeamTemplateId() == 1);
            Assert.assertTrue(tVO.getCoachId() == 1);
            Assert.assertTrue(tVO.getTreasury() == 0);
            tgBO.removeRerollForTeam(tVO.getId());
            Assert.fail();
        } catch (WarnException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            //expected!
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void buy_6_dedicated_fans_success() {
        try {
            TeamVO tVO = tBO.createNewTeamFromTemplateIdDefaultTreasury("buy dedicated fans and delete", 1, 1);
            Assert.assertTrue(tVO.getTeamName().equals("buy dedicated fans and delete"));
            Assert.assertTrue(tVO.getId() > 1);
            Assert.assertTrue(tVO.getTeamTemplateId() == 1);
            Assert.assertTrue(tVO.getCoachId() == 1);
            Assert.assertTrue(tVO.getTreasury() == 1000000);
            for (int i = 0; i < 6; i++) {
                tVO = tgBO.buyDedicatedFans(tVO.getId());
            }
            System.err.println(tVO);
            Assert.assertTrue(tVO.getDedicatedFans()==6);
            Assert.assertTrue(tVO.getTeamValue()==0);
            Assert.assertTrue(tVO.getCurrentTeamValue()==0);
            Assert.assertTrue(tVO.getCurrentTeamValue()==0);
            Assert.assertTrue(tVO.getTreasury()==940000);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            Assert.fail();
        }
    }
}
