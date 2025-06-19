package com.pickgo.domain.performance.area.area.dto;

import java.util.List;

import com.pickgo.domain.performance.area.area.entity.PerformanceArea;
import com.pickgo.domain.performance.area.seat.dto.SeatSimpleResponse;
import com.pickgo.domain.performance.area.seat.entity.ReservedSeat;

public record PerformanceAreaDetailResponse(
    Long id,
    String name,
    String grade,
    int price,
    int rowCount,
    int colCount,
    List<SeatSimpleResponse> reservedSeats
) {
    public static PerformanceAreaDetailResponse from(PerformanceArea area, List<ReservedSeat> reservedSeats) {
        return new PerformanceAreaDetailResponse(
            area.getId(),
            area.getName().getValue(),
            area.getGrade().getValue(),
            area.getPrice(),
            area.getRowCount(),
            area.getColCount(),
            reservedSeats.stream().map(SeatSimpleResponse::from).toList()
        );
    }
}
