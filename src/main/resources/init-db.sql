--user table
CREATE TABLE coaches(id int NOT NULL AUTO_INCREMENT, username VARCHAR(255) NOT NULL, password VARCHAR(255) NOT NULL, adminFlag CHAR(1), validatedFlag CHAR(1), PRIMARY KEY(id));
INSERT INTO coaches (id,username, password, adminFlag, validatedFlag) values(1, 'admin', 'admin', 'Y', 'Y');

--skill table
CREATE TABLE Skills(id int NOT NULL AUTO_INCREMENT, skill VARCHAR(255) NOT NULL, type CHAR(1) NOT NULL);
--general
INSERT INTO Skills (id,skill, type) values(1, 'Block', 'G');
INSERT INTO Skills (id,skill, type) values(2, 'Sure Hands', 'G');
INSERT INTO Skills (id,skill, type) values(3, 'Dauntless', 'G');
INSERT INTO Skills (id,skill, type) values(4, 'Dirty Player', 'G');
INSERT INTO Skills (id,skill, type) values(5, 'Fend', 'G');
INSERT INTO Skills (id,skill, type) values(6, 'Frenzy', 'G');
INSERT INTO Skills (id,skill, type) values(7, 'Kick', 'G');
INSERT INTO Skills (id,skill, type) values(8, 'Pro', 'G');
INSERT INTO Skills (id,skill, type) values(9, 'Shadowing', 'G');
INSERT INTO Skills (id,skill, type) values(10, 'Strip Ball', 'G');
INSERT INTO Skills (id,skill, type) values(11, 'Tackle', 'G');
INSERT INTO Skills (id,skill, type) values(12, 'Wrestle', 'G');
--agility
INSERT INTO Skills (id,skill, type) values(13, 'Diving Tackle', 'A');
INSERT INTO Skills (id,skill, type) values(14, 'Defensive', 'A');
INSERT INTO Skills (id,skill, type) values(15, 'Jump Up', 'A');
INSERT INTO Skills (id,skill, type) values(16, 'Leap', 'A');
INSERT INTO Skills (id,skill, type) values(17, 'Safe Pair of Hands', 'A');
INSERT INTO Skills (id,skill, type) values(18, 'Sneaky Git', 'A');
INSERT INTO Skills (id,skill, type) values(19, 'Sprint', 'A');
INSERT INTO Skills (id,skill, type) values(20, 'Sure Feet', 'A');
INSERT INTO Skills (id,skill, type) values(21, 'Dodge', 'A');
INSERT INTO Skills (id,skill, type) values(22, 'Catch', 'A');
INSERT INTO Skills (id,skill, type) values(23, 'Diving Catch', 'A');
--mutations
INSERT INTO Skills (id,skill, type) values(24, 'Big Hand', 'M');
INSERT INTO Skills (id,skill, type) values(25, 'Claws', 'M');
INSERT INTO Skills (id,skill, type) values(26, 'Distubring Presence', 'M');
INSERT INTO Skills (id,skill, type) values(27, 'Extra Arms', 'M');
INSERT INTO Skills (id,skill, type) values(28, 'Foul Appearance', 'M');
INSERT INTO Skills (id,skill, type) values(29, 'Horns', 'M');
INSERT INTO Skills (id,skill, type) values(30, 'Iron Hard Skin', 'M');
INSERT INTO Skills (id,skill, type) values(31, 'Monstrous Mouth', 'M');
INSERT INTO Skills (id,skill, type) values(32, 'Prehensile Tail', 'M');
INSERT INTO Skills (id,skill, type) values(33, 'Tentacles', 'M');
INSERT INTO Skills (id,skill, type) values(34, 'Two Heads', 'M');
INSERT INTO Skills (id,skill, type) values(35, 'Very Long Legs', 'M');
--passing
INSERT INTO Skills (id,skill, type) values(36, 'Accurate', 'P');
INSERT INTO Skills (id,skill, type) values(37, 'Cannoneer', 'P');
INSERT INTO Skills (id,skill, type) values(38, 'Cloud Burster', 'P');
INSERT INTO Skills (id,skill, type) values(39, 'Dump-Off', 'P');
INSERT INTO Skills (id,skill, type) values(40, 'Fumblerooskie', 'P');
INSERT INTO Skills (id,skill, type) values(41, 'Hail Mary Pass', 'P');
INSERT INTO Skills (id,skill, type) values(42, 'Leader', 'P');
INSERT INTO Skills (id,skill, type) values(43, 'Nerves of Steel', 'P');
INSERT INTO Skills (id,skill, type) values(44, 'On the Ball', 'P');
INSERT INTO Skills (id,skill, type) values(45, 'Pass', 'P');
INSERT INTO Skills (id,skill, type) values(46, 'Running Pass', 'P');
INSERT INTO Skills (id,skill, type) values(47, 'Safe Pass', 'P');
--strength
INSERT INTO Skills (id,skill, type) values(48, 'Arm Bar', 'S');
INSERT INTO Skills (id,skill, type) values(49, 'Brawler', 'S');
INSERT INTO Skills (id,skill, type) values(50, 'Break Tackle', 'S');
INSERT INTO Skills (id,skill, type) values(51, 'Grab', 'S');
INSERT INTO Skills (id,skill, type) values(52, 'Guard', 'S');
INSERT INTO Skills (id,skill, type) values(53, 'Juggernaut', 'S');
INSERT INTO Skills (id,skill, type) values(54, 'Mighty Blow', 'S');
INSERT INTO Skills (id,skill, type) values(55, 'Multiple Block', 'S');
INSERT INTO Skills (id,skill, type) values(56, 'Pile Driver', 'S');
INSERT INTO Skills (id,skill, type) values(57, 'Stand Firm', 'S');
INSERT INTO Skills (id,skill, type) values(58, 'Strong Arm', 'S');
INSERT INTO Skills (id,skill, type) values(59, 'Thick Skull', 'S');
--traits
INSERT INTO Skills (id,skill, type) values(60, 'Animal Savagery', 'T');
INSERT INTO Skills (id,skill, type) values(61, 'Animosity', 'T');
INSERT INTO Skills (id,skill, type) values(62, 'Always Hungry', 'T');
INSERT INTO Skills (id,skill, type) values(63, 'Ball and Chain', 'T');
INSERT INTO Skills (id,skill, type) values(64, 'Bombardier', 'T');
INSERT INTO Skills (id,skill, type) values(65, 'Bone Head', 'T');
INSERT INTO Skills (id,skill, type) values(66, 'Chainsaw', 'T');
INSERT INTO Skills (id,skill, type) values(67, 'Decay', 'T');
INSERT INTO Skills (id,skill, type) values(68, 'Hypnotic Gaze', 'T');
INSERT INTO Skills (id,skill, type) values(69, 'Kick Team-Mate', 'T');
INSERT INTO Skills (id,skill, type) values(70, 'Loner', 'T');
INSERT INTO Skills (id,skill, type) values(71, 'No Hands', 'T');
INSERT INTO Skills (id,skill, type) values(72, 'Plague Ridden', 'T');
INSERT INTO Skills (id,skill, type) values(73, 'Pogo Stick', 'T');
INSERT INTO Skills (id,skill, type) values(74, 'Projectile Vomit', 'T');
INSERT INTO Skills (id,skill, type) values(75, 'Really Stupid', 'T');
INSERT INTO Skills (id,skill, type) values(76, 'Regeneration', 'T');
INSERT INTO Skills (id,skill, type) values(77, 'Right Stuff', 'T');
INSERT INTO Skills (id,skill, type) values(78, 'Secret Weapon', 'T');
INSERT INTO Skills (id,skill, type) values(79, 'Stab', 'T');
INSERT INTO Skills (id,skill, type) values(80, 'Stunty', 'T');
INSERT INTO Skills (id,skill, type) values(81, 'Swarming', 'T');
INSERT INTO Skills (id,skill, type) values(82, 'Swoop', 'T');
INSERT INTO Skills (id,skill, type) values(83, 'Take Root', 'T');
INSERT INTO Skills (id,skill, type) values(84, 'Titchy', 'T');
INSERT INTO Skills (id,skill, type) values(85, 'Throw Team-mate', 'T');
INSERT INTO Skills (id,skill, type) values(86, 'Timm-ber!', 'T');
INSERT INTO Skills (id,skill, type) values(87, 'Unchannelled Fury', 'T');

