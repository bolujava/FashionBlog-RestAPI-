package com.boluwatifeproj.fashionblog.service;

import com.boluwatifeproj.fashionblog.model.Comment;
import com.boluwatifeproj.fashionblog.model.Post;
import com.boluwatifeproj.fashionblog.repository.CommentRepository;
import com.boluwatifeproj.fashionblog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl {
    private final CommentRepository commentRepository;

    private final PostRepository postRepository;
    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository= postRepository;
    }
    public ResponseEntity<Comment> createCommentByTitle(String title, Comment comment) {
//        Optional<Post> post = postRepository.findById(id);
//        if (post.isPresent()){
//            Post post1 = post.get();
        Optional<Post> post = postRepository.findByTitle(title);
        if (post.isPresent()){
            Post post1 = post.get();
            comment.setPost(post1);
            Comment createdComment = commentRepository.save(comment);
            return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<Comment>> getAllComments(Comment comment) {
        List<Comment> commentList = commentRepository.findAll();
        return new ResponseEntity<>(commentList, HttpStatus.FOUND);
    }
}