package ca.gkworkbench.bb2020api.player.vo;

import ca.gkworkbench.bb2020api.skill.vo.SkillVO;

import java.util.List;

public class PlayerTemplateVO {

    int playerTemplateId;
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
    List<SkillVO> baseSkills;
    String primary;
    String secondary;
    boolean onePerTeam;

    public PlayerTemplateVO(int playerTemplateId, int teamTemplateId, String position, boolean linemanFlag, int qty, int cost, int MA, int ST, int AG, int PA, int AV, List<SkillVO> baseSkills, String primary, String secondary, boolean onePerTeam) {
        this.playerTemplateId = playerTemplateId;
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
        this.baseSkills = baseSkills;
        this.primary = primary;
        this.secondary = secondary;
        this.onePerTeam = onePerTeam;
    }

    public void setBaseSkills(List<SkillVO> baseSkills) {
        this.baseSkills = baseSkills;
    }

    public int getPlayerTemplateId() {
        return playerTemplateId;
    }

    public int getTeamTemplateId() {
        return teamTemplateId;
    }

    public String getPosition() {
        return position;
    }

    public boolean isLinemanFlag() {
        return linemanFlag;
    }

    public int getQty() {
        return qty;
    }

    public int getCost() {
        return cost;
    }

    public int getMA() {
        return MA;
    }

    public int getST() {
        return ST;
    }

    public int getAG() {
        return AG;
    }

    public int getPA() {
        return PA;
    }

    public int getAV() {
        return AV;
    }

    public List<SkillVO> getBaseSkills() {
        return baseSkills;
    }

    public String getPrimary() {
        return primary;
    }

    public String getSecondary() {
        return secondary;
    }

    public boolean isOnePerTeam() {
        return onePerTeam;
    }

    @Override
    public String toString() {
        return "PlayerTemplateVO{" +
                "playerTemplateId=" + playerTemplateId +
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