CREATE TABLE TeamTemplate (id int NOT NULL, teamTemplateName varchar(255) NOT NULL, rerollCost int NOT NULL, tier int NOT NULL, specialRules varchar(255), apothecary char(1) NOT NULL, PRIMARY KEY (id));
CREATE TABLE PlayerTemplate (id int NOT NULL AUTO_INCREMENT, teamTemplateId int NOT NULL, position varchar(255) NOT NULL, linemanFlag char(1) NOT NULL, qty int NOT NULL, cost int NOT NULL, ma int NOT NULL, st int NOT NULL, ag int NOT NULL, pa int NOT NULL, av int NOT NULL, primary_skills VARCHAR(255), secondary_skills VARCHAR(255), PRIMARY KEY (id), FOREIGN KEY(teamTemplateId) REFERENCES TeamTemplate(id));
CREATE TABLE SkillTemplate(id int NOT NULL AUTO_INCREMENT, playerTemplateId int NOT NULL, skillId int NOT NULL, skillValue varchar(255), PRIMARY KEY (id), FOREIGN KEY(playerTemplateId) REFERENCES PlayerTemplate(id), FOREIGN KEY(skillId) REFERENCES Skills(id));

-- START OF TEAMS --
-- black orc
INSERT INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES (7, 'Black Orc', 60000, 2, 'Badlands Brawl, Bribery and Corruption', 'Y');
--Goblin Bruiser
INSERT INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primary_skills, secondary_skills ) values (38, 7, 'Goblin Bruiser', 'Y', 12, 45000, 6, 2, 3, 4, 8,'A','GPS');
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (38, select(id) from Skills where skill = 'Dodge' );
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (38, select(id) from Skills where skill = 'Right Stuff' );
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (38, select(id) from Skills where skill = 'Stunty' );
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (38, select(id) from Skills where skill = 'Thick Skull' );
--black orc
INSERT INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primary_skills, secondary_skills ) values (39, 7, 'Black Orc', 'N', 4, 90000, 4, 4, 4, 5, 10,'GS','AP');
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (39, select(id) from Skills where skill = 'Brawler' );
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (39, select(id) from Skills where skill = 'Grab' );
--Trained Troll
INSERT INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primary_skills, secondary_skills ) values (40, 7, 'Trained Troll', 'N', 1, 115000, 4, 5, 5, 5, 10,'S','AGP');
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (40, select(id) from Skills where skill = 'Always Hungry');
INSERT INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (40, select(id) from Skills where skill = 'Loner','3+');
INSERT INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (40, select(id) from Skills where skill = 'Mighty Blow','+1');
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (40, select(id) from Skills where skill = 'Projectile Vomit');
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (40, select(id) from Skills where skill = 'Really Stupid');
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (40, select(id) from Skills where skill = 'Regeneration');
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (40, select(id) from Skills where skill = 'Throw Team-mate');

