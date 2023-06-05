package com.supinfo.matchleague.service;

import com.supinfo.matchleague.model.MatchReport;
import com.supinfo.matchleague.repository.MatchReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchReportService {
    private final MatchReportRepository matchReportRepository;

    public MatchReportService(MatchReportRepository matchReportRepository) {
        this.matchReportRepository = matchReportRepository;
    }

    public MatchReport createMatchReport(MatchReport matchReport) {
        return matchReportRepository.save(matchReport);
    }

    public MatchReport getMatchReportById(Long id) {
        return matchReportRepository.findById(id).orElse(null);
    }

    public List<MatchReport> getAllMatchReports() {
        return matchReportRepository.findAll();
    }

    public void deleteMatchReport(Long id) {
        matchReportRepository.deleteById(id);
    }
}