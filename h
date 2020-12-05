[1mdiff --git a/src/main/java/ca/gkworkbench/bb2020api/config/bb2020Config.java b/src/main/java/ca/gkworkbench/bb2020api/config/bb2020Config.java[m
[1mindex 62685ea..d419c47 100644[m
[1m--- a/src/main/java/ca/gkworkbench/bb2020api/config/bb2020Config.java[m
[1m+++ b/src/main/java/ca/gkworkbench/bb2020api/config/bb2020Config.java[m
[36m@@ -1,13 +1,13 @@[m
 package ca.gkworkbench.bb2020api.config;[m
 [m
[31m-import ca.gkworkbench.bb2020api.player.template.bo.PlayerTemplateBO;[m
[31m-import ca.gkworkbench.bb2020api.player.template.bo.PlayerTemplateBOImpl;[m
[31m-import ca.gkworkbench.bb2020api.player.template.dao.PlayerTemplateDAO;[m
[31m-import ca.gkworkbench.bb2020api.player.template.dao.PlayerTemplateDAOImpl;[m
[31m-import ca.gkworkbench.bb2020api.team.template.bo.TeamTemplateBO;[m
[31m-import ca.gkworkbench.bb2020api.team.template.bo.TeamTemplateBOImpl;[m
[31m-import ca.gkworkbench.bb2020api.team.template.dao.TeamTemplateDAO;[m
[31m-import ca.gkworkbench.bb2020api.team.template.dao.TeamTemplateDAOImpl;[m
[32m+[m[32mimport ca.gkworkbench.bb2020api.player.bo.PlayerTemplateBO;[m
[32m+[m[32mimport ca.gkworkbench.bb2020api.player.bo.PlayerTemplateBOImpl;[m
[32m+[m[32mimport ca.gkworkbench.bb2020api.player.dao.PlayerTemplateDAO;[m
[32m+[m[32mimport ca.gkworkbench.bb2020api.player.dao.PlayerTemplateDAOImpl;[m
[32m+[m[32mimport ca.gkworkbench.bb2020api.team.bo.TeamTemplateBO;[m
[32m+[m[32mimport ca.gkworkbench.bb2020api.team.bo.TeamTemplateBOImpl;[m
[32m+[m[32mimport ca.gkworkbench.bb2020api.team.dao.TeamTemplateDAO;[m
[32m+[m[32mimport ca.gkworkbench.bb2020api.team.dao.TeamTemplateDAOImpl;[m
 import org.springframework.beans.factory.annotation.Autowired;[m
 import org.springframework.context.annotation.Bean;[m
 import org.springframework.context.annotation.Configuration;[m
[1mdiff --git a/src/main/java/ca/gkworkbench/bb2020api/player/bo/PlayerTemplateBO.java b/src/main/java/ca/gkworkbench/bb2020api/player/bo/PlayerTemplateBO.java[m
[1mindex 81465e9..a0c3704 100644[m
[1m--- a/src/main/java/ca/gkworkbench/bb2020api/player/bo/PlayerTemplateBO.java[m
[1m+++ b/src/main/java/ca/gkworkbench/bb2020api/player/bo/PlayerTemplateBO.java[m
[36m@@ -1,6 +1,6 @@[m
[31m-package ca.gkworkbench.bb2020api.player.template.bo;[m
[32m+[m[32mpackage ca.gkworkbench.bb2020api.player.bo;[m
 [m
[31m-import ca.gkworkbench.bb2020api.player.template.vo.PlayerTemplateVO;[m
[32m+[m[32mimport ca.gkworkbench.bb2020api.player.vo.PlayerTemplateVO;[m
 [m
 import java.util.List;[m
 [m
[1mdiff --git a/src/main/java/ca/gkworkbench/bb2020api/player/bo/PlayerTemplateBOImpl.java b/src/main/java/ca/gkworkbench/bb2020api/player/bo/PlayerTemplateBOImpl.java[m
[1mindex 37d0050..937a874 100644[m
[1m--- a/src/main/java/ca/gkworkbench/bb2020api/player/bo/PlayerTemplateBOImpl.java[m
[1m+++ b/src/main/java/ca/gkworkbench/bb2020api/player/bo/PlayerTemplateBOImpl.java[m
[36m@@ -1,7 +1,8 @@[m
[31m-package ca.gkworkbench.bb2020api.player.template.bo;[m
[32m+[m[32mpackage ca.gkworkbench.bb2020api.player.bo;[m
 [m
[31m-import ca.gkworkbench.bb2020api.player.template.dao.PlayerTemplateDAO;[m
[31m-import ca.gkworkbench.bb2020api.player.template.vo.PlayerTemplateVO;[m
[32m+[m[32mimport ca.gkworkbench.bb2020api.player.dao.PlayerTemplateDAO;[m
[32m+[m[32mimport ca.gkworkbench.bb2020api.player.vo.PlayerTemplateVO;[m
[32m+[m[32mimport ca.gkworkbench.bb2020api.skill.dao.SkillTemplateDAO;[m
 import com.google.gson.Gson;[m
 [m
 import java.util.List;[m
[36m@@ -9,6 +10,7 @@[m [mimport java.util.List;[m
 public class PlayerTemplateBOImpl implements PlayerTemplateBO {[m
 [m
     private PlayerTemplateDAO ptDAO;[m
[32m+[m[32m    private SkillTemplateDAO stDAO;[m
     private Gson gson;[m
 [m
     public PlayerTemplateBOImpl(PlayerTemplateDAO ptDAO) {[m
[1mdiff --git a/src/main/java/ca/gkworkbench/bb2020api/player/dao/PlayerTemplateDAO.java b/src/main/java/ca/gkworkbench/bb2020api/player/dao/PlayerTemplateDAO.java[m
[1mindex 868d3ec..285720c 100644[m
[1m--- a/src/main/java/ca/gkworkbench/bb2020api/player/dao/PlayerTemplateDAO.java[m
[1m+++ b/src/main/java/ca/gkworkbench/bb2020api/player/dao/PlayerTemplateDAO.java[m
[36m@@ -1,7 +1,6 @@[m
[31m-package ca.gkworkbench.bb2020api.player.template.dao;[m
[32m+[m[32mpackage ca.gkworkbench.bb2020api.player.dao;[m
 [m
[31m-import ca.gkworkbench.bb2020api.player.template.vo.PlayerTemplateVO;[m
[31m-import ca.gkworkbench.bb2020api.team.template.vo.TeamTemplateVO;[m
[32m+[m[32mimport ca.gkworkbench.bb2020api.player.vo.PlayerTemplateVO;[m
 [m
 import java.util.List;[m
 [m
[1mdiff --git a/src/main/java/ca/gkworkbench/bb2020api/player/dao/PlayerTemplateDAOImpl.java b/src/main/java/ca/gkworkbench/bb2020api/player/dao/PlayerTemplateDAOImpl.java[m
[1mindex 3b1435a..40b3e43 100644[m
[1m--- a/src/main/java/ca/gkworkbench/bb2020api/player/dao/PlayerTemplateDAOImpl.java[m
[1m+++ b/src/main/java/ca/gkworkbench/bb2020api/player/dao/PlayerTemplateDAOImpl.java[m
[36m@@ -1,8 +1,6 @@[m
[31m-package ca.gkworkbench.bb2020api.player.template.dao;[m
[32m+[m[32mpackage ca.gkworkbench.bb2020api.player.dao;[m
 [m
[31m-import ca.gkworkbench.bb2020api.player.template.vo.PlayerTemplateVO;[m
[31m-import ca.gkworkbench.bb2020api.team.template.dao.TeamTemplateDAO;[m
[31m-import ca.gkworkbench.bb2020api.team.template.vo.TeamTemplateVO;[m
[32m+[m[32mimport ca.gkworkbench.bb2020api.player.vo.PlayerTemplateVO;[m
 import org.springframework.jdbc.core.RowMapper;[m
 import org.springframework.jdbc.core.support.JdbcDaoSupport;[m
 [m
[1mdiff --git a/src/main/java/ca/gkworkbench/bb2020api/player/vo/PlayerTemplateVO.java b/src/main/java/ca/gkworkbench/bb2020api/player/vo/PlayerTemplateVO.java[m
[1mindex b15092d..af16d7c 100644[m
[1m--- a/src/main/java/ca/gkworkbench/bb2020api/player/vo/PlayerTemplateVO.java[m
[1m+++ b/src/main/java/ca/gkworkbench/bb2020api/player/vo/PlayerTemplateVO.java[m
[36m@@ -1,4 +1,4 @@[m
[31m-package ca.gkworkbench.bb2020api.player.template.vo;[m
[32m+[m[32mpackage ca.gkworkbench.bb2020api.player.vo;[m
 [m
 import java.util.List;[m
 [m
[1mdiff --git a/src/main/java/ca/gkworkbench/bb2020api/team/bo/TeamTemplateBO.java b/src/main/java/ca/gkworkbench/bb2020api/team/bo/TeamTemplateBO.java[m
[1mindex f5dbd7e..c2ba824 100644[m
[1m--- a/src/main/java/ca/gkworkbench/bb2020api/team/bo/TeamTemplateBO.java[m
[1m+++ b/src/main/java/ca/gkworkbench/bb2020api/team/bo/TeamTemplateBO.java[m
[36m@@ -1,9 +1,8 @@[m
[31m-package ca.gkworkbench.bb2020api.team.template.bo;[m
[32m+[m[32mpackage ca.gkworkbench.bb2020api.team.bo;[m
 [m
[31m-import ca.gkworkbench.bb2020api.team.template.vo.TeamTemplateVO;[m
[32m+[m[32mimport ca.gkworkbench.bb2020api.team.vo.TeamTemplateVO;[m
 [m
 import java.util.List;[m
[31m-import java.util.Map;[m
 [m
 public interface TeamTemplateBO {[m
 [m
[1mdiff --git a/src/main/java/ca/gkworkbench/bb2020api/team/bo/TeamTemplateBOImpl.java b/src/main/java/ca/gkworkbench/bb2020api/team/bo/TeamTemplateBOImpl.java[m
[1mindex f1cc695..9ffc4ad 100644[m
[1m--- a/src/main/java/ca/gkworkbench/bb2020api/team/bo/TeamTemplateBOImpl.java[m
[1m+++ b/src/main/java/ca/gkworkbench/bb2020api/team/bo/TeamTemplateBOImpl.java[m
[36m@@ -1,9 +1,9 @@[m
[31m-package ca.gkworkbench.bb2020api.team.template.bo;[m
[32m+[m[32mpackage ca.gkworkbench.bb2020api.team.bo;[m
 [m
[31m-import ca.gkworkbench.bb2020api.player.template.bo.PlayerTemplateBO;[m
[31m-import ca.gkworkbench.bb2020api.player.template.vo.PlayerTemplateVO;[m
[31m-import ca.gkworkbench.bb2020api.team.template.dao.TeamTemplateDAO;[m
[31m-import ca.gkworkbench.bb2020api.team.template.vo.TeamTemplateVO;[m
[32m+[m[32mimport ca.gkworkbench.bb2020api.player.bo.PlayerTemplateBO;[m
[32m+[m[32mimport ca.gkworkbench.bb2020api.player.vo.PlayerTemplateVO;[m
[32m+[m[32mimport ca.gkworkbench.bb2020api.team.dao.TeamTemplateDAO;[m
[32m+[m[32mimport ca.gkworkbench.bb2020api.team.vo.TeamTemplateVO;[m
 import com.google.gson.Gson;[m
 [m
 import java.util.List;[m
[1mdiff --git a/src/main/java/ca/gkworkbench/bb2020api/team/controller/TeamTemplateController.java b/src/main/java/ca/gkworkbench/bb2020api/team/controller/TeamTemplateController.java[m
[1mindex 5b91042..e9b29c1 100644[m
[1m--- a/src/main/java/ca/gkworkbench/bb2020api/team/controller/TeamTemplateController.java[m
[1m+++ b/src/main/java/ca/gkworkbench/bb2020api/team/controller/TeamTemplateController.java[m
[36m@@ -1,7 +1,6 @@[m
[31m-package ca.gkworkbench.bb2020api.team.template.controller;[m
[32m+[m[32mpackage ca.gkworkbench.bb2020api.team.controller;[m
 [m
[31m-import ca.gkworkbench.bb2020api.team.template.bo.TeamTemplateBO;[m
[31m-import ca.gkworkbench.bb2020api.team.template.vo.TeamTemplateVO;[m
[32m+[m[32mimport ca.gkworkbench.bb2020api.team.bo.TeamTemplateBO;[m
 import org.springframework.beans.factory.annotation.Autowired;[m
 import org.springframework.web.bind.annotation.PathVariable;[m
 import org.springframework.web.bind.annotation.RequestMethod;[m
[1mdiff --git a/src/main/java/ca/gkworkbench/bb2020api/team/dao/TeamTemplateDAO.java b/src/main/java/ca/gkworkbench/bb2020api/team/dao/TeamTemplateDAO.java[m
[1mindex 3ec48ca..83ab87e 100644[m
[1m--- a/src/main/java/ca/gkworkbench/bb2020api/team/dao/TeamTemplateDAO.java[m
[1m+++ b/src/main/java/ca/gkworkbench/bb2020api/team/dao/TeamTemplateDAO.java[m
[36m@@ -1,9 +1,8 @@[m
[31m-package ca.gkworkbench.bb2020api.team.template.dao;[m
[32m+[m[32mpackage ca.gkworkbench.bb2020api.team.dao;[m
 [m
[31m-import ca.gkworkbench.bb2020api.team.template.vo.TeamTemplateVO;[m
[32m+[m[32mimport ca.gkworkbench.bb2020api.team.vo.TeamTemplateVO;[m
 [m
 import java.util.List;[m
[31m-import java.util.Map;[m
 [m
 public interface TeamTemplateDAO {[m
 [m
[1mdiff --git a/src/main/java/ca/gkworkbench/bb2020api/team/dao/TeamTemplateDAOImpl.java b/src/main/java/ca/gkworkbench/bb2020api/team/dao/TeamTemplateDAOImpl.java[m
[1mindex 1252386..961c5d9 100644[m
[1m--- a/src/main/java/ca/gkworkbench/bb2020api/team/dao/TeamTemplateDAOImpl.java[m
[1m+++ b/src/main/java/ca/gkworkbench/bb2020api/team/dao/TeamTemplateDAOImpl.java[m
[36m@@ -1,6 +1,6 @@[m
[31m-package ca.gkworkbench.bb2020api.team.template.dao;[m
[32m+[m[32mpackage ca.gkworkbench.bb2020api.team.dao;[m
 [m
[31m-import ca.gkworkbench.bb2020api.team.template.vo.TeamTemplateVO;[m
[32m+[m[32mimport ca.gkworkbench.bb2020api.team.vo.TeamTemplateVO;[m
 import org.springframework.jdbc.core.RowMapper;[m
 import org.springframework.jdbc.core.support.JdbcDaoSupport;[m
 [m
[1mdiff --git a/src/main/java/ca/gkworkbench/bb2020api/team/vo/TeamTemplateVO.java b/src/main/java/ca/gkworkbench/bb2020api/team/vo/TeamTemplateVO.java[m
[1mindex 23a3fbf..c2143cf 100644[m
[1m--- a/src/main/java/ca/gkworkbench/bb2020api/team/vo/TeamTemplateVO.java[m
[1m+++ b/src/main/java/ca/gkworkbench/bb2020api/team/vo/TeamTemplateVO.java[m
[36m@@ -1,6 +1,6 @@[m
[31m-package ca.gkworkbench.bb2020api.team.template.vo;[m
[32m+[m[32mpackage ca.gkworkbench.bb2020api.team.vo;[m
 [m
[31m-import ca.gkworkbench.bb2020api.player.template.vo.PlayerTemplateVO;[m
[32m+[m[32mimport ca.gkworkbench.bb2020api.player.vo.PlayerTemplateVO;[m
 [m
 import java.util.List;[m
 [m
[1mdiff --git a/src/main/resources/init-db.sql b/src/main/resources/init-db.sql[m
[1mindex 360eb92..3be320d 100644[m
[1m--- a/src/main/resources/init-db.sql[m
[1m+++ b/src/main/resources/init-db.sql[m
[36m@@ -3,20 +3,20 @@[m [mcreate table PlayerTemplate (id int NOT NULL AUTO_INCREMENT, teamTemplateId int[m
 [m
 -- humans[m
 INSERT INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES (1, 'Human', 50000, 1, 'Old World Classic', 'Y');[m
[31m-INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (1, 'Lineman', 'Y', 16, 50000, 6, 3, 3, 4, 9);[m
[31m-INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (1, 'Thrower', 'N', 2, 80000, 6, 3, 3, 2, 9);[m
[31m-INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (1, 'Catcher', 'N', 4, 65000, 8, 2, 3, 5, 8);[m
[31m-INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (1, 'Blitzer', 'N', 4, 85000, 7, 3, 3, 4, 9);[m
[32m+[m[32mINSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (1, 'Human Lineman', 'Y', 16, 50000, 6, 3, 3, 4, 9);[m
[32m+[m[32mINSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (1, 'Human Thrower', 'N', 2, 80000, 6, 3, 3, 2, 9);[m
[32m+[m[32mINSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (1, 'Human Catcher', 'N', 4, 65000, 8, 2, 3, 5, 8);[m
[32m+[m[32mINSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (1, 'Human Blitzer', 'N', 4, 85000, 7, 3, 3, 4, 9);[m
 INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (1, 'Halfling Hopeful', 'N', 3, 30000, 5, 2, 3, 4, 7);[m
 INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (1, 'Ogre', 'N', 1, 140000, 5, 5, 4, 5, 10);[m
 [m
 --orcs[m
 INSERT INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES (2, 'Orcs', 60000, 1, 'Badlands Brawl', 'Y');[m
[31m-INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (2, 'Lineman', 'Y', 16, 50000, 5, 3, 3, 4, 10);[m
[31m-INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (2, 'Thrower', 'N', 2, 65000, 5, 3, 3, 3, 9);[m
[31m-INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (2, 'Blitzer', 'N', 4, 80000, 6, 3, 3, 4, 10);[m
[32m+[m[32mINSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (2, 'Orc Lineman', 'Y', 16, 50000, 5, 3, 3, 4, 10);[m
[32m+[m[32mINSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (2, 'Orc Thrower', 'N', 2, 65000, 5, 3, 3, 3, 9);[m
[32m+[m[32mINSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (2, 'Orc Blitzer', 'N', 4, 80000, 6, 3, 3, 4, 10);[m
 INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (2, 'Big Un Blocker', 'N', 4, 90000, 5, 4, 4, 0, 10);[m
[31m-INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (2, 'Goblin', 'N', 4, 40000, 6, 2, 3, 4, 8);[m
[32m+[m[32mINSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (2, 'Orc Goblin', 'N', 4, 40000, 6, 2, 3, 4, 8);[m
 INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (2, 'Untrained Troll', 'N', 1, 115000, 4, 5, 5, 5, 10);[m
 [m
 -- chaos chosen[m
[36m@@ -42,17 +42,17 @@[m [mINSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma,[m
 [m
 -- Dark Elves[m
 INSERT INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES (5, 'Dark Elves', 50000, 1, 'Elven Kingdom League', 'Y');[m
[31m-INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (5, 'Dark Elf', 'Y', 12, 70000, 6, 3, 2, 4, 9);[m
[31m-INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (5, 'Runner', 'N', 2, 80000, 7, 3, 2, 3, 8);[m
[31m-INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (5, 'Blitzer', 'N', 4, 100000, 7, 3, 2, 4, 9);[m
[32m+[m[32mINSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (5, 'Dark Elf Lineman', 'Y', 12, 70000, 6, 3, 2, 4, 9);[m
[32m+[m[32mINSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (5, 'Dark Elf Runner', 'N', 2, 80000, 7, 3, 2, 3, 8);[m
[32m+[m[32mINSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (5, 'Dark Elf Blitzer', 'N', 4, 100000, 7, 3, 2, 4, 9);[m
 INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (5, 'Assassin', 'N', 2, 85000, 7, 3, 2, 5, 8);[m
 INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (5, 'Witch Elf', 'N', 2, 110000, 7, 3, 2, 5, 8);[m
 [m
 -- dwarf[m
 INSERT INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES (6, 'Dwarf', 50000, 1, 'Old World Classic, Worlds Edge League', 'Y');[m
 INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (6, 'Dwarf Blocker', 'Y', 12, 70000, 4, 3, 4, 5, 10);[m
[31m-INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (6, 'Runner', 'N', 2, 85000, 6, 3, 3, 4, 9);[m
[31m-INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (6, 'Blitzer', 'N', 2, 80000, 5, 3, 3, 4, 10);[m
[32m+[m[32mINSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (6, 'Dwarf Runner', 'N', 2, 85000, 6, 3, 3, 4, 9);[m
[32m+[m[32mINSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (6, 'Dwarf Blitzer', 'N', 2, 80000, 5, 3, 3, 4, 10);[m
 INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (6, 'Troll Slayer', 'N', 2, 95000, 5, 3, 4, 0, 9);[m
 INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (6, 'Deathroller', 'N', 1, 170000, 4, 7, 5, 0, 11);[m
 [m
[1mdiff --git a/src/test/java/ca/gkworkbench/bb2020api/config/bb2020TestConfig.java b/src/test/java/ca/gkworkbench/bb2020api/config/bb2020TestConfig.java[m
[1mindex acda0dc..69df546 100644[m
[1m--- a/src/test/java/ca/gkworkbench/bb2020api/config/bb2020TestConfig.java[m
[1m+++ b/src/test/java/ca/gkworkbench/bb2020api/config/bb2020TestConfig.java[m
[36m@@ -1,19 +1,18 @@[m
 package ca.gkworkbench.bb2020api.config;[m
 [m
[31m-import ca.gkworkbench.bb2020api.player.template.bo.PlayerTemplateBO;[m
[31m-import ca.gkworkbench.bb2020api.player.template.bo.PlayerTemplateBOImpl;[m
[31m-import ca.gkworkbench.bb2020api.player.template.dao.PlayerTemplateDAO;[m
[31m-import ca.gkworkbench.bb2020api.player.template.dao.PlayerTemplateDAOImpl;[m
[31m-import ca.gkworkbench.bb2020api.team.template.bo.TeamTemplateBO;[m
[31m-import ca.gkworkbench.bb2020api.team.template.bo.TeamTemplateBOImpl;[m
[31m-import ca.gkworkbench.bb2020api.team.template.dao.TeamTemplateDAO;[m
[31m-import ca.gkworkbench.bb2020api.team.template.dao.TeamTemplateDAOImpl;[m
[32m+[m[32mimport ca.gkworkbench.bb2020api.player.bo.PlayerTemplateBO;[m
[32m+[m[32mimport ca.gkworkbench.bb2020api.player.bo.PlayerTemplateBOImpl;[m
[32m+[m[32mimport ca.gkworkbench.bb2020api.player.dao.PlayerTemplateDAO;[m
[32m+[m[32mimport ca.gkworkbench.bb2020api.player.dao.PlayerTemplateDAOImpl;[m
[32m+[m[32mimport ca.gkworkbench.bb2020api.team.bo.TeamTemplateBO;[m
[32m+[m[32mimport ca.gkworkbench.bb2020api.team.bo.TeamTemplateBOImpl;[m
[32m+[m[32mimport ca.gkworkbench.bb2020api.team.dao.TeamTemplateDAO;[m
[32m+[m[32mimport ca.gkworkbench.bb2020api.team.dao.TeamTemplateDAOImpl;[m
 import org.springframework.beans.factory.annotation.Autowired;[m
 import org.springframework.context.annotation.Bean;[m
 import org.springframework.context.annotation.Configuration;[m
 import org.springframework.context.annotation.PropertySource;[m
 import org.springframework.core.env.Environment;[m
[31m-import org.springframework.jdbc.datasource.DriverManagerDataSource;[m
 import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;[m
 import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;[m
 import org.springframework.transaction.annotation.EnableTransactionManagement;[m
[1mdiff --git a/src/test/java/ca/gkworkbench/bb2020api/team/bo/TeamTemplateBOTest.java b/src/test/java/ca/gkworkbench/bb2020api/team/bo/TeamTemplateBOTest.java[m
[1mindex 113c491..593d7a5 100644[m
[1m--- a/src/test/java/ca/gkworkbench/bb2020api/team/bo/TeamTemplateBOTest.java[m
[1m+++ b/src/test/java/ca/gkworkbench/bb2020api/team/bo/TeamTemplateBOTest.java[m
[36m@@ -1,7 +1,7 @@[m
[31m-package ca.gkworkbench.bb2020api.team.template.bo;[m
[32m+[m[32mpackage ca.gkworkbench.bb2020api.team.bo;[m
 [m
 import ca.gkworkbench.bb2020api.config.bb2020TestConfig;[m
[31m-import ca.gkworkbench.bb2020api.team.template.vo.TeamTemplateVO;[m
[32m+[m[32mimport ca.gkworkbench.bb2020api.team.vo.TeamTemplateVO;[m
 import org.junit.Assert;[m
 import org.junit.Test;[m
 import org.junit.runner.RunWith;[m
