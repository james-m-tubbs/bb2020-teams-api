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
public class PlayerBOTemplateTest {

    @Autowired
    PlayerTemplateBO ptBO;

    @Test
    public void test_get_human_lineman_from_id() {
        try {
            //1, 1, 'Human Lineman', 'Y', 16, 50000, 6, 3, 3, 4, 9, 'G', 'AS'
            PlayerTemplateVO ptVO = ptBO.getPlayerTemplateById(1);
            System.err.println(ptVO);
            Assert.assertTrue(ptVO.getId() == 1);
            Assert.assertTrue(ptVO.getTeamTemplateId() == 1);
            Assert.assertTrue(ptVO.getPosition().equalsIgnoreCase("Human Lineman"));
            Assert.assertTrue(ptVO.getMaxCount() == 16);
            Assert.assertTrue(ptVO.getCost() == 50000);
            Assert.assertTrue(ptVO.getMA() == 6);
            Assert.assertTrue(ptVO.getST() == 3);
            Assert.assertTrue(ptVO.getAG() == 3);
            Assert.assertTrue(ptVO.getPA() == 4);
            Assert.assertTrue(ptVO.getAV() == 9);
            Assert.assertTrue(ptVO.getSkills().size() == 0);
        } catch (Exception e) {
            Assert.fail();
        }
    }
}