package ca.gkworkbench.bb2020api.team.vo;

import ca.gkworkbench.bb2020api.player.vo.PlayerVO;

import java.util.ArrayList;
import java.util.List;

public class TeamVO {
    //CREATE TABLE Teams(id int NOT NULL AUTO_INCREMENT,
    private int id;
    // BBUserId int NOT NULL,
    private int coachId;
    // teamTemplateId int NOT NULL,
    private int teamTemplateId;
    // teamName varchar(255) NOT NULL,
    private String teamName;
    // totalCas int NOT NULL DEFAULT 0,
    private int totalCAS;
    // totalTouchdowns int NOT NULL DEFAULT 0,
    private int totalTouchdowns;
    // treasury int NOT NULL DEFAULT 1000000,
    private int treasury;
    // leaguePoints int NOT NULL DEFAULT 0,
    private int leaguePoints;
    // rerolls int NOT NULL DEFAULT 0,
    private int rerolls;
    // coaches int NOT NULL DEFAULT 0,
    private int coaches;
    // cheerleaders int NOT NULL DEFAULT 0,
    private int cheerleaders;
    // apothecaryFlag char(1),
    private boolean hasApothecary = false;
    // teamValue int NOT NULL DEFAULT 0,
    private int teamValue;
    // currentTeamValue int NOT NULL DEFAULT 0,
    private int currentTeamValue;
    // player List
    private List<PlayerVO> players;
    // team template
    private TeamTemplateVO teamTemplateVO;

    public TeamVO(int id, int coachId, int teamTemplateId, String teamName, int totalCAS, int totalTouchdowns, int treasury, int leaguePoints, int rerolls, int coaches, int cheerleaders, boolean hasApothecary, int teamValue, int currentTeamValue, List<PlayerVO> players, TeamTemplateVO teamTemplateVO) {
        this.id = id;
        this.coachId = coachId;
        this.teamTemplateId = teamTemplateId;
        this.teamName = teamName;
        this.totalCAS = totalCAS;
        this.totalTouchdowns = totalTouchdowns;
        this.treasury = treasury;
        this.leaguePoints = leaguePoints;
        this.rerolls = rerolls;
        this.coaches = coaches;
        this.cheerleaders = cheerleaders;
        this.hasApothecary = hasApothecary;
        this.teamValue = teamValue;
        this.currentTeamValue = currentTeamValue;
        this.players = players;
        this.teamTemplateVO = teamTemplateVO;
    }

    public TeamVO(int coachId, int teamTemplateId, String teamName, int treasury) {
        this.coachId = coachId;
        this.teamTemplateId = teamTemplateId;
        this.teamName = teamName;
        this.treasury = treasury;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCoachId() {
        return coachId;
    }

    public void setCoachId(int coachId) {
        this.coachId = coachId;
    }

    public int getTeamTemplateId() {
        return teamTemplateId;
    }

    public void setTeamTemplateId(int teamTemplateId) {
        this.teamTemplateId = teamTemplateId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTotalCAS() {
        return totalCAS;
    }

    public void setTotalCAS(int totalCAS) {
        this.totalCAS = totalCAS;
    }

    public int getTotalTouchdowns() {
        return totalTouchdowns;
    }

    public void setTotalTouchdowns(int totalTouchdowns) {
        this.totalTouchdowns = totalTouchdowns;
    }

    public int getTreasury() {
        return treasury;
    }

    public void setTreasury(int treasury) {
        this.treasury = treasury;
    }

    public int getLeaguePoints() {
        return leaguePoints;
    }

    public void setLeaguePoints(int leaguePoints) {
        this.leaguePoints = leaguePoints;
    }

    public int getRerolls() {
        return rerolls;
    }

    public void setRerolls(int rerolls) {
        this.rerolls = rerolls;
    }

    public int getCoaches() {
        return coaches;
    }

    public void setCoaches(int coaches) {
        this.coaches = coaches;
    }

    public int getCheerleaders() {
        return cheerleaders;
    }

    public void setCheerleaders(int cheerleaders) {
        this.cheerleaders = cheerleaders;
    }

    public boolean isHasApothecary() {
        return hasApothecary;
    }

    public void setHasApothecary(boolean hasApothecary) {
        this.hasApothecary = hasApothecary;
    }

    public int getTeamValue() {
        return teamValue;
    }

    public void setTeamValue(int teamValue) {
        this.teamValue = teamValue;
    }

    public int getCurrentTeamValue() {
        return currentTeamValue;
    }

    public void setCurrentTeamValue(int currentTeamValue) {
        this.currentTeamValue = currentTeamValue;
    }

    public List<PlayerVO> getPlayers() {
        if (players == null) return new ArrayList<PlayerVO>();
        return players;
    }

    public void setPlayers(List<PlayerVO> players) {
        if (players == null) players = new ArrayList<PlayerVO>();
        this.players = players;
    }

    public TeamTemplateVO getTeamTemplateVO() {
        return teamTemplateVO;
    }

    public void setTeamTemplateVO(TeamTemplateVO teamTemplateVO) {
        this.teamTemplateVO = teamTemplateVO;
    }

    @Override
    public String toString() {
        return "TeamVO{" +
                "id=" + id +
                ", coachId=" + coachId +
                ", teamTemplateId=" + teamTemplateId +
                ", teamName='" + teamName + '\'' +
                ", totalCAS=" + totalCAS +
                ", totalTouchdowns=" + totalTouchdowns +
                ", treasury=" + treasury +
                ", leaguePoints=" + leaguePoints +
                ", rerolls=" + rerolls +
                ", coaches=" + coaches +
                ", cheerleaders=" + cheerleaders +
                ", hasApothecary=" + hasApothecary +
                ", teamValue=" + teamValue +
                ", currentTeamValue=" + currentTeamValue +
                ", players=" + players +
                ", teamTemplateVO=" + teamTemplateVO +
                '}';
    }
}
