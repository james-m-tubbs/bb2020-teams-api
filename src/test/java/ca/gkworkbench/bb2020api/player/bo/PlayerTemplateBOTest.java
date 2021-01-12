package ca.gkworkbench.bb2020api.player.bo;

import ca.gkworkbench.bb2020api.config.bb2020TestConfig;
import ca.gkworkbench.bb2020api.player.vo.PlayerTemplateVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= bb2020TestConfig.class)
public class PlayerTemplateBOTest {

    @Autowired
    PlayerTemplateBO ptBO;

    @Test
    public void test_get_goblin_bruiser_from_id() {
        try {
            PlayerTemplateVO ptVO = ptBO.getPlayerTemplateById(1);
            System.err.println(ptVO);
            Assert.assertTrue(ptVO.getPlayerTemplateId() == 1);
            Assert.assertTrue(ptVO.getTeamTemplateId() == 1);
            Assert.assertTrue(ptVO.getPosition().equalsIgnoreCase("Goblin Bruiser Lineman"));
            Assert.assertTrue(ptVO.isLinemanFlag() == true);
            Assert.assertTrue(ptVO.isBigGuyFlag() == false);
            Assert.assertTrue(ptVO.getQty() == 12);
            Assert.assertTrue(ptVO.getCost() == 45000);
            Assert.assertTrue(ptVO.getMA() == 6);
            Assert.assertTrue(ptVO.getST() == 2);
            Assert.assertTrue(ptVO.getAG() == 3);
            Assert.assertTrue(ptVO.getPA() == 4);
            Assert.assertTrue(ptVO.getAV() == 8);
            Assert.assertTrue(ptVO.getBaseSkills().size() == 4);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();;
            Assert.fail();
        }
    }

    @Test
    public void test_get_missing_player_id() {
        try {
            PlayerTemplateVO ptVO = ptBO.getPlayerTemplateById(-1);
            System.err.println(ptVO);
            Assert.fail();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();;
            //expected
        }
    }

    @Test
    public void test_get_black_orc_players_by_team_id() {
        try {
            List<PlayerTemplateVO> ptVOs = ptBO.getPlayerTemplatesByTeamId(1);
            System.err.println(ptVOs);
            Assert.assertTrue(ptVOs.size() == 3);
            PlayerTemplateVO ptVO;
            //checking for each player on the team
            for (int i=0; i<ptVOs.size(); i++) {
                ptVO = ptVOs.get(i);
                if (ptVO.getPlayerTemplateId()==1) {
                    System.err.println(ptVO);
                    Assert.assertTrue(ptVO.getPlayerTemplateId() == 1);
                    Assert.assertTrue(ptVO.getTeamTemplateId() == 1);
                    Assert.assertTrue(ptVO.getPosition().equalsIgnoreCase("Goblin Bruiser Lineman"));
                    Assert.assertTrue(ptVO.isLinemanFlag() == true);
                    Assert.assertTrue(ptVO.isBigGuyFlag() == false);
                    Assert.assertTrue(ptVO.getQty() == 12);
                    Assert.assertTrue(ptVO.getCost() == 45000);
                    Assert.assertTrue(ptVO.getMA() == 6);
                    Assert.assertTrue(ptVO.getST() == 2);
                    Assert.assertTrue(ptVO.getAG() == 3);
                    Assert.assertTrue(ptVO.getPA() == 4);
                    Assert.assertTrue(ptVO.getAV() == 8);
                    Assert.assertTrue(ptVO.getBaseSkills().size() == 4);
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();;
            Assert.fail();
            //expected
        }
    }

    @Test
    public void test_get_goblin_bruiser_from_get_player_templates_by_team_id() {
        try {
            List<PlayerTemplateVO> ptVOs = ptBO.getPlayerTemplatesByTeamId(1);
            System.err.println(ptVOs);
            Assert.assertTrue(ptVOs.size() == 3);
            PlayerTemplateVO ptVO;
            //checking for each player on the team
            for (int i=0; i<ptVOs.size(); i++) {
                ptVO = ptVOs.get(i);
                Assert.assertNotNull(ptVO);
                Assert.assertNotNull(ptVO.getBaseSkills());
                Assert.assertNotNull(ptVO.isLinemanFlag());
                Assert.assertNotNull(ptVO.isBigGuyFlag());
                Assert.assertNotNull(ptVO.getMA());
                Assert.assertNotNull(ptVO.getST());
                Assert.assertNotNull(ptVO.getAG());
                Assert.assertNotNull(ptVO.getPA());
                Assert.assertNotNull(ptVO.getAV());
                Assert.assertNotNull(ptVO.getCost());
                Assert.assertNotNull(ptVO.getCost());
                Assert.assertNotNull(ptVO.getPosition());
                Assert.assertNotNull(ptVO.getQty());
                Assert.assertNotNull(ptVO.getTeamTemplateId());
                Assert.assertNotNull(ptVO.getPlayerTemplateId());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();;
            Assert.fail();
        }
    }

    @Test
    public void test_get_players_by_teamid_missing_team_id() {
        try {
            List<PlayerTemplateVO> ptVOs = ptBO.getPlayerTemplatesByTeamId(-1);
            System.err.println(ptVOs);
            Assert.fail();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            //expected
        }
    }
}
