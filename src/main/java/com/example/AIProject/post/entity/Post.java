package com.example.AIProject.post.entity;

import com.example.AIProject.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "posts")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SQLDelete(sql = "UPDATE posts SET is_deleted = true, deleted_at = NOW() WHERE id = ?")
@SQLRestriction("is_deleted = false")
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;  // FK 미사용, 애플리케이션 레벨에서 관리

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private int viewCount = 0;

    @Column(nullable = false)
    private boolean isDeleted = false;

    @Column
    private LocalDateTime deletedAt;

    public static Post create(Long userId, String title, String content) {
        Post post = new Post();
        post.userId = userId;
        post.title = title;
        post.content = content;
        return post;
    }

    public void increaseViewCount() {
        this.viewCount++;
    }
}