-- chaos chosen
INSERT INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES (3, 'Chaos Chosen', 60000, 2, 'Favoured of... Undivided, Khorne, Nurgle, Slannesh, or Tzeench', 'Y');
--beastmen
INSERT INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primary_skills, secondary_skills ) values (13, 3, 'Beastmen', 'Y', 16, 60000, 6, 3, 3, 4, 9,'GMS','AP');
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (13, select(id) from Skills where skill = 'Horns');
--chosen blockers
INSERT INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primary_skills, secondary_skills ) values (14, 3, 'Chosen Blockers', 'N', 4, 100000, 5, 4, 3, 5, 10,'GMS','A');
--chaos troll
INSERT INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primary_skills, secondary_skills ) values (15, 3, 'Chaos Troll', 'N', 1, 115000, 4, 5, 5, 5, 10,'MS','AG');
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (15, select(id) from Skills where skill = 'Always Hungry');
INSERT INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (15, select(id) from Skills where skill = 'Loner','4+');
INSERT INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (15, select(id) from Skills where skill = 'Mighty Blow','+1');
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (15, select(id) from Skills where skill = 'Projectile Vomit');
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (15, select(id) from Skills where skill = 'Really Stupid');
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (15, select(id) from Skills where skill = 'Regeneration');
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (15, select(id) from Skills where skill = 'Throw Team-mate');
--chaos ogre
INSERT INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primary_skills, secondary_skills ) values (16, 3, 'Chaos Ogre', 'N', 1, 140000, 5, 5, 4, 5, 10,'MS','AG');
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (16, select(id) from Skills where skill = 'Bone Head');
INSERT INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (16, select(id) from Skills where skill = 'Loner','4+');
INSERT INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (16, select(id) from Skills where skill = 'Mighty Blow','+1');
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (16, select(id) from Skills where skill = 'Thick Skull');
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (16, select(id) from Skills where skill = 'Throw Team-mate');
--minotaur
INSERT INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primary_skills, secondary_skills ) values (17, 3, 'Minotaur', 'N', 1, 150000, 5, 5, 4, 0, 9,'MS','AG');
INSERT INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (17, select(id) from Skills where skill = 'Loner','4+');
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (17, select(id) from Skills where skill = 'Frenzy');
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (17, select(id) from Skills where skill = 'Horns');
INSERT INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (17, select(id) from Skills where skill = 'Mighty Blow', '+1');
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (17, select(id) from Skills where skill = 'Thick Skull');
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (17, select(id) from Skills where skill = 'Unchannelled Fury');

