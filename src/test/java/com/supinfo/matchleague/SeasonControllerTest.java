package com.supinfo.matchleague;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.supinfo.matchleague.controller.SeasonController;
import com.supinfo.matchleague.model.Season;
import com.supinfo.matchleague.service.SeasonService;
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

public class SeasonControllerTest {
    private MockMvc mockMvc;

    @Mock
    private SeasonService seasonService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        SeasonController seasonController = new SeasonController(seasonService);
        mockMvc = MockMvcBuilders.standaloneSetup(seasonController).build();
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testCreateSeason() throws Exception {
        Season season = new Season();
        // Set season properties

        when(seasonService.createSeason(any(Season.class))).thenReturn(season);

        mockMvc.perform(post("/api/seasons")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(season)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testGetSeasonById() throws Exception {
        Season season = new Season();
        // Set season properties

        when(seasonService.getSeasonById(any(Long.class))).thenReturn(season);

        mockMvc.perform(get("/api/seasons/{id}", 1))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testUpdateSeason() throws Exception {
        Season season = new Season();
        // Set season properties

        when(seasonService.updateSeason(any(Long.class), any(Season.class))).thenReturn(season);

        mockMvc.perform(put("/api/seasons/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(season)))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testDeleteSeason() throws Exception {
        mockMvc.perform(delete("/api/seasons/{id}", 1))
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