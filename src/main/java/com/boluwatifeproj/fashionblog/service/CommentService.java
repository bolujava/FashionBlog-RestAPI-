package com.boluwatifeproj.fashionblog.service;


import com.boluwatifeproj.fashionblog.model.Comment;
import org.springframework.http.ResponseEntity;

import java.util.List;
public interface CommentService {

    ResponseEntity<Comment> postComment(Long id, Comment comment);
    ResponseEntity<Comment> editComment(Long id, Comment newComment);
    ResponseEntity <List<Comment>> getAllComment();
}