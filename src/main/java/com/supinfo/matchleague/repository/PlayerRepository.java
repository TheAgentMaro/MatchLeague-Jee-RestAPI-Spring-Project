package com.supinfo.matchleague.repository;

import com.supinfo.matchleague.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    // Add custom query methods if needed
}