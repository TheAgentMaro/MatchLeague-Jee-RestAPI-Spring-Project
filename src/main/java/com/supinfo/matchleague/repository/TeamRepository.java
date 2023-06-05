package com.supinfo.matchleague.repository;

import com.supinfo.matchleague.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    //méthodes supplémentaires spécifiques si nécessaire
}