-- chaos renegades
INSERT INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES (4, 'Chaos Renegades', 70000, 1, 'Favoured of... Undivided, Khorne, Nurgle, Slannesh, or Tzeench', 'Y');
INSERT INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primary_skills, secondary_skills ) values (18, 4, 'Renegade Human', 'Y', 12, 50000, 6, 3, 3, 4, 9,'GM','AS');
INSERT INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primary_skills, secondary_skills ) values (19, 4, 'Renegade Thrower', 'N', 1, 75000, 6, 3, 3, 3, 9,'GMP','AS');
INSERT INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primary_skills, secondary_skills ) values (20, 4, 'Renegade Goblin', 'N', 1, 40000, 6, 2, 3, 4, 8,'AM','GP');
INSERT INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primary_skills, secondary_skills ) values (21, 4, 'Renegade Orc', 'N', 1, 50000, 5, 3, 3, 5, 10,'GM','AS');
INSERT INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primary_skills, secondary_skills ) values (22, 4, 'Renegade Skaven', 'N', 1, 50000, 7, 3, 3, 4, 8,'GM','AS');
INSERT INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primary_skills, secondary_skills ) values (23, 4, 'Renegade Dark Elf', 'N', 1, 75000, 6, 3, 2, 3, 9,'AGM','PS');
INSERT INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primary_skills, secondary_skills ) values (24, 4, 'Renegade Troll', 'N', 1, 115000, 4, 5, 5, 5, 10,'S','AGM');
INSERT INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primary_skills, secondary_skills ) values (25, 4, 'Renegade Ogre', 'N', 1, 140000, 5, 5, 4, 5, 10,'S','AGM');
INSERT INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primary_skills, secondary_skills ) values (26, 4, 'Renegade Minotaur', 'N', 1, 150000, 5, 5, 4, 0, 9,'S','AGM');
INSERT INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primary_skills, secondary_skills ) values (27, 4, 'Renegade Rat Ogre', 'N', 1, 150000, 6, 5, 4, 0, 9,'S','AGM');

