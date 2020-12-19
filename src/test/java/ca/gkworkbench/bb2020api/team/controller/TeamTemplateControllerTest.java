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

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest(TeamController.class)
@Import(TeamController.class)
@AutoConfigureMockMvc
@ContextConfiguration(classes= bb2020TestConfig.class)
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class TeamTemplateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void get_team_template_endpoint_success() throws Exception {
        this.mockMvc.perform(get("/api/team/template/1"))
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
    public void get_team_template_endpoint_failure() throws Exception {
        this.mockMvc.perform(get("/api/team/999999"))
                .andExpect(status().is5xxServerError());
    }

    @Test
    public void get_all_team_templates_success() throws Exception {
        this.mockMvc.perform(get("/api/team/template"))
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
                .andDo(document("/api/team/details/1"));
    }
}
