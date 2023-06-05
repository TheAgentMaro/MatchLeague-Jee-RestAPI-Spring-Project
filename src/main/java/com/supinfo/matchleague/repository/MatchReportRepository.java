package com.supinfo.matchleague.repository;

import com.supinfo.matchleague.model.MatchReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchReportRepository extends JpaRepository<MatchReport, Long> {
    // Add custom query methods if needed
}