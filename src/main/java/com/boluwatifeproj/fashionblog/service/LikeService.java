package com.boluwatifeproj.fashionblog.service;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LikeService {
        ResponseEntity<String> likePost(Long postId);
        ResponseEntity <List<String>> getUsersWhoLikedPost(Long postId);
        ResponseEntity <List<String>> findExistingLike(Long postId);
    }

