--test data
INSERT IGNORE INTO Teams (id, coachId, teamTemplateId, teamName) values (1, 1, 1, 'The Rookie Testers');
INSERT IGNORE INTO Players(id, teamId, playerTemplateId, name, gamesPlayed, spp, cas, mvp, pi, td, currentValue) values (1, 1, 2, 'Tiberius Tosser', 6, 15, 1, 2, 3 ,4, 80000);
INSERT IGNORE INTO Players(id,teamId, playerTemplateId, name) values (2, 1, 4, 'Bobby Blitzer 1');
INSERT IGNORE INTO Players(id,teamId, playerTemplateId, name) values (3, 1, 4, 'Bobby Blitzer 2');
INSERT IGNORE INTO Players(id,teamId, playerTemplateId, name) values (4, 1, 4, 'Bobby Blitzer 3');
INSERT IGNORE INTO Players(id,teamId, playerTemplateId, name) values (5, 1, 4, 'Bobby Blitzer 4');
INSERT IGNORE INTO Players(id,teamId, playerTemplateId, name) values (6, 1, 1, 'Leino Lino 1');

INSERT IGNORE INTO Teams (id, coachId, teamTemplateId, teamName) values (2, 2, 2, 'The Orcy Orcsters');

INSERT IGNORE INTO Teams (id, coachId, teamTemplateId, teamName) values (3, 1, 3, 'Chaos Chosen Test 1');

INSERT IGNORE INTO Teams (id, coachId, teamTemplateId, teamName, treasury, currentTeamValue) values (4, 1, 3, 'Chaos Chosen Test 2', 50000, 260000);
INSERT IGNORE INTO Players(id,teamId, playerTemplateId, name, gamesPlayed, currentValue) values (7, 4, 16, 'Ogre?', 0, 140000);
INSERT IGNORE INTO Players(id,teamId, playerTemplateId, name, gamesPlayed, currentValue) values (24, 4, 14, 'Chosen Lineman 1', 6, 120000);

INSERT IGNORE INTO Teams (id, coachId, teamTemplateId, teamName) values (5, 2, 1, 'Da Hoomies');
INSERT IGNORE INTO Players(id,teamId, playerTemplateId, name, currentValue) values (8, 5, 1, 'Leino Lino 1', 50000);
INSERT IGNORE INTO Players(id,teamId, playerTemplateId, name, currentValue) values (9, 5, 1, 'Leino Lino 2', 50000);
INSERT IGNORE INTO Players(id,teamId, playerTemplateId, name, currentValue) values (10, 5, 1, 'Leino Lino 3', 50000);
INSERT IGNORE INTO Players(id,teamId, playerTemplateId, name, currentValue) values (11, 5, 1, 'Leino Lino 4', 50000);
INSERT IGNORE INTO Players(id,teamId, playerTemplateId, name, currentValue) values (12, 5, 1, 'Leino Lino 5', 50000);
INSERT IGNORE INTO Players(id,teamId, playerTemplateId, name, currentValue) values (13, 5, 1, 'Leino Lino 6', 50000);
INSERT IGNORE INTO Players(id,teamId, playerTemplateId, name, currentValue) values (14, 5, 1, 'Leino Lino 7', 50000);
INSERT IGNORE INTO Players(id,teamId, playerTemplateId, name, currentValue) values (15, 5, 1, 'Leino Lino 8', 50000);
INSERT IGNORE INTO Players(id,teamId, playerTemplateId, name, currentValue) values (16, 5, 1, 'Leino Lino 9', 50000);
INSERT IGNORE INTO Players(id,teamId, playerTemplateId, name, currentValue) values (17, 5, 1, 'Leino Lino 10', 50000);
INSERT IGNORE INTO Players(id,teamId, playerTemplateId, name, currentValue) values (18, 5, 1, 'Leino Lino 11', 50000);
INSERT IGNORE INTO Players(id,teamId, playerTemplateId, name, currentValue) values (19, 5, 1, 'Leino Lino 12', 50000);
INSERT IGNORE INTO Players(id,teamId, playerTemplateId, name, currentValue) values (20, 5, 1, 'Leino Lino 13', 50000);
INSERT IGNORE INTO Players(id,teamId, playerTemplateId, name, currentValue) values (21, 5, 1, 'Leino Lino 14', 50000);
INSERT IGNORE INTO Players(id,teamId, playerTemplateId, name, currentValue) values (22, 5, 1, 'Leino Lino 15', 50000);
INSERT IGNORE INTO Players(id,teamId, playerTemplateId, name, currentValue) values (23, 5, 1, 'Leino Lino 16', 50000);

INSERT IGNORE INTO Teams (id, coachId, teamTemplateId, teamName) values (6, 1, 3, 'Chaos Chosen Test 3');

INSERT IGNORE INTO Teams (id, coachId, teamTemplateId, teamName, treasury) values (7, 1, 3, 'Chaos Chosen Test 4', 1000000);