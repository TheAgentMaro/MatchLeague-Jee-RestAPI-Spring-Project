package com.supinfo.matchleague;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.supinfo.matchleague.controller.CommentController;
import com.supinfo.matchleague.model.Comment;
import com.supinfo.matchleague.service.CommentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class CommentControllerTest {
    private MockMvc mockMvc;

    @Mock
    private CommentService commentService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        CommentController commentController = new CommentController(commentService);
        mockMvc = MockMvcBuilders.standaloneSetup(commentController).build();
    }

    @Test
    @WithMockUser(roles = "JOURNALISTE")
    public void testCreateComment() throws Exception {
        Comment comment = new Comment();
        // Set comment properties

        when(commentService.createComment(any(Long.class), any(Comment.class))).thenReturn(comment);

        mockMvc.perform(post("/api/comments/{matchId}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(comment)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testGetCommentsByMatchId() throws Exception {
        List<Comment> comments = new ArrayList<>();
        // Add comments to the list

        when(commentService.getAllCommentsByMatchId(any(Long.class))).thenReturn(comments);

        mockMvc.perform(get("/api/comments/{matchId}", 1))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "JOURNALISTE")
    public void testUpdateComment() throws Exception {
        Comment comment = new Comment();
        // Set comment properties

        when(commentService.updateComment(any(Long.class), any(Comment.class))).thenReturn(comment);

        mockMvc.perform(put("/api/comments/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(comment)))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "JOURNALISTE")
    public void testDeleteComment() throws Exception {
        mockMvc.perform(delete("/api/comments/{id}", 1))
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