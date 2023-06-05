package com.supinfo.matchleague.repository;


import com.supinfo.matchleague.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
    //méthodes supplémentaires spécifiques si nécessaire
}