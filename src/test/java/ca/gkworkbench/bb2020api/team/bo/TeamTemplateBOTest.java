package ca.gkworkbench.bb2020api.team.bo;

import ca.gkworkbench.bb2020api.config.bb2020TestConfig;
import ca.gkworkbench.bb2020api.player.vo.PlayerTemplateVO;
import ca.gkworkbench.bb2020api.team.vo.TeamTemplateVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= bb2020TestConfig.class)
public class TeamTemplateBOTest {

    @Autowired
    TeamTemplateBO ttBO;

    @Test
    public void query_human_team_no_details() {
        try {
            TeamTemplateVO ttVO = ttBO.getTeamTemplateByID(1, false);
            //System.err.println(ttVO.toString());
            Assert.assertTrue(ttVO.getTeamType().equals("Human"));
            Assert.assertTrue(ttVO.getRerollCost()==50000);
            Assert.assertTrue(ttVO.getTier()==1);
            Assert.assertTrue(ttVO.hasApothecary());
            Assert.assertTrue(ttVO.getSpecialRules().equalsIgnoreCase("Old World Classic"));
            Assert.assertNull(ttVO.getPtVOs());
            System.out.println(ttVO.toString());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void query_orc_team_with_details() {
        try {
            //check the base template
            TeamTemplateVO ttVO = ttBO.getTeamTemplateByID(2, true);
            //System.err.println(ttVO.toString());
            Assert.assertTrue(ttVO.getTeamType().equals("Orc"));
            Assert.assertTrue(ttVO.getRerollCost()==60000);
            Assert.assertTrue(ttVO.getTier()==1);
            Assert.assertTrue(ttVO.hasApothecary());
            Assert.assertTrue(ttVO.getSpecialRules().equalsIgnoreCase("Badlands Brawl"));
            Assert.assertTrue(ttVO.getPtVOs().size() == 6);
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void query_black_orc_team_with_player_details() {
        try {
            //get the detailed template
            TeamTemplateVO ttVO = ttBO.getTeamTemplateByID(7, true);
            //System.err.println(ttVO.toString());
            Assert.assertTrue(ttVO.getPtVOs().size() == 3);

            //check the goblin stats
            PlayerTemplateVO ptVO = ttVO.getPtVOs().get(0);
            //System.err.println(ptVO.toString());
            Assert.assertTrue(ptVO.getPosition().equalsIgnoreCase("Goblin Bruiser"));
            Assert.assertTrue(ptVO.getCost()==45000);

            //check the goblin skills
            Assert.assertTrue(ptVO.getBaseSkills().size() == 4);
            Assert.assertTrue(ptVO.getBaseSkills().get(0).getSkill().equalsIgnoreCase("Dodge"));
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void query_missing_team() {
        try {
            TeamTemplateVO ttVO = ttBO.getTeamTemplateByID(-1, false);
            //System.err.println(ttVO.toString());
            Assert.fail();
        } catch (Exception e) {
            //System.err.println(e.getMessage());
            e.printStackTrace();
            //expected!
        }
    }

    @Test
    public void query_team_list() {
        try {
            List<TeamTemplateVO> ttVOs = ttBO.getTeamList();
            Assert.assertTrue(ttVOs.size() > 0);
            TeamTemplateVO ttVO = ttVOs.get(1);
            System.err.println(ttVO.toString());
            Assert.assertTrue(ttVO.getTeamTemplateId()>0);
            Assert.assertNotNull(ttVO.getTeamType());
            Assert.assertNull(ttVO.getPtVOs());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}
