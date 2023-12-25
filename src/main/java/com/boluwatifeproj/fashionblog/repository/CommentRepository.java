package com.boluwatifeproj.fashionblog.repository;

import com.boluwatifeproj.fashionblog.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
