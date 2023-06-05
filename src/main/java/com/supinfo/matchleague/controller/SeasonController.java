package com.supinfo.matchleague.controller;

import com.supinfo.matchleague.service.SeasonService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.supinfo.matchleague.model.Season;
import org.springframework.security.access.prepost.PreAuthorize;



@RestController
@RequestMapping("/api/seasons")
public class SeasonController {
    private final SeasonService seasonService;

    public SeasonController(SeasonService seasonService) {
        this.seasonService = seasonService;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Season> createSeason(@RequestBody Season season) {
        Season createdSeason = seasonService.createSeason(season);
        return new ResponseEntity<>(createdSeason, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Season> getSeasonById(@PathVariable Long id) throws NotFoundException {
        Season season = seasonService.getSeasonById(id);
        return ResponseEntity.ok(season);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Season> updateSeason(@PathVariable Long id, @RequestBody Season season) throws NotFoundException {
        Season updatedSeason = seasonService.updateSeason(id, season);
        return ResponseEntity.ok(updatedSeason);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteSeason(@PathVariable Long id) throws NotFoundException {
        seasonService.deleteSeason(id);
        return ResponseEntity.noContent().build();
    }

}