package ca.gkworkbench.bb2020api.player.vo;

import ca.gkworkbench.bb2020api.skill.vo.SkillVO;

import java.util.List;

public class PlayerVO {
    //CREATE TABLE Players(id int NOT NULL AUTO_INCREMENT,
    private int id;
    // name VARCHAR(255),
    private String name;
    //position
    private String position;
    // spp int NOT NULL DEFAULT 0,
    private int spp;
    // hiringFee int NOT NULL default 0,
    private int hiringFee;
    // currentValue int NOT NULL default 0,
    private int currentValue;
    // MA
    private int MA;
    // ST
    private int ST;
    // AG
    private int AG;
    // PA
    private int PA;
    // AV
    private int AV;
    // Skills
    private List<SkillVO> skills;

    public PlayerVO(int id, String name, String position, int spp, int hiringFee, int currentValue, int MA, int ST, int AG, int PA, int AV, List<SkillVO> skills) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.spp = spp;
        this.hiringFee = hiringFee;
        this.currentValue = currentValue;
        this.MA = MA;
        this.ST = ST;
        this.AG = AG;
        this.PA = PA;
        this.AV = AV;
        this.skills = skills;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSpp() {
        return spp;
    }

    public void setSpp(int spp) {
        this.spp = spp;
    }

    public int getHiringFee() {
        return hiringFee;
    }

    public void setHiringFee(int hiringFee) {
        this.hiringFee = hiringFee;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
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
}
