create table TeamTemplate (teamTemplateID int NOT NULL AUTO_INCREMENT, teamTemplateName varchar(255) NOT NULL, rerollCost int NOT NULL, tier int NOT NULL, specialRules varchar(255), apothecary char(1) NOT NULL, PRIMARY KEY (teamTemplateID));

INSERT INTO TeamTemplate (teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES ('Dwarf', 50000, 1, 'Old World Classic, Worlds Edge League', 'Y');
INSERT INTO TeamTemplate (teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES ('Black Orc', 60000, 2, 'Badlands Brawl, Bribery and Corruption', 'Y');
INSERT INTO TeamTemplate (teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES ('Chaos Chosen', 60000, 2, 'Favoured of... Undivided, Khorne, Nurgle, Slannesh, or Tzeench', 'Y');
INSERT INTO TeamTemplate (teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES ('Chaos Renegades', 70000, 1, 'Favoured of... Undivided, Khorne, Nurgle, Slannesh, or Tzeench', 'Y');
INSERT INTO TeamTemplate (teamTemplateName, rerollCost, tier, specialRules, apothecary) VALUES ('Dark Elves', 50000, 1, 'Elven Kingdom League', 'Y');