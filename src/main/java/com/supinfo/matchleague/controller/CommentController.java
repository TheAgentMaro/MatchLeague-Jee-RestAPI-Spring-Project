package com.supinfo.matchleague.controller;

import com.supinfo.matchleague.model.Comment;
import com.supinfo.matchleague.service.CommentService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/{matchId}")
    @PreAuthorize("hasRole('JOURNALISTE')")
    public ResponseEntity<Comment> createComment(@PathVariable Long matchId, @RequestBody Comment comment) {
        Comment createdComment = commentService.createComment(matchId, comment);
        return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
    }

    @GetMapping("/{matchId}")
    public ResponseEntity<List<Comment>> getCommentsByMatchId(@PathVariable Long matchId) {
        List<Comment> comments = commentService.getAllCommentsByMatchId(matchId);
        return ResponseEntity.ok(comments);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('JOURNALISTE')")
    public ResponseEntity<Comment> updateComment(@PathVariable Long id, @RequestBody Comment comment) throws NotFoundException {
        Comment updatedComment = commentService.updateComment(id, comment);
        return ResponseEntity.ok(updatedComment);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('JOURNALISTE')")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) throws NotFoundException {
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }
}