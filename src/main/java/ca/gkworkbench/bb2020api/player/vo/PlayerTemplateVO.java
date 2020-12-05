package ca.gkworkbench.bb2020api.player.vo;

import ca.gkworkbench.bb2020api.skill.vo.SkillVO;

import java.util.List;

public class PlayerTemplateVO {

    int id;
    int teamTemplateId;
    String position;
    boolean linemanFlag;
    int qty;
    int cost;
    int MA;
    int ST;
    int AG;
    int PA;
    int AV;
    List<SkillVO> skills;
    String primary;
    String secondary;

    public PlayerTemplateVO(int id, int teamTemplateId, String position, boolean linemanFlag, int qty, int cost, int MA, int ST, int AG, int PA, int AV, List<SkillVO> skills, String primary, String secondary) {
        this.id = id;
        this.teamTemplateId = teamTemplateId;
        this.position = position;
        this.linemanFlag = linemanFlag;
        this.qty = qty;
        this.cost = cost;
        this.MA = MA;
        this.ST = ST;
        this.AG = AG;
        this.PA = PA;
        this.AV = AV;
        this.skills = skills;
        this.primary = primary;
        this.secondary = secondary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeamTemplateId() {
        return teamTemplateId;
    }

    public void setTeamTemplateId(int teamTemplateId) {
        this.teamTemplateId = teamTemplateId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isLinemanFlag() {
        return linemanFlag;
    }

    public void setLinemanFlag(boolean linemanFlag) {
        this.linemanFlag = linemanFlag;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getMaxCount() {
        return qty;
    }

    public void setMaxCount(int maxCount) {
        this.qty = maxCount;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getMA() {
        return MA;
    }

    public void setMA(int MA) {
        this.MA = MA;
    }

    public int getST() {
        return ST;
    }

    public void setST(int ST) {
        this.ST = ST;
    }

    public int getAG() {
        return AG;
    }

    public void setAG(int AG) {
        this.AG = AG;
    }

    public int getPA() {
        return PA;
    }

    public void setPA(int PA) {
        this.PA = PA;
    }

    public int getAV() {
        return AV;
    }

    public void setAV(int AV) {
        this.AV = AV;
    }

    public List<SkillVO> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillVO> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "PlayerTemplateVO{" +
                "id=" + id +
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
                ", skills=" + skills +
                ", primary=" + primary +
                ", secondary=" + secondary +
                '}';
    }
}