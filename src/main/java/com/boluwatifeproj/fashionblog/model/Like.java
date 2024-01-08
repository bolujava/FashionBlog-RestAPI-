package com.boluwatifeproj.fashionblog.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_like")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @Column(name = "user_name")
    private String username;

    @Column(name = "like_count")
    private int likeCount;
    @PrePersist
    public void prePersist(){
        this.username = getCurrentUsername();
        this.likeCount = 1;
    }
    private String getCurrentUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null ?authentication.getName() : "Unknown User Detected";

    }
}
