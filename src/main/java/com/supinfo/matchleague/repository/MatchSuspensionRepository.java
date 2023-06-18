package com.supinfo.matchleague.repository;

import com.supinfo.matchleague.model.MatchSuspension;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchSuspensionRepository extends JpaRepository<MatchSuspension, Long> {
}