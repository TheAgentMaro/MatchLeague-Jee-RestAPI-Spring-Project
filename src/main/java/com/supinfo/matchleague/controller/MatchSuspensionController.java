package com.supinfo.matchleague.controller;

import com.supinfo.matchleague.model.MatchSuspension;
import com.supinfo.matchleague.service.MatchSuspensionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/match-suspensions")
public class MatchSuspensionController {
    private final MatchSuspensionService matchSuspensionService;

    public MatchSuspensionController(MatchSuspensionService matchSuspensionService) {
        this.matchSuspensionService = matchSuspensionService;
    }

    @PostMapping
    @PreAuthorize("hasRole('MEMBER-LEAGUE')")
    public ResponseEntity<MatchSuspension> createMatchSuspension(@RequestBody MatchSuspension matchSuspension) {
        MatchSuspension createdMatchSuspension = matchSuspensionService.createMatchSuspension(matchSuspension);
        return new ResponseEntity<>(createdMatchSuspension, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchSuspension> getMatchSuspensionById(@PathVariable Long id) {
        MatchSuspension matchSuspension = matchSuspensionService.getMatchSuspensionById(id);
        if (matchSuspension != null) {
            return ResponseEntity.ok(matchSuspension);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<MatchSuspension>> getAllMatchSuspensions() {
        List<MatchSuspension> matchSuspensions = matchSuspensionService.getAllMatchSuspensions();
        return ResponseEntity.ok(matchSuspensions);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('MEMBER-LEAGUE')")
    public ResponseEntity<Void> deleteMatchSuspension(@PathVariable Long id) {
        matchSuspensionService.deleteMatchSuspension(id);
        return ResponseEntity.noContent().build();
    }
}