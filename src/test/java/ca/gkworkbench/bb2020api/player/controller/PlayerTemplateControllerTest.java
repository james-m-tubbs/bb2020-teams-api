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
        this.mockMvc.perform(get("/api/player/template/4"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(4))
                .andExpect(jsonPath("$.teamTemplateId").value(1))
                .andExpect(jsonPath("$.position").value("Human Blitzer"))
                .andExpect(jsonPath("$.linemanFlag").value(false))
                .andExpect(jsonPath("$.qty").value(4))
                .andExpect(jsonPath("$.cost").value(85000))
                .andExpect(jsonPath("$.MA").value(7))
                .andExpect(jsonPath("$.ST").value(3))
                .andExpect(jsonPath("$.AG").value(3))
                .andExpect(jsonPath("$.PA").value(4))
                .andExpect(jsonPath("$.AV").value(9))
                .andExpect(jsonPath("$.skills[0].skill").value("Block"))
                .andExpect(jsonPath("$.skills[0].type").value("G"))
                .andExpect(jsonPath("$.primary").value("GS"))
                .andExpect(jsonPath("$.secondary").value("AP"));
    }

    @Test
    public void get_team_endpoint_failure() throws Exception {
        this.mockMvc.perform(get("/api/player/template/999999"))
                .andExpect(status().is4xxClientError());
    }
}
