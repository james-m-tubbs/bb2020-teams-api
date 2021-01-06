-- only for h2
SET MODE MYSQL;
-- user table
CREATE TABLE IF NOT EXISTS coaches(`id` int NOT NULL AUTO_INCREMENT, username VARCHAR(255) NOT NULL, `password` VARCHAR(255) NOT NULL, adminFlag CHAR(1), validatedFlag CHAR(1), PRIMARY KEY(`id`));
INSERT IGNORE INTO coaches (id,username, `password`, adminFlag, validatedFlag) values(1, 'admin', 'admin', 'Y', 'Y');
INSERT IGNORE INTO coaches (id,username, `password`, adminFlag, validatedFlag) values(2, 'user', 'pass', 'N', 'N');

-- skill table
CREATE TABLE IF NOT EXISTS Skills(id int NOT NULL AUTO_INCREMENT, skill VARCHAR(255) NOT NULL, type CHAR(1) NOT NULL, PRIMARY KEY(`id`));
-- general
INSERT IGNORE INTO Skills (id,skill, type) values(1, 'Block', 'G');
INSERT IGNORE INTO Skills (id,skill, type) values(2, 'Sure Hands', 'G');
INSERT IGNORE INTO Skills (id,skill, type) values(3, 'Dauntless', 'G');
INSERT IGNORE INTO Skills (id,skill, type) values(4, 'Dirty Player', 'G');
INSERT IGNORE INTO Skills (id,skill, type) values(5, 'Fend', 'G');
INSERT IGNORE INTO Skills (id,skill, type) values(6, 'Frenzy', 'G');
INSERT IGNORE INTO Skills (id,skill, type) values(7, 'Kick', 'G');
INSERT IGNORE INTO Skills (id,skill, type) values(8, 'Pro', 'G');
INSERT IGNORE INTO Skills (id,skill, type) values(9, 'Shadowing', 'G');
INSERT IGNORE INTO Skills (id,skill, type) values(10, 'Strip Ball', 'G');
INSERT IGNORE INTO Skills (id,skill, type) values(11, 'Tackle', 'G');
INSERT IGNORE INTO Skills (id,skill, type) values(12, 'Wrestle', 'G');
-- agility
INSERT IGNORE INTO Skills (id,skill, type) values(13, 'Diving Tackle', 'A');
INSERT IGNORE INTO Skills (id,skill, type) values(14, 'Defensive', 'A');
INSERT IGNORE INTO Skills (id,skill, type) values(15, 'Jump Up', 'A');
INSERT IGNORE INTO Skills (id,skill, type) values(16, 'Leap', 'A');
INSERT IGNORE INTO Skills (id,skill, type) values(17, 'Safe Pair of Hands', 'A');
INSERT IGNORE INTO Skills (id,skill, type) values(18, 'Side Step', 'A');
INSERT IGNORE INTO Skills (id,skill, type) values(19, 'Sneaky Git', 'A');
INSERT IGNORE INTO Skills (id,skill, type) values(20, 'Sprint', 'A');
INSERT IGNORE INTO Skills (id,skill, type) values(21, 'Sure Feet', 'A');
INSERT IGNORE INTO Skills (id,skill, type) values(22, 'Dodge', 'A');
INSERT IGNORE INTO Skills (id,skill, type) values(23, 'Catch', 'A');
INSERT IGNORE INTO Skills (id,skill, type) values(24, 'Diving Catch', 'A');
-- mutations
INSERT IGNORE INTO Skills (id,skill, type) values(25, 'Big Hand', 'M');
INSERT IGNORE INTO Skills (id,skill, type) values(26, 'Claws', 'M');
INSERT IGNORE INTO Skills (id,skill, type) values(27, 'Disturbing Presence', 'M');
INSERT IGNORE INTO Skills (id,skill, type) values(28, 'Extra Arms', 'M');
INSERT IGNORE INTO Skills (id,skill, type) values(29, 'Foul Appearance', 'M');
INSERT IGNORE INTO Skills (id,skill, type) values(30, 'Horns', 'M');
INSERT IGNORE INTO Skills (id,skill, type) values(31, 'Iron Hard Skin', 'M');
INSERT IGNORE INTO Skills (id,skill, type) values(32, 'Monstrous Mouth', 'M');
INSERT IGNORE INTO Skills (id,skill, type) values(33, 'Prehensile Tail', 'M');
INSERT IGNORE INTO Skills (id,skill, type) values(34, 'Tentacles', 'M');
INSERT IGNORE INTO Skills (id,skill, type) values(35, 'Two Heads', 'M');
INSERT IGNORE INTO Skills (id,skill, type) values(36, 'Very Long Legs', 'M');
-- passing
INSERT IGNORE INTO Skills (id,skill, type) values(37, 'Accurate', 'P');
INSERT IGNORE INTO Skills (id,skill, type) values(38, 'Cannoneer', 'P');
INSERT IGNORE INTO Skills (id,skill, type) values(39, 'Cloud Burster', 'P');
INSERT IGNORE INTO Skills (id,skill, type) values(40, 'Dump-off', 'P');
INSERT IGNORE INTO Skills (id,skill, type) values(41, 'Fumblerooskie', 'P');
INSERT IGNORE INTO Skills (id,skill, type) values(42, 'Hail Mary Pass', 'P');
INSERT IGNORE INTO Skills (id,skill, type) values(43, 'Leader', 'P');
INSERT IGNORE INTO Skills (id,skill, type) values(44, 'Nerves of Steel', 'P');
INSERT IGNORE INTO Skills (id,skill, type) values(45, 'On the Ball', 'P');
INSERT IGNORE INTO Skills (id,skill, type) values(46, 'Pass', 'P');
INSERT IGNORE INTO Skills (id,skill, type) values(47, 'Running Pass', 'P');
INSERT IGNORE INTO Skills (id,skill, type) values(48, 'Safe Pass', 'P');
-- strength
INSERT IGNORE INTO Skills (id,skill, type) values(49, 'Arm Bar', 'S');
INSERT IGNORE INTO Skills (id,skill, type) values(50, 'Brawler', 'S');
INSERT IGNORE INTO Skills (id,skill, type) values(51, 'Break Tackle', 'S');
INSERT IGNORE INTO Skills (id,skill, type) values(52, 'Grab', 'S');
INSERT IGNORE INTO Skills (id,skill, type) values(53, 'Guard', 'S');
INSERT IGNORE INTO Skills (id,skill, type) values(54, 'Juggernaut', 'S');
INSERT IGNORE INTO Skills (id,skill, type) values(55, 'Mighty Blow', 'S');
INSERT IGNORE INTO Skills (id,skill, type) values(56, 'Multiple Block', 'S');
INSERT IGNORE INTO Skills (id,skill, type) values(57, 'Pile Driver', 'S');
INSERT IGNORE INTO Skills (id,skill, type) values(58, 'Stand Firm', 'S');
INSERT IGNORE INTO Skills (id,skill, type) values(59, 'Strong Arm', 'S');
INSERT IGNORE INTO Skills (id,skill, type) values(60, 'Thick Skull', 'S');
-- traits
INSERT IGNORE INTO Skills (id,skill, type) values(61, 'Animal Savagery', 'T');
INSERT IGNORE INTO Skills (id,skill, type) values(62, 'Animosity', 'T');
INSERT IGNORE INTO Skills (id,skill, type) values(63, 'Always Hungry', 'T');
INSERT IGNORE INTO Skills (id,skill, type) values(64, 'Ball and Chain', 'T');
INSERT IGNORE INTO Skills (id,skill, type) values(65, 'Bombardier', 'T');
INSERT IGNORE INTO Skills (id,skill, type) values(66, 'Bone Head', 'T');
INSERT IGNORE INTO Skills (id,skill, type) values(67, 'Chainsaw', 'T');
INSERT IGNORE INTO Skills (id,skill, type) values(68, 'Decay', 'T');
INSERT IGNORE INTO Skills (id,skill, type) values(69, 'Hypnotic Gaze', 'T');
INSERT IGNORE INTO Skills (id,skill, type) values(70, 'Kick Team-Mate', 'T');
INSERT IGNORE INTO Skills (id,skill, type) values(71, 'Loner', 'T');
INSERT IGNORE INTO Skills (id,skill, type) values(72, 'No Hands', 'T');
INSERT IGNORE INTO Skills (id,skill, type) values(73, 'Plague Ridden', 'T');
INSERT IGNORE INTO Skills (id,skill, type) values(74, 'Pogo Stick', 'T');
INSERT IGNORE INTO Skills (id,skill, type) values(75, 'Projectile Vomit', 'T');
INSERT IGNORE INTO Skills (id,skill, type) values(76, 'Really Stupid', 'T');
INSERT IGNORE INTO Skills (id,skill, type) values(77, 'Regeneration', 'T');
INSERT IGNORE INTO Skills (id,skill, type) values(78, 'Right Stuff', 'T');
INSERT IGNORE INTO Skills (id,skill, type) values(79, 'Secret Weapon', 'T');
INSERT IGNORE INTO Skills (id,skill, type) values(80, 'Stab', 'T');
INSERT IGNORE INTO Skills (id,skill, type) values(81, 'Stunty', 'T');
INSERT IGNORE INTO Skills (id,skill, type) values(82, 'Swarming', 'T');
INSERT IGNORE INTO Skills (id,skill, type) values(83, 'Swoop', 'T');
INSERT IGNORE INTO Skills (id,skill, type) values(84, 'Take Root', 'T');
INSERT IGNORE INTO Skills (id,skill, type) values(85, 'Titchy', 'T');
INSERT IGNORE INTO Skills (id,skill, type) values(86, 'Throw Team-mate', 'T');
INSERT IGNORE INTO Skills (id,skill, type) values(87, 'Kick Team-mate', 'T');
INSERT IGNORE INTO Skills (id,skill, type) values(88, 'Timmm-ber!', 'T');
INSERT IGNORE INTO Skills (id,skill, type) values(89, 'Unchannelled Fury', 'T');

