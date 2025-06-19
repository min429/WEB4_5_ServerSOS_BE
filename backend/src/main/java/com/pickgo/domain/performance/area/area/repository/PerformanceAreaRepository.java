package com.pickgo.domain.performance.area.area.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pickgo.domain.performance.area.area.entity.PerformanceArea;
import com.pickgo.domain.performance.performance.entity.Performance;

public interface PerformanceAreaRepository extends JpaRepository<PerformanceArea, Long> {
    List<PerformanceArea> findByPerformance(Performance performance);
}
