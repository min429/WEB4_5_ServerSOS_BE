package com.pickgo.domain.log.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.pickgo.domain.log.enums.ActionType;
import com.pickgo.domain.log.enums.ActorType;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class BaseLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // actor -> 누구가 했는지
    @Column(nullable = false)
    private String actorId; // memberId or IP

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ActorType actorType;

    // 어떤 행동을 했는지
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ActionType action;

    @Column(nullable = false)
    private String requestUri; // api

    @Column(nullable = false)
    private String httpMethod; // POST, GET

    @Column(length = 1000)
    private String description; // 설명

    @CreatedDate
    @Column(name = "created_at", columnDefinition = "datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일시'")
    private LocalDateTime createdAt;

    public BaseLog(String actorId, ActorType actorType, ActionType action,
        String requestUri, String httpMethod, String description) {
        this.actorId = actorId;
        this.actorType = actorType;
        this.action = action;
        this.requestUri = requestUri;
        this.httpMethod = httpMethod;
        this.description = description;
        this.createdAt = LocalDateTime.now();
    }
}
