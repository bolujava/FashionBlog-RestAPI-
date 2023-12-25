package com.boluwatifeproj.fashionblog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.aot.generate.GeneratedTypeReference;

import javax.annotation.processing.Generated;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;

    @Column(name = "post_date")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date postDate;
}
