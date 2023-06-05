package com.supinfo.matchleague.controller;

import com.supinfo.matchleague.model.MatchReport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.supinfo.matchleague.service.MatchReportService;

import java.util.List;


@RestController
@RequestMapping("/api/match-reports")
public class MatchReportController {
    private final MatchReportService matchReportService;

    public MatchReportController(MatchReportService matchReportService) {
        this.matchReportService = matchReportService;
    }

    @PostMapping
    @PreAuthorize("hasRole('MEMBER-LEAGUE')")
    public ResponseEntity<MatchReport> createMatchReport(@RequestBody MatchReport matchReport) {
        MatchReport createdMatchReport = matchReportService.createMatchReport(matchReport);
        return new ResponseEntity<>(createdMatchReport, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchReport> getMatchReportById(@PathVariable Long id) {
        MatchReport matchReport = matchReportService.getMatchReportById(id);
        if (matchReport != null) {
            return ResponseEntity.ok(matchReport);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<MatchReport>> getAllMatchReports() {
        List<MatchReport> matchReports = matchReportService.getAllMatchReports();
        return ResponseEntity.ok(matchReports);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('MEMBER-LEAGUE')")
    public ResponseEntity<Void> deleteMatchReport(@PathVariable Long id) {
        matchReportService.deleteMatchReport(id);
        return ResponseEntity.noContent().build();
    }
}