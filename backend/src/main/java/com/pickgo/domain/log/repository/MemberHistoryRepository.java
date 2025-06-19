package com.pickgo.domain.log.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pickgo.domain.log.entity.MemberHistory;

public interface MemberHistoryRepository extends JpaRepository<MemberHistory, Long> {
}
