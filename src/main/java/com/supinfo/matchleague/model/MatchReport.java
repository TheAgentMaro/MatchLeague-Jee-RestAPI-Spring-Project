package com.supinfo.matchleague.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "match_reports")
public class MatchReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match match;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User memberLeague;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Column(nullable = false)
    private String report;


    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public User getMemberLeague() {
        return memberLeague;
    }

    public void setMemberLeague(User memberLeague) {
        this.memberLeague = memberLeague;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }
}