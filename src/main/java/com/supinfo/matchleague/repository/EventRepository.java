package com.supinfo.matchleague.repository;

import com.supinfo.matchleague.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    // Add custom query methods if needed
}