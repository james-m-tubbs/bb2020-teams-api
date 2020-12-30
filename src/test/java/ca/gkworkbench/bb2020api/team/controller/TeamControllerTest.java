package ca.gkworkbench.bb2020api.team.controller;

import ca.gkworkbench.bb2020api.config.bb2020TestConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
        this.mockMvc.perform(get("/api/team/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.teamTemplateId").value(1))
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
        this.mockMvc.perform(get("/api/team/details/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.teamTemplateId").value(1))
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
                .andExpect(jsonPath("$.teamTemplateVO.id").value(1))
                .andExpect(jsonPath("$.teamTemplateVO.teamType").value("Human"))
                .andExpect(jsonPath("$.teamTemplateVO.rerollCost").value(50000))
                .andExpect(jsonPath("$.teamTemplateVO.tier").value(1))
                .andExpect(jsonPath("$.teamTemplateVO.specialRules").value("Old World Classic"))
                .andExpect(jsonPath("$.teamTemplateVO.apothecary").value(true));
    }

    @Test
    public void get_team_details_failure() throws Exception {
        this.mockMvc.perform(get("/api/team/details/999999"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void create_team_success() throws Exception {
        this.mockMvc.perform(post("/api/team/create/6?teamName=Create%20Team%20Success"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.teamTemplateId").value(6))
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
                .andExpect(jsonPath("$.teamTemplateVO.id").value(6))
                .andExpect(jsonPath("$.teamTemplateVO.teamType").value("Dwarf"))
                .andExpect(jsonPath("$.teamTemplateVO.rerollCost").value(50000))
                .andExpect(jsonPath("$.teamTemplateVO.tier").value(1))
                .andExpect(jsonPath("$.teamTemplateVO.specialRules").value("Old World Classic, Worlds Edge League"))
                .andExpect(jsonPath("$.teamTemplateVO.apothecary").value(true));
    }

    @Test
    public void create_team_with_custom_treasury() throws Exception {
        this.mockMvc.perform(post("/api/team/create/2?teamName=Create%20Team%20Custom%20Treasury&treasury=1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.teamTemplateId").value(2))
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
                .andExpect(jsonPath("$.teamTemplateVO.id").value(2))
                .andExpect(jsonPath("$.teamTemplateVO.teamType").value("Orc"))
                .andExpect(jsonPath("$.teamTemplateVO.rerollCost").value(60000))
                .andExpect(jsonPath("$.teamTemplateVO.tier").value(1))
                .andExpect(jsonPath("$.teamTemplateVO.specialRules").value("Badlands Brawl"))
                .andExpect(jsonPath("$.teamTemplateVO.apothecary").value(true));
    }

    @Test
    public void create_team_twice_and_expect_a_failure() throws Exception {
        this.mockMvc.perform(post("/api/team/create/1?teamName=Double%20Troubles"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.teamTemplateId").value(1))
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
                .andExpect(jsonPath("$.teamTemplateVO.id").value(1))
                .andExpect(jsonPath("$.teamTemplateVO.teamType").value("Human"))
                .andExpect(jsonPath("$.teamTemplateVO.rerollCost").value(50000))
                .andExpect(jsonPath("$.teamTemplateVO.tier").value(1))
                .andExpect(jsonPath("$.teamTemplateVO.specialRules").value("Old World Classic"))
                .andExpect(jsonPath("$.teamTemplateVO.apothecary").value(true));


        String error = this.mockMvc.perform(post("/api/team/create/1?teamName=Double%20Troubles"))
                .andExpect(status().is4xxClientError())
                .andReturn().getResolvedException().getMessage();

        Assert.assertTrue(error.equalsIgnoreCase("400 BAD_REQUEST \"Team Name Exists: Double Troubles\""));
    }
}
