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
public class CommentController {

    private CommentService commentService;
    private PostService postService;

    public CommentController(CommentService commentService, PostService postService) {
        this.commentService = commentService;
        this.postService = postService;
    }
}
