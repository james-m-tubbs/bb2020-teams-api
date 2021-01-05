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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest(PlayerController.class)
@Import(PlayerController.class)
@AutoConfigureMockMvc
@ContextConfiguration(classes= bb2020TestConfig.class)
public class PlayerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void get_team_endpoint_success() throws Exception {
        this.mockMvc.perform(get("/api/player/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.playerId").value(1))
                .andExpect(jsonPath("$.teamId").value(1))
                .andExpect(jsonPath("$.name").value("Tiberius Tosser"))
                .andExpect(jsonPath("$.spp").value(15))
                .andExpect(jsonPath("$.currentValue").value(80000))
                .andExpect(jsonPath("$.cp").value(0))
                .andExpect(jsonPath("$.pi").value(3))
                .andExpect(jsonPath("$.cas").value(1))
                .andExpect(jsonPath("$.td").value(4))
                .andExpect(jsonPath("$.mvp").value(2))
                .andExpect(jsonPath("$.injured").value(false))
                .andExpect(jsonPath("$.tempRetired").value(false))
                .andExpect(jsonPath("$.fired").value(false))
                .andExpect(jsonPath("$.boughtSkills").isEmpty())
                .andExpect(jsonPath("$.gamesPlayed").value(6))
                .andExpect(jsonPath("$.playerTemplateId").value(2))
                .andExpect(jsonPath("$.teamTemplateId").value(1))
                .andExpect(jsonPath("$.position").value("Human Thrower"))
                .andExpect(jsonPath("$.linemanFlag").value(false))
                .andExpect(jsonPath("$.qty").value(2))
                .andExpect(jsonPath("$.cost").value(80000))
                .andExpect(jsonPath("$.MA").value(6))
                .andExpect(jsonPath("$.ST").value(3))
                .andExpect(jsonPath("$.AG").value(3))
                .andExpect(jsonPath("$.PA").value(2))
                .andExpect(jsonPath("$.AV").value(9))
                .andExpect(jsonPath("$.baseSkills").isNotEmpty())
                .andExpect(jsonPath("$.baseSkills[0]").isNotEmpty())
                .andExpect(jsonPath("$.baseSkills[1]").isNotEmpty())
                .andExpect(jsonPath("$.primary").value("GP"))
                .andExpect(jsonPath("$.secondary").value("AS"))
                .andExpect(jsonPath("$.onePerTeam").value(false));
    }

    @Test
    public void get_team_endpoint_not_found() throws Exception {
        this.mockMvc.perform(get("/api/player/999999"))
                .andExpect(status().is4xxClientError())
                .andExpect(status().isNotFound());
    }
}
