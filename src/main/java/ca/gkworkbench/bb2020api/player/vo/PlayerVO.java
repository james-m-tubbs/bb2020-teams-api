package ca.gkworkbench.bb2020api.player.vo;

import ca.gkworkbench.bb2020api.skill.vo.SkillVO;

import java.util.List;

public class PlayerVO extends PlayerTemplateVO {
    //id int NOT NULL AUTO_INCREMENT,
    private int playerId;
    // TeamId int NOT NULL,
    private int teamId;
    // name VARCHAR(255),
    private String name;
    // spp int NOT NULL DEFAULT 0,
    private int spp;
    // currentValue int NOT NULL default 0,
    private int currentValue;
    // cp int NOT NULL default 0,
    private int cp;
    // pi int NOT NULL default 0,
    private int pi;
    // cas int NOT NULL default 0,
    private int cas;
    // td int NOT NULL default 0.
    private int td;
    // mvp cas intOT NULL default 0,
    private int mvp;
    //injuredFlag char(1) NOT NULL DEFAULT 'N',
    private boolean injured;
    // tempRetiredFlag char(1) NOT NULL DEFAULT 'N',
    private boolean tempRetired;
    // firedFlag char(1) NOT NULL DEFAULT 'N'
    private boolean fired;

    //extra purchased skills
    private List<SkillVO> boughtSkills;

    public PlayerVO(int playerTemplateId, int teamTemplateId, String position, boolean linemanFlag, int qty, int cost, int MA, int ST, int AG, int PA, int AV, List<SkillVO> baseSkills, String primary, String secondary, boolean onePerTeam, int playerId, int teamId, String name, int spp, int currentValue, int cp, int pi, int cas, int td, int mvp, boolean injured, boolean tempRetired, boolean fired, List<SkillVO> boughtSkills) {
        super(playerTemplateId, teamTemplateId, position, linemanFlag, qty, cost, MA, ST, AG, PA, AV, baseSkills, primary, secondary, onePerTeam);
        this.playerId = playerId;
        this.teamId = teamId;
        this.name = name;
        this.spp = spp;
        this.currentValue = currentValue;
        this.cp = cp;
        this.pi = pi;
        this.cas = cas;
        this.td = td;
        this.mvp = mvp;
        this.injured = injured;
        this.tempRetired = tempRetired;
        this.fired = fired;
        this.boughtSkills = boughtSkills;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpp() {
        return spp;
    }

    public void setSpp(int spp) {
        this.spp = spp;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public int getPi() {
        return pi;
    }

    public void setPi(int pi) {
        this.pi = pi;
    }

    public int getCas() {
        return cas;
    }

    public void setCas(int cas) {
        this.cas = cas;
    }

    public int getTd() {
        return td;
    }

    public void setTd(int td) {
        this.td = td;
    }

    public int getMvp() {
        return mvp;
    }

    public void setMvp(int mvp) {
        this.mvp = mvp;
    }

    public boolean isInjured() {
        return injured;
    }

    public void setInjured(boolean injured) {
        this.injured = injured;
    }

    public boolean isTempRetired() {
        return tempRetired;
    }

    public void setTempRetired(boolean tempRetired) {
        this.tempRetired = tempRetired;
    }

    public boolean isFired() {
        return fired;
    }

    public void setFired(boolean fired) {
        this.fired = fired;
    }

    public List<SkillVO> getBoughtSkills() {
        return boughtSkills;
    }

    public void setBoughtSkills(List<SkillVO> boughtSkills) {
        this.boughtSkills = boughtSkills;
    }

    @Override
    public String toString() {
        return "PlayerVO{" +
                "playerId=" + playerId +
                ", teamId=" + teamId +
                ", name='" + name + '\'' +
                ", spp=" + spp +
                ", currentValue=" + currentValue +
                ", cp=" + cp +
                ", pi=" + pi +
                ", cas=" + cas +
                ", td=" + td +
                ", mvp=" + mvp +
                ", injured=" + injured +
                ", tempRetired=" + tempRetired +
                ", fired=" + fired +
                ", boughtSkills=" + boughtSkills +
                ", playerTemplateId=" + playerTemplateId +
                ", teamTemplateId=" + teamTemplateId +
                ", position='" + position + '\'' +
                ", linemanFlag=" + linemanFlag +
                ", qty=" + qty +
                ", cost=" + cost +
                ", MA=" + MA +
                ", ST=" + ST +
                ", AG=" + AG +
                ", PA=" + PA +
                ", AV=" + AV +
                ", baseSkills=" + baseSkills +
                ", primary='" + primary + '\'' +
                ", secondary='" + secondary + '\'' +
                ", onePerTeam=" + onePerTeam +
                '}';
    }
}