package com.pickgo.domain.log.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.pickgo.domain.log.enums.ActorType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class AccessHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String actorId;

    @Enumerated(EnumType.STRING)
    private ActorType actorType;

    private String requestUri;

    private String httpMethod;

    @CreatedDate
    @Column(name = "created_at", columnDefinition = "datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일시'")
    private LocalDateTime createdAt;

    public AccessHistory(String actorId, ActorType actorType, String requestUri, String httpMethod) {
        this.actorId = actorId;
        this.actorType = actorType;
        this.requestUri = requestUri;
        this.httpMethod = httpMethod;
        this.createdAt = LocalDateTime.now();
    }
}
