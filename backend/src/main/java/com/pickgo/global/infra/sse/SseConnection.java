package com.pickgo.global.infra.sse;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * SSE Connection 정보
 */
@Getter
@SuperBuilder
public abstract class SseConnection {
    private final String connectionId;
    private final String serverId;
    @Setter
    private SseEmitter emitter;
}
