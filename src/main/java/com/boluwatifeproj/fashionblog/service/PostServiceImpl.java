package com.boluwatifeproj.fashionblog.service;

import com.boluwatifeproj.fashionblog.exception.PostNotFoundException;
import com.boluwatifeproj.fashionblog.model.Post;
import com.boluwatifeproj.fashionblog.repository.PostRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;
    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

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
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()){
            Post post1 = post.get();
            return new ResponseEntity<>(post1, HttpStatus.FOUND);

        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<String> deletePostById(Long id) throws Throwable {
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()){
            Post post1 = post.get();
            postRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            throw new PostNotFoundException("Post not found");
        }
    }

    @Override
    public ResponseEntity<List<Post>> getPostByTitle(String title) {
        List <Post> postList = postRepository.findByTitle(title);
        if (postList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.FOUND);
        }
    }
}
