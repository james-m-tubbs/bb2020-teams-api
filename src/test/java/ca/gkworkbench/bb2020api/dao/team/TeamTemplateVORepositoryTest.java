package ca.gkworkbench.bb2020api.dao.team;

import ca.gkworkbench.bb2020api.config.BB2020JpaConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;
import org.junit.Assert;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = { BB2020JpaConfig.class },
        loader = AnnotationConfigContextLoader.class)
@Transactional
public class TeamTemplateVORepositoryTest {

    @Resource
    private TeamTemplateVORepository ttVORepo;

    @Test
    public void create_and_query_team() {
        //create a ttVO
        TeamTemplateVO createTTVO = new TeamTemplateVO(
                1,
                "Dwarf",
                50000,
                1,
                "Old World Classic, Worlds Edge Superleague"
        );

        //save to h2 db
        ttVORepo.save(createTTVO);

        //query the h2 db for the object
        TeamTemplateVO queryTTVO = ttVORepo.getOne(new Long(1));
        Assert.assertEquals("Dwarf", queryTTVO.getTeamType());
        Assert.assertEquals(50000, queryTTVO.getRerollCost());
        Assert.assertEquals(1, queryTTVO.getTier());
        Assert.assertEquals("Old World Classic, Worlds Edge Superleague", queryTTVO.getSpecialRules());
    }
}

