package com.pickgo.domain.log.dto;

import java.time.LocalDateTime;

import com.pickgo.domain.log.entity.ReservationHistory;

public record ReservationLogResponse(
    Long reservationId,
    Long performanceSessionId,
    String status,
    int totalPrice,
    LocalDateTime reservationTime,
    String performanceName,
    String performanceType,
    String venueName,
    BaseLogResponse base
) {
    public static ReservationLogResponse from(ReservationHistory h) {
        return new ReservationLogResponse(
            h.getReservationId(),
            h.getPerformanceSessionId(),
            h.getStatus(),
            h.getTotalPrice(),
            h.getReservationTime(),
            h.getPerformanceName(),
            h.getPerformanceType(),
            h.getVenueName(),
            BaseLogResponse.from(h)
        );
    }
}
