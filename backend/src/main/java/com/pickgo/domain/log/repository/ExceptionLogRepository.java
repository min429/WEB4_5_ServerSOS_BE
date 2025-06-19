package com.pickgo.domain.log.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pickgo.domain.log.entity.ExceptionHistory;

public interface ExceptionLogRepository extends JpaRepository<ExceptionHistory, Long> {
}
