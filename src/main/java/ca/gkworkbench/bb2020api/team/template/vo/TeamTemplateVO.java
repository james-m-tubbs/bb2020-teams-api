package ca.gkworkbench.bb2020api.team.template.vo;

public class TeamTemplateVO {
    private long teamTemplateId;

    private String teamType;
    private long rerollCost;
    private int tier;
    private String specialRules;
    private boolean apothecary = false;

    public TeamTemplateVO(long teamTemplateId, String teamType, long rerollCost, int tier, String specialRules, String apothStr) {
        this.teamTemplateId = teamTemplateId;
        this.teamType = teamType;
        this.rerollCost = rerollCost;
        this.tier = tier;
        this.specialRules = specialRules;
        if (apothStr != null && apothStr.equalsIgnoreCase("Y")) {
            this.apothecary = true;
        }
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

    public boolean hasApothecary() {
        return apothecary;
    }

    @Override
    public String toString() {
        return "TeamTemplateVO{" +
                "teamTemplateId=" + teamTemplateId +
                ", teamType='" + teamType + '\'' +
                ", rerollCost=" + rerollCost +
                ", tier=" + tier +
                ", specialRules='" + specialRules + '\'' +
                ", apothecary='" + apothecary + '\'' +
                '}';
    }
}
