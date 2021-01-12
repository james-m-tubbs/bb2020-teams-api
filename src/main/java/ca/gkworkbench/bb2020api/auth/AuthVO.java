package ca.gkworkbench.bb2020api.auth;

import java.sql.Date;

public class AuthVO {

    private int coachId;
    private String bearer_token;

    public AuthVO(int coachId, String bearer_token) {
        this.coachId = coachId;
        this.bearer_token = bearer_token;
    }

    public int getCoachId() {
        return coachId;
    }

    public void setCoachId(int coachId) {
        this.coachId = coachId;
    }

    public String getBearer_token() {
        return bearer_token;
    }

    public void setBearer_token(String bearer_token) {
        this.bearer_token = bearer_token;
    }

    @Override
    public String toString() {
        return "AuthVO{" +
                "coachId=" + coachId +
                ", bearer_token='" + bearer_token + '\'' +
                '}';
    }
}
