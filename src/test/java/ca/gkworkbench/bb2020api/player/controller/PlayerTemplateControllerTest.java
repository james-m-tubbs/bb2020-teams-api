package ca.gkworkbench.bb2020api.player.controller;

import ca.gkworkbench.bb2020api.config.bb2020TestConfig;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(PlayerTemplateController.class)
@Import(PlayerTemplateController.class)
@AutoConfigureMockMvc
@ContextConfiguration(classes= bb2020TestConfig.class)
public class PlayerTemplateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void get_team_endpoint_success() throws Exception {
        this.mockMvc.perform(get("/api/player/template/48"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.playerTemplateId").value(48))
                .andExpect(jsonPath("$.teamTemplateId").value(9))
                .andExpect(jsonPath("$.position").value("Blitzer"))
                .andExpect(jsonPath("$.linemanFlag").value(false))
                .andExpect(jsonPath("$.bigGuyFlag").value(false))
                .andExpect(jsonPath("$.qty").value(4))
                .andExpect(jsonPath("$.cost").value(85000))
                .andExpect(jsonPath("$.MA").value(7))
                .andExpect(jsonPath("$.ST").value(3))
                .andExpect(jsonPath("$.AG").value(3))
                .andExpect(jsonPath("$.PA").value(4))
                .andExpect(jsonPath("$.AV").value(9))
                .andExpect(jsonPath("$.baseSkills[0].skill").value("Block"))
                .andExpect(jsonPath("$.baseSkills[0].type").value("G"))
                .andExpect(jsonPath("$.primary").value("GS"))
                .andExpect(jsonPath("$.secondary").value("AP"));
    }

    @Test
    public void get_team_endpoint_failure() throws Exception {
        this.mockMvc.perform(get("/api/player/template/999999"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void get_templates_by_team_success() throws Exception {
        this.mockMvc.perform(get("/api/player/template/team/9"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[3].playerTemplateId").value(48))
                .andExpect(jsonPath("$[3].teamTemplateId").value(9))
                .andExpect(jsonPath("$[3].position").value("Blitzer"))
                .andExpect(jsonPath("$[3].linemanFlag").value(false))
                .andExpect(jsonPath("$[3].bigGuyFlag").value(false))
                .andExpect(jsonPath("$[3].qty").value(4))
                .andExpect(jsonPath("$[3].cost").value(85000))
                .andExpect(jsonPath("$[3].MA").value(7))
                .andExpect(jsonPath("$[3].ST").value(3))
                .andExpect(jsonPath("$[3].AG").value(3))
                .andExpect(jsonPath("$[3].PA").value(4))
                .andExpect(jsonPath("$[3].AV").value(9))
                .andExpect(jsonPath("$[3].baseSkills[0].skill").value("Block"))
                .andExpect(jsonPath("$[3].baseSkills[0].type").value("G"))
                .andExpect(jsonPath("$[3].primary").value("GS"))
                .andExpect(jsonPath("$[3].secondary").value("AP"));
    }

    @Test
    public void get_templates_by_team_failure() throws Exception {
        this.mockMvc.perform(get("/api/player/template/team/999999"))
                .andExpect(status().is4xxClientError());
    }
}
