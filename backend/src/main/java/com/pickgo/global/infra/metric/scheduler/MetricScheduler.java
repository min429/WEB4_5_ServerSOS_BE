package com.pickgo.global.infra.metric.scheduler;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.pickgo.global.infra.metric.repository.redis.RedisMetricRepository;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MetricScheduler {

    private final AtomicLong lastCount = new AtomicLong(0); // 직전까지 누적 요청 수
    private final MeterRegistry meterRegistry;
    private final RedisMetricRepository redisMetricsRepository;

    private static final Set<String> EXCLUDED_URIS = Set.of(
        "/api/queue/stream",
        "/api/areas/subscribe"
    );

    /**
     * 누적 카운터 기반 TPS 계산
     */
    @Scheduled(fixedRate = 1000)
    public void collectTps() {
        // http.server.requests 중 제외 URI를 제외한 요청만 집계 (정상/에러 응답 모두 포함)
        Collection<Timer> timers = meterRegistry.find("http.server.requests").timers();

        long count = timers.stream()
            .filter(timer -> {
                String uri = timer.getId().getTag("uri");
                return uri != null && !EXCLUDED_URIS.contains(uri);
            })
            .mapToLong(Timer::count)
            .sum();

        long previous = lastCount.getAndSet(count);
        long tps = count - previous; // 지난 1초간 처리된 요청 수

        redisMetricsRepository.saveTps(tps);
    }
}
