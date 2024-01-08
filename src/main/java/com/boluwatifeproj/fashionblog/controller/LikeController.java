package com.boluwatifeproj.fashionblog.controller;

import com.boluwatifeproj.fashionblog.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/like")
public class LikeController {

    private final LikeService likeService;

    @Autowired
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping("/like/{postId}")
    public ResponseEntity<String> likePost(@PathVariable Long postId) {
        return likeService.likePost(postId);
    }

    @GetMapping("/users/{postId}")
    public ResponseEntity<List<String>> getUsersWhoLikedPost(@PathVariable Long postId) {
        return likeService.getUsersWhoLikedPost(postId);
    }

    @GetMapping("/existing/{postId}")
    public ResponseEntity<List<String>> findExistingLike(@PathVariable Long postId) {
        return likeService.findExistingLike(postId);
    }
}
