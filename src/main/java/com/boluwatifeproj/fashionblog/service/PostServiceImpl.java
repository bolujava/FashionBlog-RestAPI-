package com.boluwatifeproj.fashionblog.service;

import com.boluwatifeproj.fashionblog.exception.PostNotFoundException;
import com.boluwatifeproj.fashionblog.model.Like;
import com.boluwatifeproj.fashionblog.model.Post;
import com.boluwatifeproj.fashionblog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{
    private final PostRepository postRepository;
    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    @Override
    public ResponseEntity<Post> savePost(Post post) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()
        && authentication.getAuthorities().stream().anyMatch(role->role.getAuthority().equals("ROLE_ADMIN"))){
            Post createdPost = postRepository.save(post);
            return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
    @Override
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> postList = postRepository.findAll();
        return new ResponseEntity<>(postList, HttpStatus.OK);
    }
    @Override
    public ResponseEntity<Post> editPostById(Long id, Post newPost) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()){
            Post existingPost = optionalPost.get();
            existingPost.setTitle(newPost.getTitle());
            existingPost.setContent(newPost.getContent());
            Post savedPost = postRepository.save(existingPost);
            return new ResponseEntity<>(savedPost, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public ResponseEntity<Post> getPostById(Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        return optionalPost.map(post -> new ResponseEntity<>(post, HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @Override
    public ResponseEntity <Void> deletePostById(Long id){
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()){
            postRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @Override
    public ResponseEntity<List<Post>> getPostByTitle(String title) {
        List<Post> posts = postRepository.findByTitle(title);
        if (!posts.isEmpty()){
            return new ResponseEntity<>(posts, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}