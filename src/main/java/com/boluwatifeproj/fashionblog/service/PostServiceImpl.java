package com.boluwatifeproj.fashionblog.service;

import com.boluwatifeproj.fashionblog.exception.PostNotFoundException;
import com.boluwatifeproj.fashionblog.model.Post;
import com.boluwatifeproj.fashionblog.repository.PostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    private PostRepository postRepository;
    @Override
    public ResponseEntity<Post> savePost(Post post) {
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }
    @Override
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> postList = postRepository.findAll();
        return new ResponseEntity<>(postList, HttpStatus.FOUND);
    }
    @Override
    public ResponseEntity<Post> editPostById(Long id, Post newPost) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()){
            Post post1 = post.get();
            post1.setTitle(newPost.getTitle());
            post1.setContent(newPost.getContent());
            return new ResponseEntity<>(post1, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public ResponseEntity<Post> getPostById(Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()) {
            return new ResponseEntity<>(optionalPost.get(), HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public ResponseEntity <Void> deletePostById(Long id){
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()){
            postRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @Override
    public ResponseEntity<List<Post>> getPostByTitle(String title) {
        List<Post> posts = postRepository.findByTitle(title);
        if (!posts.isEmpty()){
            return new ResponseEntity<>(posts, HttpStatus.FOUND);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}