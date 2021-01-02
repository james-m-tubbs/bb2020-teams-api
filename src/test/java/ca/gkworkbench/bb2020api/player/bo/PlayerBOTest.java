package ca.gkworkbench.bb2020api.player.bo;

import ca.gkworkbench.bb2020api.config.bb2020TestConfig;
import ca.gkworkbench.bb2020api.exception.WarnException;
import ca.gkworkbench.bb2020api.player.dao.PlayerDAO;
import ca.gkworkbench.bb2020api.player.dao.PlayerTemplateDAO;
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

    @Autowired
    PlayerDAO pDAO;

    @Autowired
    PlayerTemplateDAO ptDAO;

    @Test
    public void query_one_premade_player_with_base_skills_success() {
        try {
            PlayerVO pVO = pBO.getPlayerById(1);
            Assert.assertTrue(pVO.getPosition().equalsIgnoreCase("Human Thrower"));
            Assert.assertTrue(pVO.getName().equalsIgnoreCase("Tiberius Tosser"));
            Assert.assertTrue(pVO.getSpp()==15);
            Assert.assertTrue(pVO.getTd()==4);
            Assert.assertTrue(pVO.getPi()==3);
            Assert.assertTrue(pVO.getCas()==1);
            Assert.assertTrue(pVO.getMvp()==2);
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
            Assert.assertTrue(pVO.getGamesPlayed() == 6);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void query_one_premade_player_by_name_with_base_skills_success() {
        try {
            PlayerVO pVO = pDAO.getPlayerForNameAndTeam(1, "Tiberius Tosser");
            pVO = pBO.getPlayerDetails(pVO);
            Assert.assertTrue(pVO.getPosition().equalsIgnoreCase("Human Thrower"));
            Assert.assertTrue(pVO.getName().equalsIgnoreCase("Tiberius Tosser"));
            Assert.assertTrue(pVO.getSpp()==15);
            Assert.assertTrue(pVO.getCas()==1);
            Assert.assertTrue(pVO.getMvp()==2);
            Assert.assertTrue(pVO.getPi()==3);
            Assert.assertTrue(pVO.getTd()==4);
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
            Assert.assertTrue(pVO.getGamesPlayed() == 6);
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
            Assert.assertTrue(pVO.getGamesPlayed() == 6);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void query_one_premade_player_without_base_skills_success() {
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
            Assert.assertTrue(pVO.getGamesPlayed() == 0);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void query_missing_player_returns_null() {
        try {
            PlayerVO pVO = pBO.getPlayerById(999999);
            Assert.assertNull(pVO);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("shouldn't get here - return null on can't find player");
        }
    }

    @Test
    public void query_all_players_for_team_success() {
        try {
            List<PlayerVO> pVOs = pBO.getPlayersByTeamId(1);
            Assert.assertNotNull(pVOs);
            Assert.assertTrue(pVOs.size() > 0);
            for (int i = 0; i < pVOs.size(); i++) {
                PlayerVO pVO = pVOs.get(i);
                if (pVO != null && pVO.getName().equalsIgnoreCase("Leino Lino 1")) {
                    Assert.assertTrue(pVO.getPosition().equalsIgnoreCase("Human Lineman"));
                    Assert.assertTrue(pVO.getName().equalsIgnoreCase("Leino Lino 1"));
                    Assert.assertTrue(pVO.getSpp() == 0);
                    Assert.assertTrue(pVO.getSpp() == 0);
                    Assert.assertTrue(pVO.getPi() == 0);
                    Assert.assertTrue(pVO.getCas() == 0);
                    Assert.assertTrue(pVO.getMvp() == 0);
                    Assert.assertFalse(pVO.isInjured());
                    Assert.assertFalse(pVO.isFired());
                    Assert.assertFalse(pVO.isTempRetired());
                    Assert.assertTrue(pVO.isLinemanFlag());
                    Assert.assertNotNull(pVO.getBoughtSkills());
                    Assert.assertTrue(pVO.getPlayerTemplateId() == 1);
                    Assert.assertTrue(pVO.getTeamId() == 1);
                    Assert.assertTrue(pVO.getTeamTemplateId() == 1);
                    Assert.assertTrue(pVO.getQty() == 16);
                    Assert.assertTrue(pVO.getCost() == 50000);
                    Assert.assertTrue(pVO.getMA() == 6);
                    Assert.assertTrue(pVO.getST() == 3);
                    Assert.assertTrue(pVO.getAG() == 3);
                    Assert.assertTrue(pVO.getPA() == 4);
                    Assert.assertTrue(pVO.getAV() == 9);
                    Assert.assertNotNull(pVO.getBaseSkills());
                    Assert.assertTrue(pVO.getBaseSkills().size() == 0);
                    Assert.assertTrue(pVO.getGamesPlayed() == 0);
                    Assert.assertTrue(pVO.getPrimary().equalsIgnoreCase("G"));
                    Assert.assertTrue(pVO.getSecondary().equalsIgnoreCase("AS"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void query_missing_team_returns_empty_list() {
        try {
            List<PlayerVO> pVOs = pBO.getPlayersByTeamId(999999);
            Assert.assertNotNull(pVOs);
            Assert.assertTrue(pVOs.size() == 0);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("shouldn't get here - return null on can't find player");
        }
    }

    @Test
    public void create_player_from_template_success_and_query_as_part_of_team() {
        try {
            PlayerVO createPVO = pBO.createPlayerFromTemplateId(1, 1, 1, "Leino Lino 2");

            List<PlayerVO> pVOs = pBO.getPlayersByTeamId(createPVO.getTeamId());
            Assert.assertNotNull(pVOs);
            for (int i = 0; i < pVOs.size(); i++) {
                PlayerVO pVO = pVOs.get(i);
                if (pVO != null && pVO.getName().equalsIgnoreCase("Leino Lino 2")) {
                    Assert.assertTrue(pVO.getPosition().equalsIgnoreCase("Human Lineman"));
                    Assert.assertTrue(pVO.getName().equalsIgnoreCase("Leino Lino 2"));
                    Assert.assertTrue(pVO.getSpp() == 0);
                    Assert.assertTrue(pVO.getSpp() == 0);
                    Assert.assertTrue(pVO.getPi() == 0);
                    Assert.assertTrue(pVO.getCas() == 0);
                    Assert.assertTrue(pVO.getMvp() == 0);
                    Assert.assertFalse(pVO.isInjured());
                    Assert.assertFalse(pVO.isFired());
                    Assert.assertFalse(pVO.isTempRetired());
                    Assert.assertTrue(pVO.isLinemanFlag());
                    Assert.assertNotNull(pVO.getBoughtSkills());
                    Assert.assertTrue(pVO.getPlayerTemplateId() == 1);
                    Assert.assertTrue(pVO.getTeamId() == 1);
                    Assert.assertTrue(pVO.getTeamTemplateId() == 1);
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
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void create_player_from_template_success_and_validate_result() {
        try {
            PlayerVO pVO = pBO.createPlayerFromTemplateId(1, 1, 1, "Leino Lino 3");
            Assert.assertTrue(pVO.getPosition().equalsIgnoreCase("Human Lineman"));
            Assert.assertTrue(pVO.getName().equalsIgnoreCase("Leino Lino 3"));
            Assert.assertTrue(pVO.getSpp() == 0);
            Assert.assertTrue(pVO.getSpp() == 0);
            Assert.assertTrue(pVO.getPi() == 0);
            Assert.assertTrue(pVO.getCas() == 0);
            Assert.assertTrue(pVO.getMvp() == 0);
            Assert.assertFalse(pVO.isInjured());
            Assert.assertFalse(pVO.isFired());
            Assert.assertFalse(pVO.isTempRetired());
            Assert.assertTrue(pVO.isLinemanFlag());
            Assert.assertNotNull(pVO.getBoughtSkills());
            Assert.assertTrue(pVO.getPlayerTemplateId() == 1);
            Assert.assertTrue(pVO.getTeamId() == 1);
            Assert.assertTrue(pVO.getTeamTemplateId() == 1);
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

    @Test
    public void create_player_from_template_success_and_query_individually() {
        try {
            PlayerVO createPVO = pBO.createPlayerFromTemplateId(1, 1, 1, "Leino Lino 4");

            PlayerVO pVO = pBO.getPlayerById(createPVO.getPlayerId());

            Assert.assertTrue(pVO.getPosition().equalsIgnoreCase("Human Lineman"));
            Assert.assertTrue(pVO.getName().equalsIgnoreCase("Leino Lino 4"));
            Assert.assertTrue(pVO.getSpp() == 0);
            Assert.assertTrue(pVO.getSpp() == 0);
            Assert.assertTrue(pVO.getPi() == 0);
            Assert.assertTrue(pVO.getCas() == 0);
            Assert.assertTrue(pVO.getMvp() == 0);
            Assert.assertFalse(pVO.isInjured());
            Assert.assertFalse(pVO.isFired());
            Assert.assertFalse(pVO.isTempRetired());
            Assert.assertTrue(pVO.isLinemanFlag());
            Assert.assertNotNull(pVO.getBoughtSkills());
            Assert.assertTrue(pVO.getPlayerTemplateId() == 1);
            Assert.assertTrue(pVO.getTeamId() == 1);
            Assert.assertTrue(pVO.getTeamTemplateId() == 1);
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

    @Test
    public void create_player_from_missing_template_fail() {
        try {
            pBO.createPlayerFromTemplateId(1, 1,999999, "This will not work");
        } catch (WarnException e) {
            Assert.assertTrue(e.getMessage().equalsIgnoreCase("Could not find playerTemplate for id:999999"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void create_player_with_duplicate_name() {
        try {
            PlayerVO pVO = pBO.createPlayerFromTemplateId(1, 1, 1, "Leino Lino 5");
            Assert.assertNotNull(pVO);
            pBO.createPlayerFromTemplateId(1, 1, 1, "Leino Lino 5");
            Assert.fail();
        } catch (WarnException e) {
            Assert.assertTrue(e.getMessage().equalsIgnoreCase("Player name in use"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void create_too_many_players_of_the_same_position_fail() {
        try {
            PlayerVO pVO = pBO.createPlayerFromTemplateId(1, 1, 4, "5th Blitzer Fail");
        } catch (WarnException e) {
            Assert.assertTrue(e.getMessage().equalsIgnoreCase("Positional Count Reached for:Human Blitzer"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void check_for_hiring_exceptions_success() {
        try {
            PlayerTemplateVO ptVO = ptDAO.getPlayerTemplateVOById(1);
            pBO.checkForHiringExceptions(1, 1, ptVO);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void check_for_hiring_exceptions_too_many_positionals_fail() {
        try {
            //check if we can hire a blitzer
            PlayerTemplateVO ptVO = ptDAO.getPlayerTemplateVOById(4);
            pBO.checkForHiringExceptions(1, 1, ptVO);
            Assert.fail("Exception expected");
        } catch (WarnException e) {
            Assert.assertTrue(e.getMessage().equalsIgnoreCase("Positional Count Reached for:Human Blitzer"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void check_for_hiring_exceptions_wrong_team_right_playertemplate_fail() {
        try {
            PlayerTemplateVO ptVO = ptDAO.getPlayerTemplateVOById(1);
            pBO.checkForHiringExceptions(1, 2, ptVO);
            Assert.fail();
        } catch (WarnException e) {
            Assert.assertTrue(e.getMessage().equalsIgnoreCase("Player (Human Lineman) cannot be hired by team"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void check_for_hiring_exceptions_right_team_wrong_playertemplate_fail() {
        try {
            PlayerTemplateVO ptVO = ptDAO.getPlayerTemplateVOById(7);
            pBO.checkForHiringExceptions(1, 1, ptVO); // orc lineman
            Assert.fail();
        } catch (WarnException e) {
            Assert.assertTrue(e.getMessage().equalsIgnoreCase("Player (Orc Lineman) cannot be hired by team"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

//    @Test
//    public void create_too_many_big_guys_for_chaos_and_fail() {
////        try {
//            Assert.fail();
////        } catch (WarnException e) {
////            Assert.assertTrue(e.getMessage().equalsIgnoreCase(""));
////        } catch (Exception e) {
////            e.printStackTrace();
////            Assert.fail();
////        }
//    }
//
//    @Test
//    public void create_one_big_guy_for_chaos_and_pass() {
////        try {
//            Assert.fail();
////        } catch (WarnException e) {
////            Assert.assertTrue(e.getMessage().equalsIgnoreCase(""));
////        } catch (Exception e) {
////            e.printStackTrace();
////            Assert.fail();
////        }
//    }
//
//    @Test
//    public void create_big_guy_remove_big_guy_and_create_big_guy_pass() {
////        try {
//            Assert.fail();
////        } catch (WarnException e) {
////            Assert.assertTrue(e.getMessage().equalsIgnoreCase(""));
////        } catch (Exception e) {
////            e.printStackTrace();
////            Assert.fail();
////        }
//    }
//
//    @Test
//    public void unhire_and_rehire_positional_and_pass() {
////        try {
//            Assert.fail();
////        } catch (WarnException e) {
////            Assert.assertTrue(e.getMessage().equalsIgnoreCase(""));
////        } catch (Exception e) {
////            e.printStackTrace();
////            Assert.fail();
////        }
//    }
}
