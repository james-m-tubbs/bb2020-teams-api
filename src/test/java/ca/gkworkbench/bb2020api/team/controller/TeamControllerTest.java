package ca.gkworkbench.bb2020api.team.controller;

import ca.gkworkbench.bb2020api.config.bb2020TestConfig;
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

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest(TeamController.class)
@Import(TeamController.class)
@AutoConfigureMockMvc
@ContextConfiguration(classes= bb2020TestConfig.class)
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class TeamControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void get_team_endpoint_success() throws Exception {
        this.mockMvc.perform(get("/team/1"))
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
                .andExpect(jsonPath("$.dedicatedFans").value(1))
                .andDo(document("team/1"));
    }

    @Test
    public void get_team_endpoint_failure() throws Exception {
        this.mockMvc.perform(get("/teams/999999"))
                .andExpect(status().is4xxClientError());
    }

    //{"id":1,"coachId":1,"teamTemplateId":1,"teamName":"The Rookie Testers","totalCAS":0,"totalTouchdowns":0,"treasury":1000000,"leaguePoints":0,"rerolls":0,"coaches":0,"cheerleaders":0,"hasApothecary":false,"teamValue":0,"currentTeamValue":0,"dedicatedFans":1,"players":[],"teamTemplateVO":{"id":1,"teamType":"Human","rerollCost":50000,"tier":1,"specialRules":"Old World Classic","apothecary":true}}
    @Test
    public void get_team_details_success() throws Exception {
        this.mockMvc.perform(get("/team/details/1"))
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
                .andExpect(jsonPath("$.dedicatedFans").value(1))
                .andExpect(jsonPath("$.teamTemplateVO.id").value(1))
                .andExpect(jsonPath("$.teamTemplateVO.teamType").value("Human"))
                .andExpect(jsonPath("$.teamTemplateVO.rerollCost").value(50000))
                .andExpect(jsonPath("$.teamTemplateVO.tier").value(1))
                .andExpect(jsonPath("$.teamTemplateVO.specialRules").value("Old World Classic"))
                .andExpect(jsonPath("$.teamTemplateVO.apothecary").value(true))
                .andDo(document("team/details/1"));
    }

    @Test
    public void get_team_details_failure() throws Exception {
        this.mockMvc.perform(get("/teams/details/999999"))
                .andExpect(status().is4xxClientError());
    }
}
