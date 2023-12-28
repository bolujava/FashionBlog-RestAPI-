package com.boluwatifeproj.fashionblog.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.aot.generate.GeneratedTypeReference;

import javax.annotation.processing.Generated;
import java.util.Date;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "content")
    private String content;

    @Column(name = "post_date")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date postDate;
}
