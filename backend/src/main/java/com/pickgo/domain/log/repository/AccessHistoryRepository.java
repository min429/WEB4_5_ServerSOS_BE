package com.pickgo.domain.log.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pickgo.domain.log.entity.AccessHistory;

public interface AccessHistoryRepository extends JpaRepository<AccessHistory, Long> {
}
