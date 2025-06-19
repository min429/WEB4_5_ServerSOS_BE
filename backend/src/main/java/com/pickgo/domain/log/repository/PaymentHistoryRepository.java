package com.pickgo.domain.log.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pickgo.domain.log.entity.PaymentHistory;

public interface PaymentHistoryRepository extends JpaRepository<PaymentHistory, Long> {
}
