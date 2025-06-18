package com.pickgo.global.infra.metric.repository.redis;

import java.time.Duration;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RedisMetricRepository {

    private final StringRedisTemplate redisTemplate;
    private static final String TPS_KEY = "metric:tps:latest";
    private final static int TIMEOUT_MILLIS = 1000; // tps 저장 만료시간

    public void saveTps(long tps) {
        redisTemplate.opsForValue().set(TPS_KEY, String.valueOf(tps), Duration.ofMillis(TIMEOUT_MILLIS));
    }

    public Long getLatestTps() {
        String val = redisTemplate.opsForValue().get(TPS_KEY);
        if (val == null)
            return null;
        return Long.parseLong(val);
    }
}
