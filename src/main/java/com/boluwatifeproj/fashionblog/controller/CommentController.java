package com.boluwatifeproj.fashionblog.controller;

import com.boluwatifeproj.fashionblog.model.Comment;
import com.boluwatifeproj.fashionblog.service.CommentServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/comment")
public class CommentController {

    private CommentServiceImpl commentService;
    @Autowired
    public CommentController(CommentServiceImpl commentService) {
        this.commentService = commentService;
    }
    @PostMapping("/post-comment/{title}")
    public ResponseEntity <Comment> createCommentByTitle(@PathVariable String title, @RequestBody Comment comment){
        return commentService.createCommentByTitle(title, comment);
    }
    public ResponseEntity <List<Comment>> getAllComments(Comment comment){
        return commentService.getAllComments(comment);

    }

}
