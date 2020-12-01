package ca.gkworkbench.bb2020api.team.bo;

import ca.gkworkbench.bb2020api.config.bb2020TestConfig;
import ca.gkworkbench.bb2020api.team.vo.TeamTemplateVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= bb2020TestConfig.class)
public class TeamTemplateBOTest {

    @Autowired
    TeamTemplateBO ttBO;

    @Test
    public void validate_autowire_config() {
        Assert.assertNotNull(ttBO);
    }

    @Test
    public void insert_team_and_query() {
        try {
            TeamTemplateVO ttVO = ttBO.getTeamTemplateByID(1);
            System.out.println(ttVO.toString());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}
