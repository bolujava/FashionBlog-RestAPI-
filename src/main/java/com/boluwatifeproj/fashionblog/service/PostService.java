package com.boluwatifeproj.fashionblog.service;

import com.boluwatifeproj.fashionblog.exception.PostNotFoundException;
import com.boluwatifeproj.fashionblog.model.Comment;
import com.boluwatifeproj.fashionblog.model.Like;
import com.boluwatifeproj.fashionblog.model.Post;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PostService {
    ResponseEntity<Post> savePost(Post post);
    ResponseEntity<List<Post>> getAllPosts();
    ResponseEntity <Post> editPostById(Long id, Post newPost) throws PostNotFoundException;
    ResponseEntity<Post> getPostById(Long id);
    ResponseEntity<Void> deletePostById(Long id) throws Throwable;
    ResponseEntity <List<Post>> getPostByTitle(String title);
}
