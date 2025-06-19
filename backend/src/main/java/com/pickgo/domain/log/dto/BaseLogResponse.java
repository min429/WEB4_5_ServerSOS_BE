package com.pickgo.domain.log.dto;

import java.time.LocalDateTime;

import com.pickgo.domain.log.entity.BaseLog;
import com.pickgo.domain.log.enums.ActionType;
import com.pickgo.domain.log.enums.ActorType;

public record BaseLogResponse(
    Long id,
    String actorId,
    ActorType actorType,
    ActionType action,
    String requestUri,
    String httpMethod,
    String description,
    LocalDateTime createdAt
) {
    public static BaseLogResponse from(BaseLog log) {
        return new BaseLogResponse(
            log.getId(),
            log.getActorId(),
            log.getActorType(),
            log.getAction(),
            log.getRequestUri(),
            log.getHttpMethod(),
            log.getDescription(),
            log.getCreatedAt()
        );
    }
}
