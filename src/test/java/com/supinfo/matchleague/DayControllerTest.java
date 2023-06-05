package com.supinfo.matchleague;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.supinfo.matchleague.controller.DayController;
import com.supinfo.matchleague.model.Day;
import com.supinfo.matchleague.service.DayService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class DayControllerTest {
    private MockMvc mockMvc;

    @Mock
    private DayService dayService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        DayController dayController = new DayController(dayService);
        mockMvc = MockMvcBuilders.standaloneSetup(dayController).build();
    }

    @Test
    public void testCreateDay() throws Exception {
        Day day = new Day();
        // Set day properties

        when(dayService.createDay(any(Day.class))).thenReturn(day);

        mockMvc.perform(post("/api/days")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(day)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testGetDayById() throws Exception {
        Day day = new Day();
        // Set day properties

        when(dayService.getDayById(any(Long.class))).thenReturn(day);

        mockMvc.perform(get("/api/days/{id}", 1))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteDay() throws Exception {
        mockMvc.perform(delete("/api/days/{id}", 1))
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
