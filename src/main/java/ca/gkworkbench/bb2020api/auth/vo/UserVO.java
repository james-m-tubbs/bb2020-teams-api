package ca.gkworkbench.bb2020api.auth.vo;

import java.util.Arrays;

public class UserVO {
    private int coachId;
    private byte[] salt;
    private byte[] saltPwd;
    private boolean adminFlag;
    private String username;

    public UserVO(int coachId, byte[] salt, byte[] saltPwd, boolean adminFlag, String username) {
        this.coachId = coachId;
        this.salt = salt;
        this.saltPwd = saltPwd;
        this.adminFlag = adminFlag;
        this.username = username;
    }

    public int getCoachId() {
        return coachId;
    }

    public void setCoachId(int coachId) {
        this.coachId = coachId;
    }

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    public byte[] getSaltPwd() {
        return saltPwd;
    }

    public void setSaltPwd(byte[] saltPwd) {
        this.saltPwd = saltPwd;
    }

    public boolean isAdminFlag() {
        return adminFlag;
    }

    public void setAdminFlag(boolean adminFlag) {
        this.adminFlag = adminFlag;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "coachId=" + coachId +
                ", salt=" + Arrays.toString(salt) +
                ", saltPwd=" + Arrays.toString(saltPwd) +
                ", adminFlag=" + adminFlag +
                ", username='" + username + '\'' +
                '}';
    }
}
