package com.supinfo.matchleague.service;

import com.supinfo.matchleague.model.Match;
import com.supinfo.matchleague.repository.MatchRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MatchService {
    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public Match createMatch(Match match) {
        return matchRepository.save(match);
    }

    public Match getMatchById(Long id) throws NotFoundException {
        return matchRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Match not found"));
    }

    public Match updateMatch(Long id, Match updatedMatch) {
        matchRepository.save(updatedMatch);
        return updatedMatch;
    }

    public void deleteMatch(Long id) {
        matchRepository.deleteById(id);
    }

}