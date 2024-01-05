package com.boluwatifeproj.fashionblog.controller;

import com.boluwatifeproj.fashionblog.model.Comment;
import com.boluwatifeproj.fashionblog.service.CommentService;
import com.boluwatifeproj.fashionblog.service.CommentServiceImpl;
import com.boluwatifeproj.fashionblog.service.PostService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/comments")
public class CommentController {
    private CommentService commentService;
    private PostService postService;
    @Autowired
    public CommentController(CommentService commentService, PostService postService) {
        this.commentService = commentService;
        this.postService = postService;
    }
    @PostMapping("/post-comment/{id}")
    ResponseEntity <Comment> postComment(@PathVariable("id") Long id, @RequestBody Comment comment){
        return commentService.postComment(id, comment);
    }
    @PutMapping("/edit-comment/{id}")
    ResponseEntity<Comment> editComment(@PathVariable("id") Long id, @RequestBody Comment newComment){
        return commentService.editComment(id, newComment);
    }
    @GetMapping("/get-all-comments")
    public ResponseEntity<List<Comment>> getAllComments() {
        return commentService.getAllComment();
    }
}