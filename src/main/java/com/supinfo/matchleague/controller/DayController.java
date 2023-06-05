package com.supinfo.matchleague.controller;

import com.supinfo.matchleague.service.DayService;
import com.supinfo.matchleague.model.Day;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/days")
public class DayController {
    private final DayService dayService;

    public DayController(DayService dayService) {
        this.dayService = dayService;
    }

    @PostMapping
    @PreAuthorize("hasRole('MEMBER-LEAGUE')")
    public ResponseEntity<Day> createDay(@RequestBody Day day) {
        Day createdDay = dayService.createDay(day);
        return new ResponseEntity<>(createdDay, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Day> getDayById(@PathVariable Long id) throws NotFoundException {
        Day day = dayService.getDayById(id);
        return ResponseEntity.ok(day);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('MEMBER-LEAGUE')")
    public ResponseEntity<Void> deleteDay(@PathVariable Long id) {
        dayService.deleteDay(id);
        return ResponseEntity.noContent().build();
    }

}