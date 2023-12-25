package com.boluwatifeproj.fashionblog.repository;

import com.boluwatifeproj.fashionblog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {


    List<Post> findPostIgnoringCase(String title);

    Optional<Post> findByTitle(String title);
}