CREATE TABLE IF NOT EXISTS TeamTemplate (id int NOT NULL, teamTemplateName varchar(255) NOT NULL, rerollCost int NOT NULL, tier int NOT NULL, specialRules varchar(255), apothecary char(1) NOT NULL, bigGuyMax int NOT NULL DEFAULT -1, PRIMARY KEY(`id`));
CREATE TABLE IF NOT EXISTS PlayerTemplate (id int NOT NULL AUTO_INCREMENT, teamTemplateId int NOT NULL, position varchar(255) NOT NULL, linemanFlag char(1) NOT NULL, bigGuyFlag char(1) NOT NULL DEFAULT 'N', qty int NOT NULL, cost int NOT NULL, ma int NOT NULL, st int NOT NULL, ag int NOT NULL, pa int NOT NULL, av int NOT NULL, primarySkills VARCHAR(255), secondarySkills VARCHAR(255), PRIMARY KEY(`id`), FOREIGN KEY(teamTemplateId) REFERENCES TeamTemplate(id));
CREATE TABLE IF NOT EXISTS SkillTemplate(id int NOT NULL AUTO_INCREMENT, playerTemplateId int NOT NULL, skillId int NOT NULL, skillValue varchar(255), PRIMARY KEY(`id`), FOREIGN KEY(playerTemplateId) REFERENCES PlayerTemplate(id), FOREIGN KEY(skillId) REFERENCES Skills(id), UNIQUE(playerTemplateId, skillId));

