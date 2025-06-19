package com.pickgo.domain.performance.area.seat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pickgo.domain.performance.area.area.entity.PerformanceArea;
import com.pickgo.domain.performance.area.seat.entity.ReservedSeat;
import com.pickgo.domain.performance.performance.entity.PerformanceSession;

public interface ReservedSeatRepository extends JpaRepository<ReservedSeat, Long> {
    List<ReservedSeat> findByPerformanceAreaAndPerformanceSession(PerformanceArea area,
        PerformanceSession performanceSession);

}
