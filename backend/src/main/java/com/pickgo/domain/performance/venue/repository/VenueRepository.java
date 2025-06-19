package com.pickgo.domain.performance.venue.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pickgo.domain.performance.venue.entity.Venue;

public interface VenueRepository extends JpaRepository<Venue, Long> {
    Optional<Venue> findByNameAndAddress(String name, String address);
}