-- START OF TEAMS --
-- black orc
INSERT IGNORE INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES (1, 'Black Orc', 60000, 2, 'Badlands Brawl, Bribery and Corruption', 'Y');
-- Goblin Bruiser
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (1, 1, 'Goblin Bruiser Lineman', 'Y', 12, 45000, 6, 2, 3, 4, 8,'A','GPS');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (1, (select id from Skills where skill = 'Dodge') );
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (1, (select id from Skills where skill = 'Right Stuff') );
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (1, (select id from Skills where skill = 'Stunty') );
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (1, (select id from Skills where skill = 'Thick Skull') );
-- black orc
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (2, 1, 'Black Orc', 'N', 4, 90000, 4, 4, 4, 5, 10,'GS','AP');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (2, (select id from Skills where skill = 'Brawler') );
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (2, (select id from Skills where skill = 'Grab') );
-- Trained Troll
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, bigGuyFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (3, 1, 'Trained Troll', 'N', 'Y', 1, 115000, 4, 5, 5, 5, 10,'S','AGP');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (3, (select id from Skills where skill = 'Always Hungry'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (3, (select id from Skills where skill = 'Loner'),'3+');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (3, (select id from Skills where skill = 'Mighty Blow'),'+1');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (3, (select id from Skills where skill = 'Projectile Vomit'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (3, (select id from Skills where skill = 'Really Stupid'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (3, (select id from Skills where skill = 'Regeneration'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (3, (select id from Skills where skill = 'Throw Team-mate'));

-- chaos chosen
INSERT IGNORE INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary, bigGuyMax) VALUES (2, 'Chaos Chosen', 60000, 2, 'Favoured of... Chaos Undivided, Khorne, Nurgle, Slaanesh, or Tzeentch', 'Y', 1);
-- beastmen
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (4, 2, 'Beastmen', 'Y', 16, 60000, 6, 3, 3, 4, 9,'GMS','AP');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (4, (select id from Skills where skill = 'Horns'));
-- chosen blockers
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (5, 2, 'Chosen Blockers', 'N', 4, 100000, 5, 4, 3, 5, 10,'GMS','A');
-- chaos troll
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, bigGuyFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (6, 2, 'Chaos Troll', 'N', 'Y', 1, 115000, 4, 5, 5, 5, 10,'MS','AG');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (6, (select id from Skills where skill = 'Always Hungry'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (6, (select id from Skills where skill = 'Loner'),'4+');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (6, (select id from Skills where skill = 'Mighty Blow'),'+1');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (6, (select id from Skills where skill = 'Projectile Vomit'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (6, (select id from Skills where skill = 'Really Stupid'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (6, (select id from Skills where skill = 'Regeneration'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (6, (select id from Skills where skill = 'Throw Team-mate'));
-- chaos ogre
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, bigGuyFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (7, 2, 'Chaos Ogre', 'N', 'Y', 1, 140000, 5, 5, 4, 5, 10,'MS','AG');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (7, (select id from Skills where skill = 'Bone Head'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (7, (select id from Skills where skill = 'Loner'),'4+');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (7, (select id from Skills where skill = 'Mighty Blow'),'+1');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (7, (select id from Skills where skill = 'Thick Skull'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (7, (select id from Skills where skill = 'Throw Team-mate'));
-- minotaur
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, bigGuyFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (8, 2, 'Minotaur', 'N', 'Y', 1, 150000, 5, 5, 4, 0, 9,'MS','AG');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (8, (select id from Skills where skill = 'Loner'),'4+');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (8, (select id from Skills where skill = 'Frenzy'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (8, (select id from Skills where skill = 'Horns'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (8, (select id from Skills where skill = 'Mighty Blow'), '+1');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (8, (select id from Skills where skill = 'Thick Skull'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (8, (select id from Skills where skill = 'Unchannelled Fury'));

-- chaos renegades
INSERT IGNORE INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary, bigGuyMax) VALUES (3, 'Chaos Renegades', 70000, 1, 'Favoured of... Chaos Undivided, Khorne, Nurgle, Slaanesh, or Tzeentch', 'Y', 3);
-- renegade human
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (9, 3, 'Renegade Human', 'Y', 12, 50000, 6, 3, 3, 4, 9,'GM','AS');
-- renegade thrower
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (10, 3, 'Renegade Thrower', 'N', 1, 75000, 6, 3, 3, 3, 9,'GMP','AS');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (10, (select id from Skills where skill = 'Animosity'), 'all team-mates');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (10, (select id from Skills where skill = 'Pass') );
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (10, (select id from Skills where skill = 'Safe Pair of Hands') );
-- renegade goblin
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (11, 3, 'Renegade Goblin', 'N', 1, 40000, 6, 2, 3, 4, 8,'AM','GP');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (11, (select id from Skills where skill = 'Animosity'), 'all team-mates');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (11, (select id from Skills where skill = 'Dodge') );
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (11, (select id from Skills where skill = 'Right Stuff') );
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (11, (select id from Skills where skill = 'Stunty') );
-- renegade orc
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (12, 3, 'Renegade Orc', 'N', 1, 50000, 5, 3, 3, 5, 10,'GM','AS');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (12, (select id from Skills where skill = 'Animosity'), 'all team-mates');
-- renegade skaven
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (13, 3, 'Renegade Skaven', 'N', 1, 50000, 7, 3, 3, 4, 8,'GM','AS');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (13, (select id from Skills where skill = 'Animosity'), 'all team-mates');
-- renegade dark elf
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (14, 3, 'Renegade Dark Elf', 'N', 1, 75000, 6, 3, 2, 3, 9,'AGM','PS');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (14, (select id from Skills where skill = 'Animosity'), 'all team-mates');
-- renegade troll
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, bigGuyFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (15, 3, 'Renegade Troll', 'N', 'Y', 1, 115000, 4, 5, 5, 5, 10,'S','AGM');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (15, (select id from Skills where skill = 'Always Hungry'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (15, (select id from Skills where skill = 'Loner'),'4+');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (15, (select id from Skills where skill = 'Mighty Blow'),'+1');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (15, (select id from Skills where skill = 'Projectile Vomit'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (15, (select id from Skills where skill = 'Really Stupid'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (15, (select id from Skills where skill = 'Regeneration'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (15, (select id from Skills where skill = 'Throw Team-mate'));
-- renegade ogre
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, bigGuyFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (16, 3, 'Renegade Ogre', 'N', 'Y', 1, 140000, 5, 5, 4, 5, 10,'S','AGM');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (16, (select id from Skills where skill = 'Bone Head') );
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (16, (select id from Skills where skill = 'Loner'), '4+');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (16, (select id from Skills where skill = 'Mighty Blow'), '+1' );
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (16, (select id from Skills where skill = 'Thick Skull'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (16, (select id from Skills where skill = 'Throw Team-mate'));
-- renegade minotaur
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, bigGuyFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (17, 3, 'Renegade Minotaur', 'N', 'Y', 1, 150000, 5, 5, 4, 0, 9,'S','AGM');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (17, (select id from Skills where skill = 'Loner'),'4+');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (17, (select id from Skills where skill = 'Frenzy'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (17, (select id from Skills where skill = 'Horns'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (17, (select id from Skills where skill = 'Mighty Blow'), '+1');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (17, (select id from Skills where skill = 'Thick Skull'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (17, (select id from Skills where skill = 'Unchannelled Fury'));
-- renegade rat ogre
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, bigGuyFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (18, 3, 'Renegade Rat Ogre', 'N', 'Y', 1, 150000, 6, 5, 4, 0, 9,'S','AGM');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (18, (select id from Skills where skill = 'Animal Savagery'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (18, (select id from Skills where skill = 'Frenzy'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (18, (select id from Skills where skill = 'Loner'),'4+');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (18, (select id from Skills where skill = 'Mighty Blow'), '+1');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (18, (select id from Skills where skill = 'Prehensile Tail'));

-- Dark Elves
INSERT IGNORE INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES (4, 'Dark Elves', 50000, 1, 'Elven Kingdoms League', 'Y');
-- dark elf lineman
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (19, 4, 'Dark Elf Lineman', 'Y', 12, 70000, 6, 3, 2, 4, 9,'AG','S');
-- runner
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (20, 4, 'Runner', 'N', 2, 80000, 7, 3, 2, 3, 8,'AGP','S');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (20, (select id from Skills where skill = 'Dump-off'));
-- blitzer
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (21, 4, 'Blitzer', 'N', 4, 100000, 7, 3, 2, 4, 9,'AG','PS');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (21, (select id from Skills where skill = 'Block'));
-- assassin
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (22, 4, 'Assassin', 'N', 2, 85000, 7, 3, 2, 5, 8,'AG','PS');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (22, (select id from Skills where skill = 'Shadowing'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (22, (select id from Skills where skill = 'Stab'));
-- witch elf
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (23, 4, 'Witch Elf', 'N', 2, 110000, 7, 3, 2, 5, 8,'AG','PS');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (23, (select id from Skills where skill = 'Dodge'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (23, (select id from Skills where skill = 'Frenzy'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (23, (select id from Skills where skill = 'Jump Up'));

-- dwarf
INSERT IGNORE INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES (5, 'Dwarf', 50000, 1, 'Old World Classic, Worlds Edge League', 'Y');
-- dwarf blocker lineman
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (24, 5, 'Dwarf Blocker Lineman', 'Y', 12, 70000, 4, 3, 4, 5, 10,'GS','A');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (24, (select id from Skills where skill = 'Block'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (24, (select id from Skills where skill = 'Tackle'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (24, (select id from Skills where skill = 'Thick Skull'));
-- runner
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (25, 5, 'Runner', 'N', 2, 85000, 6, 3, 3, 4, 9,'GP','AS');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (25, (select id from Skills where skill = 'Sure Hands'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (25, (select id from Skills where skill = 'Thick Skull'));
-- blitzer
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (26, 5, 'Blitzer', 'N', 2, 80000, 5, 3, 3, 4, 10,'GS','AP');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (26, (select id from Skills where skill = 'Block'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (26, (select id from Skills where skill = 'Thick Skull'));
-- troll slayer
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (27, 5, 'Troll Slayer', 'N', 2, 95000, 5, 3, 4, 0, 9,'GS','A');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (27, (select id from Skills where skill = 'Block'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (27, (select id from Skills where skill = 'Dauntless'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (27, (select id from Skills where skill = 'Frenzy'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (27, (select id from Skills where skill = 'Thick Skull'));
-- deathroller
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, bigGuyFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (28, 5, 'Deathroller', 'N', 'Y', 1, 170000, 4, 7, 5, 0, 11,'S','AG');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (28, (select id from Skills where skill = 'Break Tackle'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (28, (select id from Skills where skill = 'Dirty Player'),'+2');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (28, (select id from Skills where skill = 'Juggernaut'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (28, (select id from Skills where skill = 'Loner'),'4+');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (28, (select id from Skills where skill = 'Mighty Blow'), '+1');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (28, (select id from Skills where skill = 'No Hands'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (28, (select id from Skills where skill = 'Secret Weapon'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (28, (select id from Skills where skill = 'Stand Firm'));

-- elven union
INSERT IGNORE INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES (6, 'Elven Union', 50000, 2, 'Elven Kingdoms League', 'Y');
-- lineman
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (29, 6, 'Lineman', 'Y', 12, 60000, 6, 3, 2, 4, 8,'AG','S');
-- thrower
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (30, 6, 'Thrower', 'N', 2, 75000, 6, 3, 2, 2, 8,'AGP','S');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (30, (select id from Skills where skill = 'Pass'));
-- catcher
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (31, 6, 'Catcher', 'N', 4, 100000, 8, 3, 2, 4, 8,'AG','S');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (31, (select id from Skills where skill = 'Catch'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (31, (select id from Skills where skill = 'Nerves of Steel'));
-- blitzer
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (32, 6, 'Blitzer', 'N', 2, 115000, 7, 3, 2, 3, 9,'AG','PS');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (32, (select id from Skills where skill = 'Block'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (32, (select id from Skills where skill = 'Side Step'));

-- goblins
INSERT IGNORE INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES (7, 'Goblin', 60000, 3, 'Badlands Brawl, Bribery and Corruption, Underworld Challenge', 'Y');
-- goblin lineman
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (33, 7, 'Goblin Lineman', 'Y', 16, 40000, 6, 2, 3, 4, 8,'A','GPS');
-- bomma
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (34, 7, 'Bomma', 'N', 1, 45000, 6, 2, 3, 4, 8,'A','GPS');
-- looney
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (35, 7, 'Looney', 'N', 1, 40000, 6, 2, 3, 0, 8,'A','GS');
-- fanatic
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (36, 7, 'Fanatic', 'N', 1, 70000, 3, 7, 3, 0, 8,'S','AG');
-- pogoer
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (37, 7, 'Pogoer', 'N', 1, 75000, 7, 2, 3, 5, 8,'A','GPS');
-- 'ooligan
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (38, 7, '''Ooligan', 'N', 1, 65000, 6, 2, 3, 6, 8,'A','GPS');
-- doom diver
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (39, 7, 'Doom Diver', 'N', 1, 60000, 6, 2, 3, 6, 8,'A','GS');
-- trained troll
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, bigGuyFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (40, 7, 'Trained Troll', 'N', 'Y', 2, 115000, 4, 5, 5, 5, 10,'S','AGP');


-- halflings
INSERT IGNORE INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES (8, 'Halfling', 60000, 3, 'Halfling Thimble Cup, Old World Classic', 'Y');
-- halfling hopeful lineman
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (41, 8, 'Halfling Hopeful Lineman', 'Y', 16, 30000, 5, 2, 3, 4, 7,'A','GS');
-- halfling hefty
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (42, 8, 'Halfling Hefty', 'Y', 2, 50000, 5, 2, 3, 3, 8,'AP','GS');
-- halfling catcher
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (43, 8, 'Halfling Catcher', 'Y', 2, 55000, 5, 2, 3, 5, 7,'A','GS');
-- altern forest treeman
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, bigGuyFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (44, 8, 'Altern Forest Treeman', 'N', 'Y', 2, 120000, 2, 6, 5, 5, 11,'S','AGP');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (44, (select id from Skills where skill = 'Mighty Blow'), '+1' );
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (44, (select id from Skills where skill = 'Stand Firm'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (44, (select id from Skills where skill = 'Strong Arm'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (44, (select id from Skills where skill = 'Take Root'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (44, (select id from Skills where skill = 'Thick Skull'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (44, (select id from Skills where skill = 'Throw Team-mate'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (44, (select id from Skills where skill = 'Timmm-ber!'));


-- humans
INSERT IGNORE INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES (9, 'Human', 50000, 1, 'Old World Classic', 'Y');
-- Lineman
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (45, 9, 'Human Lineman', 'Y', 16, 50000, 6, 3, 3, 4, 9, 'G', 'AS');
-- Thrower
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (46, 9, 'Thrower', 'N', 2, 80000, 6, 3, 3, 2, 9, 'GP', 'AS');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (46, (select id from Skills where skill = 'Pass') );
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (46, (select id from Skills where skill = 'Sure Hands') );
-- Catcher
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (47, 9, 'Catcher', 'N', 4, 65000, 8, 2, 3, 5, 8, 'AG', 'SP');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (47, (select id from Skills where skill = 'Catch') );
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (47, (select id from Skills where skill = 'Dodge') );
-- Blitzer
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (48, 9, 'Blitzer', 'N', 4, 85000, 7, 3, 3, 4, 9, 'GS','AP');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (48, (select id from Skills where skill = 'Block') );
-- HalfLing Hopeful
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (49, 9, 'Halfling Hopeful', 'N', 3, 30000, 5, 2, 3, 4, 7,'A','GS');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (49, (select id from Skills where skill = 'Dodge') );
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (49, (select id from Skills where skill = 'Right Stuff') );
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (49, (select id from Skills where skill = 'Stunty') );
-- Ogre
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, bigGuyFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (50, 9, 'Ogre', 'N', 'Y', 1, 140000, 5, 5, 4, 5, 10,'S','AG');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (50, (select id from Skills where skill = 'Bone Head') );
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (50, (select id from Skills where skill = 'Loner'), '4+');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (50, (select id from Skills where skill = 'Mighty Blow'), '+1' );
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (50, (select id from Skills where skill = 'Thick Skull'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (50, (select id from Skills where skill = 'Throw Team-mate'));

-- imperial nobility
INSERT IGNORE INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES (10, 'Imperial Nobility', 70000, 2, 'Old World Classic', 'Y');
-- imperial retainer lineman
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (51, 10, 'Imperial Retainer Lineman', 'Y', 16, 45000, 6, 3, 4, 4, 8, 'G', 'AS');
-- imperial thrower
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (52, 10, 'Imperial Thrower', 'N', 2, 75000, 6, 3, 3, 3, 9, 'GP', 'AS');
-- noble blitzer
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (53, 10, 'Noble Blitzer', 'N', 2, 105000, 7, 3, 3, 4, 9, 'AG', 'PS');
-- bodyguard
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (54, 10, 'Bodyguard', 'N', 4, 90000, 6, 3, 3, 5, 9, 'GS', 'A');
-- ogre
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, bigGuyFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (55, 10, 'Ogre', 'N', 'Y', 1, 140000, 5, 5, 4, 5, 10,'S','AG');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (55, (select id from Skills where skill = 'Bone Head'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (55, (select id from Skills where skill = 'Loner'),'4+');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (55, (select id from Skills where skill = 'Mighty Blow'),'+1');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (55, (select id from Skills where skill = 'Thick Skull'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (55, (select id from Skills where skill = 'Throw Team-mate'));

-- lizardmen
INSERT IGNORE INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES (11, 'Lizardman', 70000, 1, 'Lustrian Superleague', 'Y');
-- skink runner lineman
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (56, 11, 'Skink Runner Lineman', 'Y', 12, 60000, 8, 2, 3, 4, 8,'A','GPS');
-- chameleon skink
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (57, 11, 'Chameleon Skink', 'N', 2, 70000, 7, 2, 3, 3, 8,'A','GPS');
-- saurus blocker
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (58, 11, 'Saurus Blocker', 'N', 6, 85000, 7, 2, 3, 3, 8,'GS','A');
-- kroxigor
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, bigGuyFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (59, 11, 'Kroxigor', 'N', 'Y', 1, 140000, 5, 5, 4, 5, 10,'S','AG');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (59, (select id from Skills where skill = 'Bone Head'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (59, (select id from Skills where skill = 'Loner'),'4+');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (59, (select id from Skills where skill = 'Mighty Blow'),'+1');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (59, (select id from Skills where skill = 'Prehensile Tail'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (59, (select id from Skills where skill = 'Thick Skull'));

-- necromantic horror
INSERT IGNORE INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES (12, 'Necromantic Horror', 70000, 2, 'Masters of Undeath, Sylvanian Spotlight', 'N');
-- zombie lineman
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (60, 12, 'Zombie Lineman', 'Y', 16, 60000, 4, 3, 4, 0, 9,'G','AS');
-- ghoul runners
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (61, 12, 'Ghoul Runner', 'N', 2, 75000, 7, 3, 3, 4, 8,'AG','PS');
-- wraiths
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (62, 12, 'Wraith', 'N', 2, 95000, 6, 3, 3, 0, 9,'GS','A');
-- werewolves
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (63, 12, 'Werewolf', 'N', 2, 125000, 8, 3, 3, 4, 9,'AG','PS');
-- flesh golems
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (64, 12, 'Flesh Golem', 'N', 2, 115000, 4, 4, 4, 0, 10,'GS','A');


-- nurgle
INSERT IGNORE INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES (13, 'Nurgle', 70000, 2, 'Favoured of Nurgle', 'N');
-- rotter lineman
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (65, 12, 'Rotter Lineman', 'Y', 12, 35000, 5, 3, 4, 6, 9,'GM','AS');
-- pestigor
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (66, 12, 'Pestigor', 'N', 4, 75000, 6, 3, 3, 4, 9,'GMS','AP');
-- bloater
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (67, 12, 'Bloater', 'N', 4, 115000, 4, 4, 4, 6, 10,'GMS','A');
-- rotspawn
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, bigGuyFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (68, 11, 'Rotspawn', 'N', 'Y', 1, 140000, 4, 5, 5, 0, 10,'S','AGM');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (68, (select id from Skills where skill = 'Disturbing Presence'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (68, (select id from Skills where skill = 'Foul Appearance'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (68, (select id from Skills where skill = 'Loner'),'4+');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (68, (select id from Skills where skill = 'Mighty Blow'),'+1');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (68, (select id from Skills where skill = 'Plague Ridden'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (68, (select id from Skills where skill = 'Really Stupid'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (68, (select id from Skills where skill = 'Regeneration'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (68, (select id from Skills where skill = 'Tentacles'));

-- ogre
INSERT IGNORE INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES (14, 'Ogre', 70000, 3, 'Badlands Brawl, Low Cost Linemen, Old World Classic', 'Y');
-- gnoblar lineman
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (69, 14, 'Gnoblar Lineman', 'Y', 16, 15000, 5, 1, 3, 5, 6,'A','G');
-- ogre runt punter
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, bigGuyFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (70, 14, 'Ogre Runt Punter', 'N', 'Y', 1, 145000, 5, 5, 4, 4, 10,'PS','AG');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (70, (select id from Skills where skill = 'Bone Head') );
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (70, (select id from Skills where skill = 'Kick Team-mate'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (70, (select id from Skills where skill = 'Mighty Blow'), '+1' );
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (70, (select id from Skills where skill = 'Thick Skull'));
-- ogre blocker
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, bigGuyFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (71, 14, 'Ogre Blocker', 'N', 'Y', 5, 140000, 5, 5, 4, 5, 10,'S','AGP');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (71, (select id from Skills where skill = 'Bone Head') );
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (71, (select id from Skills where skill = 'Mighty Blow'), '+1' );
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (71, (select id from Skills where skill = 'Thick Skull'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (71, (select id from Skills where skill = 'Throw Team-mate'));

-- old world alliance
INSERT IGNORE INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary, bigGuyMax) VALUES (15, 'Old World Alliance', 70000, 1, 'Old World Classic', 'Y', 1);
-- old world human Lineman
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (72, 15, 'Old World Human Lineman', 'Y', 16, 50000, 6, 3, 3, 4, 9, 'G', 'AS');
-- old world human Thrower
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (73, 15, 'Old World Human Thrower', 'N', 2, 80000, 6, 3, 3, 3, 9, 'GP', 'AS');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (73, (select id from Skills where skill = 'Animosity'), 'all Dwarf and Halfling team-mates');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (73, (select id from Skills where skill = 'Pass') );
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (73, (select id from Skills where skill = 'Sure Hands') );
-- old world human Catcher
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (74, 15, 'Old World Human Catcher', 'N', 4, 65000, 8, 2, 3, 5, 8, 'AG', 'SP');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (74, (select id from Skills where skill = 'Animosity'), 'all Dwarf and Halfling team-mates');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (74, (select id from Skills where skill = 'Catch') );
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (74, (select id from Skills where skill = 'Dodge') );
-- old world human Blitzer
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (75, 15, 'Old World Human Blitzer', 'N', 4, 90000, 7, 3, 3, 4, 9, 'GS','AP');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (75, (select id from Skills where skill = 'Animosity'), 'all Dwarf and Halfling team-mates');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (75, (select id from Skills where skill = 'Block') );
-- old world dwarf blocker
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (76, 15, 'Old World Dwarf Blocker', 'Y', 12, 70000, 4, 3, 4, 5, 10,'GS','A');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (76, (select id from Skills where skill = 'Arm Bar'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (76, (select id from Skills where skill = 'Brawler'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (76, (select id from Skills where skill = 'Loner'),'3+');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (76, (select id from Skills where skill = 'Thick Skull'));
-- old world dwarf runner
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (77, 15, 'Old World Dwarf Runner', 'N', 2, 85000, 6, 3, 3, 4, 9,'GP','AS');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (77, (select id from Skills where skill = 'Loner'),'3+');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (77, (select id from Skills where skill = 'Sure Hands'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (77, (select id from Skills where skill = 'Thick Skull'));
-- old world dwarf blitzer
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (78, 15, 'Old World Dwarf Blitzer', 'N', 2, 80000, 5, 3, 3, 4, 10,'GS','A');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (78, (select id from Skills where skill = 'Block'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (78, (select id from Skills where skill = 'Loner'),'3+');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (78, (select id from Skills where skill = 'Thick Skull'));
-- old world dwarf troll slayer
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (79, 15, 'Old World Dwarf Troll Slayer', 'N', 2, 95000, 5, 3, 4, 0, 9,'GS','A');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (79, (select id from Skills where skill = 'Block'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (79, (select id from Skills where skill = 'Dauntless'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (79, (select id from Skills where skill = 'Frenzy'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (79, (select id from Skills where skill = 'Loner'),'3+');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (79, (select id from Skills where skill = 'Thick Skull'));
-- old world halfling hopeful
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (80, 15, 'Old World Halfling Hopeful', 'Y', 16, 30000, 5, 2, 3, 4, 7,'A','GS');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (80, (select id from Skills where skill = 'Animosity'), 'all Dwarf and Human team-mates');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (80, (select id from Skills where skill = 'Dodge'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (80, (select id from Skills where skill = 'Right Stuff'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (80, (select id from Skills where skill = 'Stunty'));
-- ogre
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, bigGuyFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (81, 15, 'Ogre', 'N', 'Y', 1, 140000, 5, 5, 4, 5, 10,'S','AG');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (81, (select id from Skills where skill = 'Bone Head') );
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (81, (select id from Skills where skill = 'Loner'), '4+');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (81, (select id from Skills where skill = 'Mighty Blow'), '+1' );
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (81, (select id from Skills where skill = 'Thick Skull'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (81, (select id from Skills where skill = 'Throw Team-mate'));
-- altern forest treeman
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, bigGuyFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (82, 15, 'Altern Forest Treeman', 'N', 'Y', 2, 120000, 2, 6, 5, 5, 11,'S','AGP');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (82, (select id from Skills where skill = 'Loner'), '4+');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (82, (select id from Skills where skill = 'Mighty Blow'), '+1' );
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (82, (select id from Skills where skill = 'Stand Firm'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (82, (select id from Skills where skill = 'Strong Arm'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (82, (select id from Skills where skill = 'Take Root'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (82, (select id from Skills where skill = 'Thick Skull'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (82, (select id from Skills where skill = 'Throw Team-mate'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (82, (select id from Skills where skill = 'Timmm-ber!'));

-- orcs
INSERT IGNORE INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES (16, 'Orc', 60000, 1, 'Badlands Brawl', 'Y');
-- lineman
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (83, 16, 'Orc Lineman', 'Y', 16, 50000, 5, 3, 3, 4, 10,'G','AS');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (83, (select id from Skills where skill = 'Animosity'), 'Orc Linemen');
-- thrower
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (84, 16, 'Thrower', 'N', 2, 65000, 5, 3, 3, 3, 9,'GP','AS');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (84, (select id from Skills where skill = 'Animosity'), 'all team-mates');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (84, (select id from Skills where skill = 'Pass'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (84, (select id from Skills where skill = 'Sure Hands'));
-- blitzer
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (85, 16, 'Blitzer', 'N', 4, 80000, 6, 3, 3, 4, 10,'GS','AP');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (85, (select id from Skills where skill = 'Animosity'), 'all team-mates');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (85, (select id from Skills where skill = 'Block'));
-- big-un blocker
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (86, 16, 'Big Un Blocker', 'N', 4, 90000, 5, 4, 4, 0, 10,'GS','A');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (86, (select id from Skills where skill = 'Animosity'), 'Big Un Blockers');
-- goblin
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (87, 16, 'Goblin', 'N', 4, 40000, 6, 2, 3, 4, 8,'A','GS');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (87, (select id from Skills where skill = 'Dodge'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (87, (select id from Skills where skill = 'Right Stuff'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (87, (select id from Skills where skill = 'Stunty'));
-- troll
INSERT IGNORE INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, bigGuyFlag, qty, cost, ma, st, ag, pa, av, primarySkills, secondarySkills ) values (88, 16, 'Untrained Troll', 'N', 'Y', 1, 115000, 4, 5, 5, 5, 10,'S','AGP');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (88, (select id from Skills where skill = 'Always Hungry'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (88, (select id from Skills where skill = 'Loner'),'4+');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (88, (select id from Skills where skill = 'Mighty Blow'),'+1');
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (88, (select id from Skills where skill = 'Projectile Vomit'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (88, (select id from Skills where skill = 'Really Stupid'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (88, (select id from Skills where skill = 'Regeneration'));
INSERT IGNORE INTO SkillTemplate(playerTemplateId, skillId) values (88, (select id from Skills where skill = 'Throw Team-mate'));

-- shambling undead
INSERT IGNORE INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES (17, 'Shambling Undead', 70000, 1, 'Masters of Undeath, Sylvanian Spotlight', 'N');

-- skaven
INSERT IGNORE INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES (18, 'Skaven', 50000, 1, 'Underworld Challenge', 'Y');

-- snotling
INSERT IGNORE INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES (19, 'Snotling', 60000, 3, 'Bribery and Corruption, Low Cost Linemen, Underworld Challenge', 'Y');

-- underworld denizens
INSERT IGNORE INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES (20, 'Underworld Denizens', 70000, 2, 'Bribery and Corruption, Underworld Challenge', 'Y');

-- wood elves
INSERT IGNORE INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES (21, 'Wood Elf', 50000, 1, 'Elven Kingdoms League', 'Y');


-- TEAMS OF LEGEND
-- https://www.warhammer-community.com/wp-content/uploads/2020/11/lFZy1SIuNmWvxPj1.pdf
-- amazons
INSERT IGNORE INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES (22, 'Amazons', 50000, 1, 'Lustrian Superleague', 'Y');


-- chaos dwarf
INSERT IGNORE INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES (23, 'Chaos Dwarf', 70000, 1, 'Badlands Brawl, Favoured of..., Worlds Edge Superleague, ', 'Y');


-- high elf
INSERT IGNORE INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES (24, 'High Elf', 50000, 2, 'Elven Kingdoms League', 'Y');


-- norse
INSERT IGNORE INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES (25, 'Norse', 60000, 1, 'Lustrian Superleague, Old World Classic', 'Y');


-- tomb kings
INSERT IGNORE INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES (26, 'Tomb Kings', 70000, 2, 'Sylvanian Spotlight', 'Y');


-- vampire
INSERT IGNORE INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES (27, 'Vampire', 70000, 2, 'Sylvanian Spotlight', 'Y');

-- NAF RULES FOR TOURNAMENTS 2021
-- https://www.thenaf.net/wp-content/uploads/2020/12/NAF-Rules-for-Tournaments-2021.pdf
-- daemons of khorne
INSERT IGNORE INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES (28, 'Daemons of Khorne', 70000, 2, 'Favored of Khorne', 'Y');


-- slann
INSERT IGNORE INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES (28, 'Slann', 50000, 2, 'Lustria Superleague', 'Y');


-- teams
CREATE TABLE IF NOT EXISTS Teams(id int NOT NULL AUTO_INCREMENT, coachId int NOT NULL, teamTemplateId int NOT NULL, teamName varchar(255) NOT NULL, totalCas int NOT NULL DEFAULT 0, totalTouchdowns int NOT NULL DEFAULT 0, treasury int NOT NULL DEFAULT 1000000, leaguePoints int NOT NULL DEFAULT 0, rerolls int NOT NULL DEFAULT 0, coaches int NOT NULL DEFAULT 0, cheerleaders int NOT NULL DEFAULT 0, apothecaryFlag char(1) default 'N', teamValue int NOT NULL DEFAULT 0, currentTeamValue int NOT NULL DEFAULT 0, dedicatedFans int NOT NULL DEFAULT 1, PRIMARY KEY(id), FOREIGN KEY(teamTemplateId) REFERENCES TeamTemplate(id), FOREIGN KEY(coachId) REFERENCES coaches(id), UNIQUE(teamName));

-- players
CREATE TABLE IF NOT EXISTS Players(id int NOT NULL AUTO_INCREMENT, teamId int NOT NULL, playerTemplateId int NOT NULL, name VARCHAR(255), gamesPlayed int NOT NULL DEFAULT 0, spp int NOT NULL DEFAULT 0, currentValue int NOT NULL default 0, cp int NOT NULL default 0, pi int NOT NULL default 0, cas int NOT NULL default 0, td int NOT NULL default 0, mvp int NOT NULL default 0, injuredFlag char(1) NOT NULL DEFAULT 'N', tempRetiredFlag char(1) NOT NULL DEFAULT 'N', firedFlag char(1) NOT NULL DEFAULT 'N', PRIMARY KEY(id), FOREIGN KEY (TeamId) REFERENCES Teams(id) ON DELETE CASCADE, FOREIGN KEY(PlayerTemplateId) REFERENCES PlayerTemplate(id), UNIQUE(name, teamId));
-- player skill
CREATE TABLE IF NOT EXISTS PlayerSkills(id int NOT NULL AUTO_INCREMENT, playerId int NOT NULL, skillValue int, PRIMARY KEY(id), FOREIGN KEY (playerId) REFERENCES Players(id) ON DELETE CASCADE);
