package com.supinfo.matchleague;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.supinfo.matchleague.controller.MatchController;
import com.supinfo.matchleague.model.Match;
import com.supinfo.matchleague.service.MatchService;
import javassist.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class MatchControllerTest {
    private MockMvc mockMvc;

    @Mock
    private MatchService matchService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        MatchController matchController = new MatchController(matchService);
        mockMvc = MockMvcBuilders.standaloneSetup(matchController).build();
    }

    @Test
    @WithMockUser(roles = "JOURNALISTE")
    public void testCreateMatch() throws Exception {
        Match match = new Match();
        // Set match properties

        when(matchService.createMatch(any(Match.class))).thenReturn(match);

        mockMvc.perform(post("/api/matches")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(match)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testGetMatchById() throws Exception {
        Match match = new Match();
        // Set match properties

        when(matchService.getMatchById(any(Long.class))).thenReturn(match);

        mockMvc.perform(get("/api/matches/{id}", 1))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "JOURNALISTE")
    public void testUpdateMatch() throws Exception {
        Match match = new Match();
        // Set match properties

        when(matchService.updateMatch(any(Long.class), any(Match.class))).thenReturn(match);

        mockMvc.perform(put("/api/matches/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(match)))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "JOURNALISTE")
    public void testDeleteMatch() throws Exception {
        mockMvc.perform(delete("/api/matches/{id}", 1))
                .andExpect(status().isNoContent());
    }

    private String asJsonString(Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}