package com.boluwatifeproj.fashionblog.service;


import com.boluwatifeproj.fashionblog.model.Comment;
import org.springframework.http.ResponseEntity;

import java.util.List;
public interface CommentService {
    ResponseEntity<Comment> postCommentByTitle(Long id, Comment comment);
    ResponseEntity<Comment> editCommentByTitle(Long id, Comment newComment);
    ResponseEntity <List<Comment>> getAllComment(Comment comment);
}