package ca.gkworkbench.bb2020api.skill.vo;

// create table SkillTemplate(id int NOT NULL AUTO_INCREMENT, playerTemplateId int NOT NULL, skillId int NOT NULL, skillValue int, PRIMARY KEY (id), FOREIGN KEY(playerTemplateId) REFERENCES PlayerTemplate(id), FOREIGN KEY(skillId) REFERENCES Skills(id));

public class SkillTemplateVO {

    int id;

    String skill;
    String type; //GSAPM

    public SkillTemplateVO(int id, String skill, String type) {
        this.id = id;
        this.skill = skill;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "SkillTemplateVO{" +
                "id=" + id +
                ", skill='" + skill + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
