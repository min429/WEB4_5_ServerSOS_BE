package com.pickgo.domain.log.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pickgo.domain.log.entity.ReservationHistory;

public interface ReservationHistoryRepository extends JpaRepository<ReservationHistory, Long> {
}
