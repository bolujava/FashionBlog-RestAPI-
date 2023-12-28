package com.boluwatifeproj.fashionblog.service;

import com.boluwatifeproj.fashionblog.model.Post;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PostService {
    ResponseEntity<Post> savePost(Post post);
    ResponseEntity<List<Post>> getAllPosts();
    ResponseEntity<Post> editPostById(Long id, Post newPost);
    ResponseEntity<Post> getPostById(Long id);
    ResponseEntity<String> deletePostById(Long id) throws Throwable;
    ResponseEntity <List<Post>> getPostByTitle(String title);
}
