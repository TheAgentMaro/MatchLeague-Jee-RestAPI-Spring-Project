package com.supinfo.matchleague.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean isAdmin;

    @Column(nullable = false)
    private boolean isMemberLeague;

    @Column(nullable = false)
    private boolean isJournaliste;

    // Constructors, getters, and setters
    public User() {
    }

    public User(String username, String password, boolean isAdmin, boolean isMemberLeague, boolean isJournaliste) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.isMemberLeague = isMemberLeague;
        this.isJournaliste = isJournaliste;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isMemberLeague() {
        return isMemberLeague;
    }

    public void setMemberLeague(boolean memberLeague) {
        isMemberLeague = memberLeague;
    }

    public boolean isJournaliste() {
        return isJournaliste;
    }

    public void setJournaliste(boolean journaliste) {
        isJournaliste = journaliste;
    }

}