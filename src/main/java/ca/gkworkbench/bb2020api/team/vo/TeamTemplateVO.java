package ca.gkworkbench.bb2020api.team.vo;

import ca.gkworkbench.bb2020api.player.vo.PlayerTemplateVO;

import java.util.List;

public class TeamTemplateVO {
    private long id;

    private String teamType;
    private int rerollCost;
    private int tier;
    private String specialRules;
    private boolean apothecary;
    private int bigGuyMax;
    private List<PlayerTemplateVO> playerTemplates;

    public TeamTemplateVO(long teamTemplateId, String teamType, int rerollCost, int tier, String specialRules, boolean apothecary, int bigGuyMax, List<PlayerTemplateVO> ptVOs) {
        this.id = teamTemplateId;
        this.teamType = teamType;
        this.rerollCost = rerollCost;
        this.tier = tier;
        this.specialRules = specialRules;
        this.apothecary = apothecary;
        this.playerTemplates = ptVOs;
        this.bigGuyMax = bigGuyMax;
    }

    public long getTeamTemplateId() {
        return id;
    }

    public void setTeamTemplateId(long teamTemplateId) {
        this.id = teamTemplateId;
    }

    public String getTeamType() {
        return teamType;
    }

    public void setTeamType(String teamType) {
        this.teamType = teamType;
    }

    public int getRerollCost() {
        return rerollCost;
    }

    public void setRerollCost(int rerollCost) {
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

    public void setId(long id) {
        this.id = id;
    }

    public void setApothecary(boolean apothecary) {
        this.apothecary = apothecary;
    }

    public int getBigGuyMax() { return bigGuyMax; }

    public void setBigGuyMax(int bigGuyMax) { this.bigGuyMax = bigGuyMax; }

    public void setPtVOs(List<PlayerTemplateVO> ptVOs) {
        this.playerTemplates = ptVOs;
    }

    public List<PlayerTemplateVO> getPtVOs() {
        return playerTemplates;
    }

    @Override
    public String toString() {
        return "TeamTemplateVO{" +
                "id=" + id +
                ", teamType='" + teamType + '\'' +
                ", rerollCost=" + rerollCost +
                ", tier=" + tier +
                ", specialRules='" + specialRules + '\'' +
                ", apothecary=" + apothecary +
                ", playerTemplates=" + playerTemplates +
                '}';
    }
}
