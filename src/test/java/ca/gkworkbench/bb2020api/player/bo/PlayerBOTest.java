package ca.gkworkbench.bb2020api.player.bo;

import ca.gkworkbench.bb2020api.config.bb2020TestConfig;
import ca.gkworkbench.bb2020api.player.vo.PlayerTemplateVO;
import ca.gkworkbench.bb2020api.player.vo.PlayerVO;
import ca.gkworkbench.bb2020api.skill.vo.SkillVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= bb2020TestConfig.class)
public class PlayerBOTest {

    @Autowired
    PlayerBO pBO;

    @Test
    public void query_one_premade_player_with_base_skills() {
        try {
            PlayerVO pVO = pBO.getPlayerById(1);
            Assert.assertTrue(pVO.getPosition().equalsIgnoreCase("Human Thrower"));
            Assert.assertTrue(pVO.getName().equalsIgnoreCase("Tiberius Tosser"));
            Assert.assertTrue(pVO.getSpp()==0);
            Assert.assertTrue(pVO.getSpp()==0);
            Assert.assertTrue(pVO.getPi()==0);
            Assert.assertTrue(pVO.getCas()==0);
            Assert.assertTrue(pVO.getMvp()==0);
            Assert.assertFalse(pVO.isInjured());
            Assert.assertFalse(pVO.isFired());
            Assert.assertFalse(pVO.isTempRetired());
            Assert.assertFalse(pVO.isLinemanFlag());
            Assert.assertNotNull(pVO.getBoughtSkills());
            Assert.assertTrue(pVO.getPlayerTemplateId()==2);
            Assert.assertTrue(pVO.getTeamId()==1);
            Assert.assertTrue(pVO.getTeamTemplateId()==1);
            Assert.assertTrue(pVO.getQty() == 2);
            Assert.assertTrue(pVO.getCost() == 80000);
            Assert.assertTrue(pVO.getMA() == 6);
            Assert.assertTrue(pVO.getST() == 3);
            Assert.assertTrue(pVO.getAG() == 3);
            Assert.assertTrue(pVO.getPA() == 2);
            Assert.assertTrue(pVO.getAV() == 9);
            Assert.assertNotNull(pVO.getBaseSkills());
            Assert.assertTrue(pVO.getBaseSkills().size() == 2);
            for (int i=0; i<pVO.getBaseSkills().size(); i++) {
                SkillVO skillVO = pVO.getBaseSkills().get(i);
                if (skillVO.getSkill().equalsIgnoreCase("Sure Hands")) {
                    Assert.assertTrue(skillVO.getId()==2);
                    Assert.assertTrue(skillVO.getType().equalsIgnoreCase("G"));
                } else if (skillVO.getSkill().equalsIgnoreCase("Pass")) {
                    Assert.assertTrue(skillVO.getId()==45);
                    Assert.assertTrue(skillVO.getType().equalsIgnoreCase("P"));
                } else {
                    Assert.fail("Unexpected extra skill here: "+skillVO);
                }
            }
            Assert.assertTrue(pVO.getPrimary().equalsIgnoreCase("GP"));
            Assert.assertTrue(pVO.getSecondary().equalsIgnoreCase("AS"));

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void query_one_premade_player_without_base_skills() {
        try {
            PlayerVO pVO = pBO.getPlayerById(6);
            Assert.assertTrue(pVO.getPosition().equalsIgnoreCase("Human Lineman"));
            Assert.assertTrue(pVO.getName().equalsIgnoreCase("Leino Lino 1"));
            Assert.assertTrue(pVO.getSpp()==0);
            Assert.assertTrue(pVO.getSpp()==0);
            Assert.assertTrue(pVO.getPi()==0);
            Assert.assertTrue(pVO.getCas()==0);
            Assert.assertTrue(pVO.getMvp()==0);
            Assert.assertFalse(pVO.isInjured());
            Assert.assertFalse(pVO.isFired());
            Assert.assertFalse(pVO.isTempRetired());
            Assert.assertTrue(pVO.isLinemanFlag());
            Assert.assertNotNull(pVO.getBoughtSkills());
            Assert.assertTrue(pVO.getPlayerTemplateId()==1);
            Assert.assertTrue(pVO.getTeamId()==1);
            Assert.assertTrue(pVO.getTeamTemplateId()==1);
            Assert.assertTrue(pVO.getQty() == 16);
            Assert.assertTrue(pVO.getCost() == 50000);
            Assert.assertTrue(pVO.getMA() == 6);
            Assert.assertTrue(pVO.getST() == 3);
            Assert.assertTrue(pVO.getAG() == 3);
            Assert.assertTrue(pVO.getPA() == 4);
            Assert.assertTrue(pVO.getAV() == 9);
            Assert.assertNotNull(pVO.getBaseSkills());
            Assert.assertTrue(pVO.getBaseSkills().size() == 0);
            Assert.assertTrue(pVO.getPrimary().equalsIgnoreCase("G"));
            Assert.assertTrue(pVO.getSecondary().equalsIgnoreCase("AS"));

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }


//    @Test
//    public void hire_from_template_and_query_success() {
//        Assert.fail();
//    }
//
//    @Test
//    public void hire_from_template_too_many_positionals_and_fail() {
//        Assert.fail();
//    }
//
//    @Test
//    public void hire_from_template_not_enough_funds_and_fail() {
//        Assert.fail();
//    }
//
//    @Test
//    public void hire_from_template_too_many_big_guys_and_fail() {
//        Assert.fail();
//    }
//
//    @Test
//    public void hire_full_team_and_query_success() {
//        Assert.fail();
//    }
}
