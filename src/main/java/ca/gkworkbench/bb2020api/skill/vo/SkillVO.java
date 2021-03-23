package ca.gkworkbench.bb2020api.skill.vo;

//create table Skills(id int NOT NULL AUTO_INCREMENT, skill VARCHAR(255), type CHAR(1));

public class SkillVO {
    int id;
    String skill;
    String type;
    boolean secondary;

    public SkillVO(int id, String skill, String type, boolean secondary) {
        this.id = id;
        this.skill = skill;
        this.type = type;
        this.secondary = secondary;
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

    public void setSecondary(boolean secondary) { this.secondary = secondary; }

    public boolean isSecondary() { return this.secondary; }

    @Override
    public String toString() {
        return "SkillVO{" +
                "id=" + id +
                ", skill='" + skill + '\'' +
                ", type='" + type + '\'' +
                ", secondary=" + secondary +
                '}';
    }
}
