package ca.gkworkbench.bb2020api.team.controller;

import ca.gkworkbench.bb2020api.config.bb2020TestConfig;
import com.jayway.jsonpath.JsonPath;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest(TeamController.class)
@Import(TeamController.class)
@AutoConfigureMockMvc
@ContextConfiguration(classes= bb2020TestConfig.class)
public class TeamControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void get_team_endpoint_success() throws Exception {
        this.mockMvc.perform(get("/api/team/1").header("bearer_token", "thisisaworkingtoken"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.teamTemplateId").value(9))
                .andExpect(jsonPath("$.teamName").value("The Rookie Testers"))
                .andExpect(jsonPath("$.totalCAS").value(0))
                .andExpect(jsonPath("$.totalTouchdowns").value(0))
                .andExpect(jsonPath("$.treasury").value(1000000))
                .andExpect(jsonPath("$.leaguePoints").value(0))
                .andExpect(jsonPath("$.rerolls").value(0))
                .andExpect(jsonPath("$.coaches").value(0))
                .andExpect(jsonPath("$.cheerleaders").value(0))
                .andExpect(jsonPath("$.hasApothecary").value(false))
                .andExpect(jsonPath("$.teamValue").value(0))
                .andExpect(jsonPath("$.currentTeamValue").value(0))
                .andExpect(jsonPath("$.dedicatedFans").value(1));
    }

    @Test
    public void get_team_endpoint_failure() throws Exception {
        this.mockMvc.perform(get("/api/team/999999"))
                .andExpect(status().is4xxClientError());
    }

    //{"id":1,"coachId":1,"teamTemplateId":1,"teamName":"The Rookie Testers","totalCAS":0,"totalTouchdowns":0,"treasury":1000000,"leaguePoints":0,"rerolls":0,"coaches":0,"cheerleaders":0,"hasApothecary":false,"teamValue":0,"currentTeamValue":0,"dedicatedFans":1,"players":[],"teamTemplateVO":{"id":1,"teamType":"Human","rerollCost":50000,"tier":1,"specialRules":"Old World Classic","apothecary":true}}
    @Test
    public void get_team_details_success() throws Exception {
        this.mockMvc.perform(get("/api/team/1/details"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.coachId").value(1))
                .andExpect(jsonPath("$.teamTemplateId").value(9))
                .andExpect(jsonPath("$.teamName").value("The Rookie Testers"))
                .andExpect(jsonPath("$.totalCAS").value(0))
                .andExpect(jsonPath("$.totalTouchdowns").value(0))
                .andExpect(jsonPath("$.treasury").value(1000000))
                .andExpect(jsonPath("$.leaguePoints").value(0))
                .andExpect(jsonPath("$.rerolls").value(0))
                .andExpect(jsonPath("$.coaches").value(0))
                .andExpect(jsonPath("$.cheerleaders").value(0))
                .andExpect(jsonPath("$.hasApothecary").value(false))
                .andExpect(jsonPath("$.teamValue").value(0))
                .andExpect(jsonPath("$.currentTeamValue").value(0))
                .andExpect(jsonPath("$.dedicatedFans").value(1))
                .andExpect(jsonPath("$.teamTemplateVO.id").value(9))
                .andExpect(jsonPath("$.teamTemplateVO.teamType").value("Human"))
                .andExpect(jsonPath("$.teamTemplateVO.rerollCost").value(50000))
                .andExpect(jsonPath("$.teamTemplateVO.tier").value(1))
                .andExpect(jsonPath("$.teamTemplateVO.specialRules").value("Old World Classic"))
                .andExpect(jsonPath("$.teamTemplateVO.apothecary").value(true))
                .andExpect(jsonPath("$.players").isNotEmpty());
    }

    @Test
    public void get_team_details_failure() throws Exception {
        this.mockMvc.perform(get("/api/team/999999/details"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void create_team_success() throws Exception {
        this.mockMvc.perform(post("/api/team/create/5?teamName=Create%20Team%20Success").header("bearer_token", "thisisaworkingtoken"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.teamTemplateId").value(5))
                .andExpect(jsonPath("$.teamName").value("Create Team Success"))
                .andExpect(jsonPath("$.totalCAS").value(0))
                .andExpect(jsonPath("$.totalTouchdowns").value(0))
                .andExpect(jsonPath("$.treasury").value(1000000))
                .andExpect(jsonPath("$.leaguePoints").value(0))
                .andExpect(jsonPath("$.rerolls").value(0))
                .andExpect(jsonPath("$.coaches").value(0))
                .andExpect(jsonPath("$.cheerleaders").value(0))
                .andExpect(jsonPath("$.hasApothecary").value(false))
                .andExpect(jsonPath("$.teamValue").value(0))
                .andExpect(jsonPath("$.currentTeamValue").value(0))
                .andExpect(jsonPath("$.dedicatedFans").value(1))
                .andExpect(jsonPath("$.teamTemplateVO.id").value(5))
                .andExpect(jsonPath("$.teamTemplateVO.teamType").value("Dwarf"))
                .andExpect(jsonPath("$.teamTemplateVO.rerollCost").value(50000))
                .andExpect(jsonPath("$.teamTemplateVO.tier").value(1))
                .andExpect(jsonPath("$.teamTemplateVO.specialRules").value("Old World Classic, Worlds Edge League"))
                .andExpect(jsonPath("$.teamTemplateVO.apothecary").value(true));
    }

    @Test
    public void create_team_no_auth() throws Exception {
        this.mockMvc.perform(post("/api/team/create/5?teamName=Create%20Team%20Auth%20Missing"))
                .andExpect(status().is4xxClientError())
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void create_team_bad_auth() throws Exception {
        this.mockMvc.perform(post("/api/team/create/5?teamName=Create%20Team%20Auth%20Bad").header("bearer_token", "broken_token"))
                .andExpect(status().is4xxClientError())
                .andExpect(status().isUnauthorized());
    }


    @Test
    public void create_team_with_custom_treasury() throws Exception {
        this.mockMvc.perform(post("/api/team/create/16?teamName=Create%20Team%20Custom%20Treasury&treasury=1").header("bearer_token", "thisisaworkingtoken"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.teamTemplateId").value(16))
                .andExpect(jsonPath("$.teamName").value("Create Team Custom Treasury"))
                .andExpect(jsonPath("$.totalCAS").value(0))
                .andExpect(jsonPath("$.totalTouchdowns").value(0))
                .andExpect(jsonPath("$.treasury").value(1))
                .andExpect(jsonPath("$.leaguePoints").value(0))
                .andExpect(jsonPath("$.rerolls").value(0))
                .andExpect(jsonPath("$.coaches").value(0))
                .andExpect(jsonPath("$.cheerleaders").value(0))
                .andExpect(jsonPath("$.hasApothecary").value(false))
                .andExpect(jsonPath("$.teamValue").value(0))
                .andExpect(jsonPath("$.currentTeamValue").value(0))
                .andExpect(jsonPath("$.dedicatedFans").value(1))
                .andExpect(jsonPath("$.teamTemplateVO.id").value(16))
                .andExpect(jsonPath("$.teamTemplateVO.teamType").value("Orc"))
                .andExpect(jsonPath("$.teamTemplateVO.rerollCost").value(60000))
                .andExpect(jsonPath("$.teamTemplateVO.tier").value(1))
                .andExpect(jsonPath("$.teamTemplateVO.specialRules").value("Badlands Brawl"))
                .andExpect(jsonPath("$.teamTemplateVO.apothecary").value(true));
    }

    @Test
    public void create_team_no_auth_custom_treasury() throws Exception {
        this.mockMvc.perform(post("/api/team/create/5?teamName=Create%20Team%20Auth%20Missing&treasury=1"))
                .andExpect(status().is4xxClientError())
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void create_team_bad_auth_custom_treasury() throws Exception {
        this.mockMvc.perform(post("/api/team/create/5?teamName=Create%20Team%20Auth%20Bad&treasury=1").header("bearer_token", "broken_token"))
                .andExpect(status().is4xxClientError())
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void create_team_twice_and_expect_a_failure() throws Exception {
        this.mockMvc.perform(post("/api/team/create/9?teamName=Double%20Troubles").header("bearer_token", "thisisaworkingtoken"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.teamTemplateId").value(9))
                .andExpect(jsonPath("$.teamName").value("Double Troubles"))
                .andExpect(jsonPath("$.totalCAS").value(0))
                .andExpect(jsonPath("$.totalTouchdowns").value(0))
                .andExpect(jsonPath("$.treasury").value(1000000))
                .andExpect(jsonPath("$.leaguePoints").value(0))
                .andExpect(jsonPath("$.rerolls").value(0))
                .andExpect(jsonPath("$.coaches").value(0))
                .andExpect(jsonPath("$.cheerleaders").value(0))
                .andExpect(jsonPath("$.hasApothecary").value(false))
                .andExpect(jsonPath("$.teamValue").value(0))
                .andExpect(jsonPath("$.currentTeamValue").value(0))
                .andExpect(jsonPath("$.dedicatedFans").value(1))
                .andExpect(jsonPath("$.teamTemplateVO.id").value(9))
                .andExpect(jsonPath("$.teamTemplateVO.teamType").value("Human"))
                .andExpect(jsonPath("$.teamTemplateVO.rerollCost").value(50000))
                .andExpect(jsonPath("$.teamTemplateVO.tier").value(1))
                .andExpect(jsonPath("$.teamTemplateVO.specialRules").value("Old World Classic"))
                .andExpect(jsonPath("$.teamTemplateVO.apothecary").value(true));


        String error = this.mockMvc.perform(post("/api/team/create/9?teamName=Double%20Troubles").header("bearer_token", "thisisaworkingtoken"))
                .andExpect(status().is4xxClientError())
                .andReturn().getResolvedException().getMessage();

        Assert.assertTrue(error.equalsIgnoreCase("400 BAD_REQUEST \"Team Name Exists: Double Troubles\""));
    }

    @Test
    public void create_team_delete_team_query_and_fail() throws Exception {
        MvcResult result = this.mockMvc.perform(post("/api/team/create/6?teamName=Delete%20Me").header("bearer_token", "thisisaworkingtoken"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.teamTemplateId").value(6))
                .andExpect(jsonPath("$.teamName").value("Delete Me"))
                .andReturn();

        Integer id = JsonPath.read(result.getResponse().getContentAsString(), "$.id");

        this.mockMvc.perform(post("/api/team/"+id+"/delete").header("bearer_token", "thisisaworkingtoken"))
                .andExpect(status().isOk());

        this.mockMvc.perform(get("/api/team/" + id))
                .andExpect(status().is4xxClientError())
                .andExpect(status().isNotFound());
    }

    @Test
    public void create_team_delete_twice_get_401() throws Exception {
        MvcResult result = this.mockMvc.perform(post("/api/team/create/6?teamName=Delete%20Me%20Twice").header("bearer_token", "thisisaworkingtoken"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.teamTemplateId").value(6))
                .andExpect(jsonPath("$.teamName").value("Delete Me Twice"))
                .andReturn();

        Integer id = JsonPath.read(result.getResponse().getContentAsString(), "$.id");

        this.mockMvc.perform(post("/api/team/"+id+"/delete").header("bearer_token", "thisisaworkingtoken"))
                .andExpect(status().isOk());

        //delete is idempotent
        this.mockMvc.perform(post("/api/team/"+id+"/delete").header("bearer_token", "thisisaworkingtoken"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void delete_team_no_auth() throws Exception {
        this.mockMvc.perform(get("/api/team/2"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.teamTemplateId").value(16))
                .andExpect(jsonPath("$.coachId").value(2));

        this.mockMvc.perform(post("/api/team/2/delete"))
                .andExpect(status().isUnauthorized())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void get_all_teams_for_coach_id() throws Exception {
        this.mockMvc.perform(get("/api/team/coach/2"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(2))
                .andExpect(jsonPath("$[0].teamTemplateId").value(16))
                .andExpect(jsonPath("$[0].coachId").value(2))
                .andExpect(jsonPath("$[0].teamName").value("The Orcy Orcsters"))

                .andExpect(jsonPath("$[1].id").value(5))
                .andExpect(jsonPath("$[1].teamTemplateId").value(9))
                .andExpect(jsonPath("$[1].coachId").value(2))
                .andExpect(jsonPath("$[1].teamName").value("Da Hoomies"));
    }

    /***********
     * Get Players
     */

    @Test
    public void get_all_players_for_team_id() throws Exception {
        this.mockMvc.perform(get("/api/team/1/players"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].playerId").value(1))
                .andExpect(jsonPath("$[0].teamId").value(1))
                .andExpect(jsonPath("$[0].name").value("Tiberius Tosser"))
                .andExpect(jsonPath("$[0].spp").value(15))
                .andExpect(jsonPath("$[0].currentValue").value(80000))
                .andExpect(jsonPath("$[0].cp").value(0))
                .andExpect(jsonPath("$[0].pi").value(3))
                .andExpect(jsonPath("$[0].cas").value(1))
                .andExpect(jsonPath("$[0].td").value(4))
                .andExpect(jsonPath("$[0].mvp").value(2))
                .andExpect(jsonPath("$[0].injured").value(false))
                .andExpect(jsonPath("$[0].tempRetired").value(false))
                .andExpect(jsonPath("$[0].fired").value(false))
                .andExpect(jsonPath("$[0].boughtSkills").isEmpty())
                .andExpect(jsonPath("$[0].gamesPlayed").value(6))
                .andExpect(jsonPath("$[0].playerTemplateId").value(46))
                .andExpect(jsonPath("$[0].teamTemplateId").value(9))
                .andExpect(jsonPath("$[0].position").value("Thrower"))
                .andExpect(jsonPath("$[0].linemanFlag").value(false))
                .andExpect(jsonPath("$[0].bigGuyFlag").value(false))
                .andExpect(jsonPath("$[0].qty").value(2))
                .andExpect(jsonPath("$[0].cost").value(80000))
                .andExpect(jsonPath("$[0].MA").value(6))
                .andExpect(jsonPath("$[0].ST").value(3))
                .andExpect(jsonPath("$[0].AG").value(3))
                .andExpect(jsonPath("$[0].PA").value(2))
                .andExpect(jsonPath("$[0].AV").value(9))
                .andExpect(jsonPath("$[0].baseSkills").isNotEmpty())
                .andExpect(jsonPath("$[0].baseSkills[0]").isNotEmpty())
                .andExpect(jsonPath("$[0].baseSkills[1]").isNotEmpty())
                .andExpect(jsonPath("$[0].primary").value("GP"))
                .andExpect(jsonPath("$[0].secondary").value("AS"))
                //others players
                .andExpect(jsonPath("$[1]").isNotEmpty())
                .andExpect(jsonPath("$[2]").isNotEmpty())
                .andExpect(jsonPath("$[3]").isNotEmpty())
                .andExpect(jsonPath("$[4]").isNotEmpty())
                .andExpect(jsonPath("$[5]").isNotEmpty());
    }

    @Test
    public void get_all_players_team_with_no_players() throws Exception {
        this.mockMvc.perform(get("/api/team/2/players"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));
    }

    /**
     * Hiring Players
     */

    @Test
    public void hire_and_fire_player_to_chaos_team_and_validate_success() throws Exception {
        MvcResult result = this.mockMvc.perform(post("/api/team/7/players/hire/5?name=Mr%20Chaos%20Chosen").header("bearer_token", "thisisaworkingtoken"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.teamTemplateId").value(2))
                .andExpect(jsonPath("$.teamName").value("Chaos Chosen Test 4"))
                .andExpect(jsonPath("$.treasury").value(900000))
                .andExpect(jsonPath("$.cheerleaders").value(0))
                .andExpect(jsonPath("$.hasApothecary").value(false))
                .andExpect(jsonPath("$.teamValue").value(100000))
                .andExpect(jsonPath("$.teamTemplateVO.id").value(2))
                .andExpect(jsonPath("$.teamTemplateVO.teamType").value("Chaos Chosen"))
                .andExpect(jsonPath("$.teamTemplateVO.rerollCost").value(60000))
                .andExpect(jsonPath("$.teamTemplateVO.tier").value(2))
                .andExpect(jsonPath("$.teamTemplateVO.specialRules").value("Favoured of... Chaos Undivided, Khorne, Nurgle, Slaanesh, or Tzeentch"))
                .andExpect(jsonPath("$.players[0].name").value("Fired Chosen Blocker"))
                .andExpect(jsonPath("$.players[0].currentValue").value("100000"))
                .andExpect(jsonPath("$.players[0].cost").value("100000"))
                .andExpect(jsonPath("$.players[0].fired").value(true))
                .andExpect(jsonPath("$.players[1].name").value("Mr Chaos Chosen"))
                .andExpect(jsonPath("$.players[1].currentValue").value("100000"))
                .andExpect(jsonPath("$.players[1].cost").value("100000"))
                .andExpect(jsonPath("$.players[1].fired").value(false))
                .andExpect(jsonPath("$.activePlayers[0].name").value("Mr Chaos Chosen"))
                .andExpect(jsonPath("$.activePlayers[1].name").doesNotExist())
                .andReturn();

        Integer id = JsonPath.read(result.getResponse().getContentAsString(), "$.players[1].playerId");

        this.mockMvc.perform(post("/api/team/7/players/fire/"+id).header("bearer_token", "thisisaworkingtoken"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.teamTemplateId").value(2))
                .andExpect(jsonPath("$.teamName").value("Chaos Chosen Test 4"))
                .andExpect(jsonPath("$.treasury").value(1000000))
                .andExpect(jsonPath("$.cheerleaders").value(0))
                .andExpect(jsonPath("$.hasApothecary").value(false))
                .andExpect(jsonPath("$.teamValue").value(0))
                .andExpect(jsonPath("$.teamTemplateVO.id").value(2))
                .andExpect(jsonPath("$.teamTemplateVO.teamType").value("Chaos Chosen"))
                .andExpect(jsonPath("$.teamTemplateVO.rerollCost").value(60000))
                .andExpect(jsonPath("$.teamTemplateVO.tier").value(2))
                .andExpect(jsonPath("$.teamTemplateVO.specialRules").value("Favoured of... Chaos Undivided, Khorne, Nurgle, Slaanesh, or Tzeentch"))
                .andExpect(jsonPath("$.players[1].name").value("Mr Chaos Chosen"))
                .andExpect(jsonPath("$.players[1].currentValue").value("100000"))
                .andExpect(jsonPath("$.players[1].cost").value("100000"))
                .andExpect(jsonPath("$.players[1].fired").value(true))
                .andExpect(jsonPath("$.activePlayers").isEmpty())
                .andExpect(jsonPath("$.activePlayers[0].name").doesNotExist());
    }

    @Test
    public void hire_player_with_missing_auth() throws Exception {
        this.mockMvc.perform(post("/api/team/7/players/hire/5?name=Mr%20Chaos%20Chosen"))
                .andExpect(status().is4xxClientError())
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void hire_player_with_bad_auth() throws Exception {
        this.mockMvc.perform(post("/api/team/7/players/hire/5?name=Mr%20Chaos%20Chosen").header("bearer_token", "broken_token"))
                .andExpect(status().is4xxClientError())
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void hire_player_for_wrong_team_id() throws Exception {
        this.mockMvc.perform(post("/api/team/1/players/hire/14?name=Mr%20Chaos%20Chosen").header("bearer_token", "thisisaworkingtoken"))
                .andExpect(status().is4xxClientError())
                .andExpect(status().isNotFound());
    }

    @Test
    public void hire_player_for_missing_team_id() throws Exception {
        this.mockMvc.perform(post("/api/team/99999999/players/hire/14?name=Mr%20Chaos%20Chosen").header("bearer_token", "thisisaworkingtoken"))
                .andExpect(status().is4xxClientError())
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void fire_player_from_missing_team_id() throws Exception {
        this.mockMvc.perform(post("/api/team/999999/players/fire/1").header("bearer_token", "thisisaworkingtoken"))
                .andExpect(status().is4xxClientError())
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void fire_player_from_wrong_team() throws Exception {
        this.mockMvc.perform(post("/api/team/7/players/fire/1").header("bearer_token", "thisisaworkingtoken"))
                .andExpect(status().is4xxClientError())
                .andExpect(status().isNotFound());
    }

    @Test
    public void fire_missing_player_from_team() throws Exception {
        this.mockMvc.perform(post("/api/team/7/players/fire/999999").header("bearer_token", "thisisaworkingtoken"))
                .andExpect(status().is4xxClientError())
                .andExpect(status().isNotFound());
    }
}

