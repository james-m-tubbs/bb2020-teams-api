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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest(TeamTemplateController.class)
@Import(TeamTemplateController.class)
@AutoConfigureMockMvc
@ContextConfiguration(classes= bb2020TestConfig.class)
public class TeamTemplateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void get_team_template_endpoint_success() throws Exception {
        this.mockMvc.perform(get("/api/team/template/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.teamType").value("Human"))
                .andExpect(jsonPath("$.rerollCost").value(50000))
                .andExpect(jsonPath("$.tier").value(1))
                .andExpect(jsonPath("$.specialRules").value("Old World Classic"))
                .andExpect(jsonPath("$.apothecary").value(true))
                //human lineman
                .andExpect(jsonPath("$.playerTemplates[0].playerTemplateId").value(1))
                .andExpect(jsonPath("$.playerTemplates[0].teamTemplateId").value(1))
                .andExpect(jsonPath("$.playerTemplates[0].position").value("Human Lineman"))
                .andExpect(jsonPath("$.playerTemplates[0].linemanFlag").value(true))
                .andExpect(jsonPath("$.playerTemplates[0].qty").value(16))
                .andExpect(jsonPath("$.playerTemplates[0].cost").value(50000))
                .andExpect(jsonPath("$.playerTemplates[0].MA").value(6))
                .andExpect(jsonPath("$.playerTemplates[0].ST").value(3))
                .andExpect(jsonPath("$.playerTemplates[0].AG").value(3))
                .andExpect(jsonPath("$.playerTemplates[0].PA").value(4))
                .andExpect(jsonPath("$.playerTemplates[0].AV").value(9))
                .andExpect(jsonPath("$.playerTemplates[0].primary").value("G"))
                .andExpect(jsonPath("$.playerTemplates[0].secondary").value("AS"))
                //human thrower
                .andExpect(jsonPath("$.playerTemplates[1].playerTemplateId").value(2))
                .andExpect(jsonPath("$.playerTemplates[1].teamTemplateId").value(1))
                .andExpect(jsonPath("$.playerTemplates[1].position").value("Human Thrower"))
                .andExpect(jsonPath("$.playerTemplates[1].linemanFlag").value(false))
                .andExpect(jsonPath("$.playerTemplates[1].qty").value(2))
                .andExpect(jsonPath("$.playerTemplates[1].cost").value(80000))
                .andExpect(jsonPath("$.playerTemplates[1].MA").value(6))
                .andExpect(jsonPath("$.playerTemplates[1].ST").value(3))
                .andExpect(jsonPath("$.playerTemplates[1].AG").value(3))
                .andExpect(jsonPath("$.playerTemplates[1].PA").value(2))
                .andExpect(jsonPath("$.playerTemplates[1].AV").value(9))
                .andExpect(jsonPath("$.playerTemplates[1].primary").value("GP"))
                .andExpect(jsonPath("$.playerTemplates[1].secondary").value("AS"))
                .andExpect(jsonPath("$.playerTemplates[1].baseSkills[0].skill").value("Sure Hands"))
                .andExpect(jsonPath("$.playerTemplates[1].baseSkills[1].skill").value("Pass"));
    }

    @Test
    public void get_team_template_endpoint_failure() throws Exception {
        this.mockMvc.perform(get("/api/team/999999"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void get_all_team_templates_success() throws Exception {
        this.mockMvc.perform(get("/api/team/template"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
                //TODO expand this once data entry is complete
    }
}
