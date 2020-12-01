package ca.gkworkbench.bb2020api.skill.vo;

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
