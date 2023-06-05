package com.supinfo.matchleague.controller;

import com.supinfo.matchleague.model.Match;
import com.supinfo.matchleague.service.MatchService;
import javassist.NotFoundException;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;


@RestController
@RequestMapping("/api/matches")
public class MatchController {
    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @PostMapping
    @PreAuthorize("hasRole('JOURNALISTE')")
    public ResponseEntity<Match> createMatch(@RequestBody Match match) {
        Match createdMatch = matchService.createMatch(match);
        return new ResponseEntity<>(createdMatch, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Match> getMatchById(@PathVariable Long id) throws NotFoundException {
        Match match = matchService.getMatchById(id);
        return ResponseEntity.ok(match);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('JOURNALISTE')")
    public ResponseEntity<Match> updateMatch(@PathVariable Long id, @RequestBody Match match) {
        Match updatedMatch = matchService.updateMatch(id, match);
        return ResponseEntity.ok(updatedMatch);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('JOURNALISTE')")
    public ResponseEntity<Void> deleteMatch(@PathVariable Long id) {
        matchService.deleteMatch(id);
        return ResponseEntity.noContent().build();
    }
}