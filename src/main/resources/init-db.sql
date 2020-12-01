create table TeamTemplate (id int, teamTemplateName varchar(255) NOT NULL, rerollCost int NOT NULL, tier int NOT NULL, specialRules varchar(255), apothecary char(1) NOT NULL, PRIMARY KEY (id));
create table PlayerTemplate (id int NOT NULL AUTO_INCREMENT, teamTemplateId int NOT NULL, position varchar(255) NOT NULL, linemanFlag char(1) NOT NULL, qty int NOT NULL, cost int NOT NULL, ma int NOT NULL, st int NOT NULL, ag int NOT NULL, pa int NOT NULL, av int NOT NULL, PRIMARY KEY (id), FOREIGN KEY(teamTemplateId) REFERENCES TeamTemplate(id));

-- humans
INSERT INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES (1, 'Human', 50000, 1, 'Old World Classic', 'Y');
INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (1, 'Lineman', 'Y', 16, 50000, 6, 3, 3, 4, 9);
INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (1, 'Thrower', 'N', 2, 80000, 6, 3, 3, 2, 9);
INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (1, 'Catcher', 'N', 4, 65000, 8, 2, 3, 5, 8);
INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (1, 'Blitzer', 'N', 4, 85000, 7, 3, 3, 4, 9);
INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (1, 'Halfling Hopeful', 'N', 3, 30000, 5, 2, 3, 4, 7);
INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (1, 'Ogre', 'N', 1, 140000, 5, 5, 4, 5, 10);

--orcs
INSERT INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES (2, 'Orcs', 60000, 1, 'Badlands Brawl', 'Y');
INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (2, 'Lineman', 'Y', 16, 50000, 5, 3, 3, 4, 10);
INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (2, 'Thrower', 'N', 2, 65000, 5, 3, 3, 3, 9);
INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (2, 'Blitzer', 'N', 4, 80000, 6, 3, 3, 4, 10);
INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (2, 'Big Un Blocker', 'N', 4, 90000, 5, 4, 4, 0, 10);
INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (2, 'Goblin', 'N', 4, 40000, 6, 2, 3, 4, 8);
INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (2, 'Untrained Troll', 'N', 1, 115000, 4, 5, 5, 5, 10);

-- chaos chosen
INSERT INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES (3, 'Chaos Chosen', 60000, 2, 'Favoured of... Undivided, Khorne, Nurgle, Slannesh, or Tzeench', 'Y');
INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (3, 'Beastmen', 'Y', 16, 60000, 6, 3, 3, 4, 9);
INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (3, 'Chosen Blockers', 'N', 4, 100000, 5, 4, 3, 5, 10);
INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (3, 'Chaos Troll', 'N', 1, 115000, 4, 5, 5, 5, 10);
INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (3, 'Chaos Ogre', 'N', 1, 140000, 5, 5, 4, 5, 10);
INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (3, 'Minotaur', 'N', 1, 150000, 5, 5, 4, 0, 9);

-- chaos renegades
INSERT INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES (4, 'Chaos Renegades', 70000, 1, 'Favoured of... Undivided, Khorne, Nurgle, Slannesh, or Tzeench', 'Y');
INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (4, 'Renegade Human', 'Y', 12, 50000, 6, 3, 3, 4, 9);
INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (4, 'Renegade Thrower', 'N', 1, 75000, 6, 3, 3, 3, 9);
INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (4, 'Renegade Goblin', 'N', 1, 40000, 6, 2, 3, 4, 8);
INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (4, 'Renegade Orc', 'N', 1, 50000, 5, 3, 3, 5, 10);
INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (4, 'Renegade Skaven', 'N', 1, 50000, 7, 3, 3, 4, 8);
INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (4, 'Renegade Dark Elf', 'N', 1, 75000, 6, 3, 2, 3, 9);
INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (4, 'Renegade Troll', 'N', 1, 115000, 4, 5, 5, 5, 10);
INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (4, 'Renegade Ogre', 'N', 1, 140000, 5, 5, 4, 5, 10);
INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (4, 'Renegade Minotaur', 'N', 1, 150000, 5, 5, 4, 0, 9);
INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (4, 'Renegade Rat Ogre', 'N', 1, 150000, 6, 5, 4, 0, 9);

-- Dark Elves
INSERT INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES (5, 'Dark Elves', 50000, 1, 'Elven Kingdom League', 'Y');
INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (5, 'Dark Elf', 'Y', 12, 70000, 6, 3, 2, 4, 9);
INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (5, 'Runner', 'N', 2, 80000, 7, 3, 2, 3, 8);
INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (5, 'Blitzer', 'N', 4, 100000, 7, 3, 2, 4, 9);
INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (5, 'Assassin', 'N', 2, 85000, 7, 3, 2, 5, 8);
INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (5, 'Witch Elf', 'N', 2, 110000, 7, 3, 2, 5, 8);

-- dwarf
INSERT INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES (6, 'Dwarf', 50000, 1, 'Old World Classic, Worlds Edge League', 'Y');
INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (6, 'Dwarf Blocker', 'Y', 12, 70000, 4, 3, 4, 5, 10);
INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (6, 'Runner', 'N', 2, 85000, 6, 3, 3, 4, 9);
INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (6, 'Blitzer', 'N', 2, 80000, 5, 3, 3, 4, 10);
INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (6, 'Troll Slayer', 'N', 2, 95000, 5, 3, 4, 0, 9);
INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (6, 'Deathroller', 'N', 1, 170000, 4, 7, 5, 0, 11);

-- black orc
INSERT INTO TeamTemplate (id, teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES (7, 'Black Orc', 60000, 2, 'Badlands Brawl, Bribery and Corruption', 'Y');
INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (7, 'Goblin Bruiser', 'Y', 12, 45000, 6, 2, 3, 4, 8);
INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (7, 'Black Orc', 'N', 4, 90000, 4, 4, 4, 5, 10);
INSERT INTO PlayerTemplate(teamTemplateId, position, linemanFlag, qty, cost, ma, st, ag, pa, av ) values (7, 'Trained Troll', 'N', 1, 115000, 4, 5, 5, 5, 10);
