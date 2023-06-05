package com.supinfo.matchleague.service;

import com.supinfo.matchleague.model.MatchSuspension;
import com.supinfo.matchleague.repository.MatchSuspensionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchSuspensionService {
    private final MatchSuspensionRepository matchSuspensionRepository;

    public MatchSuspensionService(MatchSuspensionRepository matchSuspensionRepository) {
        this.matchSuspensionRepository = matchSuspensionRepository;
    }

    public MatchSuspension createMatchSuspension(MatchSuspension matchSuspension) {
        return matchSuspensionRepository.save(matchSuspension);
    }

    public MatchSuspension getMatchSuspensionById(Long id) {
        return matchSuspensionRepository.findById(id).orElse(null);
    }

    public List<MatchSuspension> getAllMatchSuspensions() {
        return matchSuspensionRepository.findAll();
    }

    public void deleteMatchSuspension(Long id) {
        matchSuspensionRepository.deleteById(id);
    }
}
