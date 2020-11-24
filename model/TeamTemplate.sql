create table TeamTemplate (
  teamTemplateID int NOT NULL AUTO_INCREMENT, -- PK ID
  teamTemplateName varchar(255) NOT NULL, -- dwarves
  rerollCost int NOT NULL, -- 50k
  tier int NOT NULL, -- i don't know what this is yet?
  specialRules varchar(255),
  PRIMARY KEY (teamTemplateID)
);