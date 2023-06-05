package com.supinfo.matchleague.service;

import com.supinfo.matchleague.model.Season;
import com.supinfo.matchleague.repository.SeasonRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SeasonService {
    private final SeasonRepository seasonRepository;

    public SeasonService(SeasonRepository seasonRepository) {
        this.seasonRepository = seasonRepository;
    }

    public Season createSeason(Season season) {
        if (seasonRepository.existsByLabel(season.getLabel())) {
            throw new IllegalArgumentException("La saison existe déjà avec le label : " + season.getLabel());
        }

        return seasonRepository.save(season);
    }

    public Season getSeasonById(Long id) throws NotFoundException {
        // Retrieve a season by its ID
        return seasonRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Saison not found"));
    }

    public void deleteSeason(Long id) throws NotFoundException {
        // Check if the season has any scheduled days
        Season season = getSeasonById(id);
        if (!season.getDays().isEmpty()) {
            throw new IllegalArgumentException("Impossible de supprimer - journées programmées");
        }
        seasonRepository.deleteById(id);
    }

    public Season updateSeason(Long id, Season season) throws NotFoundException {
        Optional<Season> optionalSeason = seasonRepository.findById(id);
        if (optionalSeason.isEmpty()) {
            throw new NotFoundException("Saison not found");
        }

        Season existingSeason = optionalSeason.get();

        existingSeason.setLabel(season.getLabel());

        Season updatedSeason = seasonRepository.save(existingSeason);
        return updatedSeason;
    }

}