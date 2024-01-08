package com.boluwatifeproj.fashionblog.service;

import com.boluwatifeproj.fashionblog.model.Comment;
import com.boluwatifeproj.fashionblog.model.Post;
import com.boluwatifeproj.fashionblog.repository.CommentRepository;
import com.boluwatifeproj.fashionblog.repository.PostRepository;
import com.boluwatifeproj.fashionblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

//    @Override
//    public ResponseEntity<Comment> postComment(Long id, Comment comment) {
//        Optional<Post> postOptional = postRepository.findById(id);
//        if (postOptional.isPresent()) {
//            Post post = postOptional.get();
//            comment.setPost(post);
//            String currentUsername = getCurrentUsername();
//            if (currentUsername != null) {
//                Comment savedComment = commentRepository.save(comment);
//
//            }
//
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return null;
//    }
//
//    private String getCurrentUsername() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null && authentication.isAuthenticated()) {
//            return authentication.getName();
//        } else {
//            return null;
//        }
//
//    }

    @Override
    public ResponseEntity<Comment> postComment(Long id, Comment comment) {
        Optional<Post> postOptional = postRepository.findById(id);
        if (postOptional.isPresent()) {
            Post post = postOptional.get();
            comment.setPost(post);
                Comment savedComment = commentRepository.save(comment);
                return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
    }
    @Override
    public ResponseEntity<Comment> editComment(Long id, Comment newComment) {
        Optional<Comment> commentOptional = commentRepository.findById(id);
        if (commentOptional.isPresent()){
            Comment existingComment = commentOptional.get();
            existingComment.setText(newComment.getText());
            Comment editedComment = commentRepository.save(existingComment);
            return new ResponseEntity<>(editedComment, HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public ResponseEntity<List<Comment>> getAllComment() {
       List<Comment> commentList = commentRepository.findAll();
       if (commentList.isEmpty()){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }else{
           return new ResponseEntity<>(commentList, HttpStatus.FOUND);
       }
    }
}