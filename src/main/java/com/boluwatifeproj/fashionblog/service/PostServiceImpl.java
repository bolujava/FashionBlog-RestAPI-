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
    public ResponseEntity<Post> editPostById(Long id, Post newPost) throws PostNotFoundException {
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
        return null;
    }

    @Override
    public ResponseEntity<String> deletePostById(Long id) throws Throwable {
        return null;
    }

    @Override
    public ResponseEntity<List<Post>> getPostByTitle(String title) {
        return null;
    }
}
