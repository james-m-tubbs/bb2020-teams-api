package ca.gkworkbench.bb2020api.dao.team;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TeamTemplate")
public class TeamTemplateVO {

    @Id
    private long teamTemplateId;

    private String teamType;
    private long rerollCost;
    private int tier;
    private String specialRules;

    public TeamTemplateVO(long teamTemplateId, String teamType, long rerollCost, int tier, String specialRules) {
        this.teamTemplateId = teamTemplateId;
        this.teamType = teamType;
        this.rerollCost = rerollCost;
        this.tier = tier;
        this.specialRules = specialRules;
    }

    public long getTeamTemplateId() {
        return teamTemplateId;
    }

    public void setTeamTemplateId(long teamTemplateId) {
        this.teamTemplateId = teamTemplateId;
    }

    public String getTeamType() {
        return teamType;
    }

    public void setTeamType(String teamType) {
        this.teamType = teamType;
    }

    public long getRerollCost() {
        return rerollCost;
    }

    public void setRerollCost(long rerollCost) {
        this.rerollCost = rerollCost;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    public String getSpecialRules() {
        return specialRules;
    }

    public void setSpecialRules(String specialRules) {
        this.specialRules = specialRules;
    }
}
