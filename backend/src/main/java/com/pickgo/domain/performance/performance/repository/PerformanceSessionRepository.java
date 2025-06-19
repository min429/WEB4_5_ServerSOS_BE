package com.pickgo.domain.performance.performance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pickgo.domain.performance.performance.entity.PerformanceSession;

public interface PerformanceSessionRepository extends JpaRepository<PerformanceSession, Long> {
}
