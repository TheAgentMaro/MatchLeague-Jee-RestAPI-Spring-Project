package com.supinfo.matchleague.service;

import com.supinfo.matchleague.model.Comment;
import com.supinfo.matchleague.repository.CommentRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment createComment(Long matchId, Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment getCommentById(Long id) throws NotFoundException {
        return commentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Comment not found"));
    }

    public List<Comment> getAllCommentsByMatchId(Long matchId) {
        return commentRepository.findAllByMatchId(matchId);
    }

    public Comment updateComment(Long id, Comment updatedComment) throws NotFoundException {
        Comment existingComment = getCommentById(id);
        existingComment.setContent(updatedComment.getContent());
        return commentRepository.save(existingComment);
    }

    public void deleteComment(Long id) throws NotFoundException {
        Comment comment = getCommentById(id);
        commentRepository.delete(comment);
    }
}
