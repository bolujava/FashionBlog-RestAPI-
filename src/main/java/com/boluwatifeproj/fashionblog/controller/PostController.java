package com.boluwatifeproj.fashionblog.controller;

import com.boluwatifeproj.fashionblog.exception.PostNotFoundException;
import com.boluwatifeproj.fashionblog.model.Post;
import com.boluwatifeproj.fashionblog.service.PostService;
import com.boluwatifeproj.fashionblog.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
    private final PostService postService;

//    private PostServiceImpl postServiceImpl;
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }
    @PostMapping("/save-post")
    public ResponseEntity<Post> savePost(@RequestBody Post post){
        return postService.savePost(post);
    }
    @GetMapping("/all-post")
    public ResponseEntity<List<Post>> getAllPosts(){
        return postService.getAllPosts();
    }
    @PutMapping("/edit-post/{id}")
    public ResponseEntity<Post> editPostById(@PathVariable("id") Long id, @RequestBody Post newPost){
        try {
            return postService.editPostById(id, newPost);
        } catch (PostNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/get-post/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable(name = "id") Long id){
        return postService.getPostById(id);
    }
    @GetMapping("/get-post-title")
    public ResponseEntity<List<Post>> getPostByTitle(@RequestParam(name = "title") String title){
        return postService.getPostByTitle(title);
    }
    @DeleteMapping("/delete-post/{id}")
    public ResponseEntity<Void> deletePostById(@PathVariable("id") Long id) throws Throwable {
        return postService.deletePostById(id);
    }
}