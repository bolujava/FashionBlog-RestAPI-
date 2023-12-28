package com.boluwatifeproj.fashionblog.service;

import com.boluwatifeproj.fashionblog.model.Comment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{
    @Override
    public ResponseEntity<Comment> postCommentByTitle(Long id, Comment comment) {
        return null;
    }

    @Override
    public ResponseEntity<Comment> editCommentByTitle(Long id, Comment newComment) {
        return null;
    }

    @Override
    public ResponseEntity<List<Comment>> getAllComment(Comment comment) {
        return null;
    }
}
