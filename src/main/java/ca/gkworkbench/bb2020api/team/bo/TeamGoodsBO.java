package ca.gkworkbench.bb2020api.team.bo;

import ca.gkworkbench.bb2020api.player.vo.PlayerVO;
import ca.gkworkbench.bb2020api.team.vo.TeamVO;

public interface TeamGoodsBO {

    //buy goods for team
    public PlayerVO buyRookiePlayerForTeam(int teamId, int playerTemplateId, String playerName) throws Exception;
    public TeamVO buyCheerleaderForTeam(int teamId) throws Exception;
    public TeamVO buyCoachForTeam(int teamId) throws Exception;
    public TeamVO buyApothForTeam(int teamId) throws Exception;
    public TeamVO buyRerollForTeam(int teamId) throws Exception;
    public TeamVO buyDedicatedFans(int teamId) throws Exception;

    //toss goods for team
    public PlayerVO unhireRookiePlayerForTeam(int playerId) throws Exception;
    public TeamVO fireCheerleaderForTeam(int teamId) throws Exception;
    public TeamVO fireCoachForTeam(int teamId) throws Exception;
    public TeamVO fireApothForTeam(int teamId) throws Exception;
    public TeamVO removeRerollForTeam(int teamId) throws Exception;


}
