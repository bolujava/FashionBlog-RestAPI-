package com.boluwatifeproj.fashionblog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comment")
    public class Comment {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "text")
        private String text;
    @Column(name = "post_date")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date postDate;
        @ManyToOne
        @JoinColumn(name = "post_id")
        private Post post;

    }