-- Dark Elves
INSERT INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES (5, 'Dark Elves', 50000, 1, 'Elven Kingdom League', 'Y');
INSERT INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primary_skills, secondary_skills ) values (28, 5, 'Dark Elf Lineman', 'Y', 12, 70000, 6, 3, 2, 4, 9,'AG','S');
INSERT INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primary_skills, secondary_skills ) values (29, 5, 'Dark Elf Runner', 'N', 2, 80000, 7, 3, 2, 3, 8,'AGP','S');
INSERT INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primary_skills, secondary_skills ) values (30, 5, 'Dark Elf Blitzer', 'N', 4, 100000, 7, 3, 2, 4, 9,'AG','PS');
INSERT INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primary_skills, secondary_skills ) values (31, 5, 'Assassin', 'N', 2, 85000, 7, 3, 2, 5, 8,'AG','PS');
INSERT INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primary_skills, secondary_skills ) values (32, 5, 'Witch Elf', 'N', 2, 110000, 7, 3, 2, 5, 8,'AG','PS');

-- dwarf
INSERT INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES (6, 'Dwarf', 50000, 1, 'Old World Classic, Worlds Edge League', 'Y');
INSERT INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primary_skills, secondary_skills ) values (33, 6, 'Dwarf Blocker', 'Y', 12, 70000, 4, 3, 4, 5, 10,'','');
INSERT INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primary_skills, secondary_skills ) values (34, 6, 'Dwarf Runner', 'N', 2, 85000, 6, 3, 3, 4, 9,'','');
INSERT INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primary_skills, secondary_skills ) values (35, 6, 'Dwarf Blitzer', 'N', 2, 80000, 5, 3, 3, 4, 10,'','');
INSERT INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primary_skills, secondary_skills ) values (36, 6, 'Troll Slayer', 'N', 2, 95000, 5, 3, 4, 0, 9,'','');
INSERT INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primary_skills, secondary_skills ) values (37, 6, 'Deathroller', 'N', 1, 170000, 4, 7, 5, 0, 11,'','');

-- humans
INSERT INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES (1, 'Human', 50000, 1, 'Old World Classic', 'Y');
--Lineman
INSERT INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primary_skills, secondary_skills ) values (1, 1, 'Human Lineman', 'Y', 16, 50000, 6, 3, 3, 4, 9, 'G', 'AS');
--Thrower
INSERT INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primary_skills, secondary_skills ) values (2, 1, 'Human Thrower', 'N', 2, 80000, 6, 3, 3, 2, 9, 'GP', 'AS');
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (2, select(id) from Skills where skill = 'Pass' );
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (2, select(id) from Skills where skill = 'Sure Hands' );
--Catcher
INSERT INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primary_skills, secondary_skills ) values (3, 1, 'Human Catcher', 'N', 4, 65000, 8, 2, 3, 5, 8, 'AG', 'SP');
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (3, select(id) from Skills where skill = 'Catch' );
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (3, select(id) from Skills where skill = 'Dodge' );
--Blitzer
INSERT INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primary_skills, secondary_skills ) values (4, 1, 'Human Blitzer', 'N', 4, 85000, 7, 3, 3, 4, 9, 'GS','AP');
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (4, select(id) from Skills where skill = 'Block' );
--HalfLing Hopeful
INSERT INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primary_skills, secondary_skills ) values (5, 1, 'Halfling Hopeful', 'N', 3, 30000, 5, 2, 3, 4, 7,'A','GS');
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (5, select(id) from Skills where skill = 'Dodge' );
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (5, select(id) from Skills where skill = 'Right Stuff' );
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (5, select(id) from Skills where skill = 'Stunty' );
--Ogre
INSERT INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primary_skills, secondary_skills ) values (6, 1, 'Ogre', 'N', 1, 140000, 5, 5, 4, 5, 10,'S','AG');
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (6, select(id) from Skills where skill = 'Bone Head' );
INSERT INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (6, select(id) from Skills where skill = 'Loner', '4+');
INSERT INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (6, select(id) from Skills where skill = 'Mighty Blow', '+1' );
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (6, select(id) from Skills where skill = 'Thick Skull');
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (6, select(id) from Skills where skill = 'Throw Team-mate');

