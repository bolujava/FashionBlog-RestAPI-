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

@Service
public class PostServiceImpl {
    private PostRepository postRepository;
    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    public ResponseEntity<Post> savePost(Post post){
       postRepository.save(post);
       return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> postList = postRepository.findAll();
       return new ResponseEntity<>(postList, HttpStatus.FOUND);

    }
    public ResponseEntity<Post> editPostById (Long id, @RequestBody Post newPost){
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()){
            Post post1 = post.get();
            post1.setTitle(newPost.getTitle());
            post1.setContent(newPost.getContent());
            postRepository.save(post1);
            return new ResponseEntity<Post>(post1, HttpStatus.OK);
        }else{
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Post> getPostById(Long id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()){
            Post post1 = post.get();
            return new ResponseEntity<>(post1, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<String> deletePostById(Long id) throws Throwable {
        postRepository.findById(id).orElseThrow(()-> new PostNotFoundException("POST NOT FOUND"));
        postRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    public ResponseEntity<List<Post>> getPostByTitle(String title) {
        List<Post> postList = postRepository.findPostIgnoringCase(title);
        if (postList.isEmpty()){
            return new ResponseEntity<>(postList, HttpStatus.NO_CONTENT);

        }else{
            return new ResponseEntity<>(postList, HttpStatus.FOUND);
        }
    }
}
