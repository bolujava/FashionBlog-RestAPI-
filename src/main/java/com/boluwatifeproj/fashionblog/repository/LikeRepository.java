package com.boluwatifeproj.fashionblog.repository;

import com.boluwatifeproj.fashionblog.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository <Like, Long> {
    List<Like> findByPostId(Long postId);
}