--orcs
INSERT INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES (2, 'Orc', 60000, 1, 'Badlands Brawl', 'Y');
--lineman
INSERT INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primary_skills, secondary_skills ) values (7, 2, 'Orc Lineman', 'Y', 16, 50000, 5, 3, 3, 4, 10,'G','AS');
INSERT INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (7, select(id) from Skills where skill = 'Animosity', 'Orc Linemen');
--thrower
INSERT INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primary_skills, secondary_skills ) values (8, 2, 'Orc Thrower', 'N', 2, 65000, 5, 3, 3, 3, 9,'GP','AS');
INSERT INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (8, select(id) from Skills where skill = 'Animosity', 'All Team-mates');
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (8, select(id) from Skills where skill = 'Pass');
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (8, select(id) from Skills where skill = 'Sure Hands');
--blitzer
INSERT INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primary_skills, secondary_skills ) values (9, 2, 'Orc Blitzer', 'N', 4, 80000, 6, 3, 3, 4, 10,'GS','AP');
INSERT INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (9, select(id) from Skills where skill = 'Animosity', 'All Team-mates');
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (9, select(id) from Skills where skill = 'Block');
--big-un blocker
INSERT INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primary_skills, secondary_skills ) values (10, 2, 'Big Un Blocker', 'N', 4, 90000, 5, 4, 4, 0, 10,'GS','A');
INSERT INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (10, select(id) from Skills where skill = 'Animosity', 'Big-Un Blocker');
--goblin
INSERT INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primary_skills, secondary_skills ) values (11, 2, 'Orc Goblin', 'N', 4, 40000, 6, 2, 3, 4, 8,'A','GS');
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (11, select(id) from Skills where skill = 'Dodge');
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (11, select(id) from Skills where skill = 'Right Stuff');
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (11, select(id) from Skills where skill = 'Stunty');
--troll
INSERT INTO PlayerTemplate(id, teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av, primary_skills, secondary_skills ) values (12, 2, 'Untrained Troll', 'N', 1, 115000, 4, 5, 5, 5, 10,'S','AGP');
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (12, select(id) from Skills where skill = 'Always Hungry');
INSERT INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (12, select(id) from Skills where skill = 'Loner','4+');
INSERT INTO SkillTemplate(playerTemplateId, skillId, skillValue) values (12, select(id) from Skills where skill = 'Mighty Blow','+1');
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (12, select(id) from Skills where skill = 'Projectile Vomit');
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (12, select(id) from Skills where skill = 'Really Stupid');
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (12, select(id) from Skills where skill = 'Regeneration');
INSERT INTO SkillTemplate(playerTemplateId, skillId) values (12, select(id) from Skills where skill = 'Throw Team-mate');

-- teams
CREATE TABLE Teams(id int NOT NULL AUTO_INCREMENT, coachId int NOT NULL, teamTemplateId int NOT NULL, teamName varchar(255) NOT NULL, totalCas int NOT NULL DEFAULT 0, totalTouchdowns int NOT NULL DEFAULT 0, treasury int NOT NULL DEFAULT 1000000, leaguePoints int NOT NULL DEFAULT 0, rerolls int NOT NULL DEFAULT 0, coaches int NOT NULL DEFAULT 0, cheerleaders int NOT NULL DEFAULT 0, apothecaryFlag char(1) default 'N', teamValue int NOT NULL DEFAULT 0, currentTeamValue int NOT NULL DEFAULT 0, PRIMARY KEY(id), FOREIGN KEY(teamTemplateId) REFERENCES TeamTemplate(id), FOREIGN KEY(coachId) REFERENCES coaches(id));
INSERT INTO Teams (id, coachId, teamTemplateId, teamName) values (1, 1, 1, 'The Rookie Testers');
--players
CREATE TABLE Players(id int NOT NULL AUTO_INCREMENT, TeamId int NOT NULL, PlayerTemplateId int NOT NULL, name VARCHAR(255), spp int NOT NULL DEFAULT 0, hiringFee int NOT NULL default 0, currentValue int NOT NULL default 0, PRIMARY KEY(id), FOREIGN KEY (TeamId) REFERENCES Teams(id), FOREIGN KEY(PlayerTemplateId) REFERENCES PlayerTemplate(id));
--player skill
CREATE TABLE PlayerSkills(id int NOT NULL AUTO_INCREMENT, playerId int NOT NULL, skillValue int, PRIMARY KEY(id), FOREIGN KEY (playerId) REFERENCES Players(id));