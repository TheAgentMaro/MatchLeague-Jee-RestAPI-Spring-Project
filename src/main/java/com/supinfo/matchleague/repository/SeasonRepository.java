package com.supinfo.matchleague.repository;

import com.supinfo.matchleague.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Long> {
    boolean existsByLabel(String label);
}