package com.supinfo.matchleague.service;

import com.supinfo.matchleague.model.Day;
import com.supinfo.matchleague.repository.DayRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DayService {
    private final DayRepository dayRepository;

    public DayService(DayRepository dayRepository) {
        this.dayRepository = dayRepository;
    }

    public Day createDay(Day day) {
        return dayRepository.save(day);
    }

    public Day getDayById(Long id) throws NotFoundException {
        return dayRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Day not found"));
    }

    public void updateDay(Day updatedDay) {
        dayRepository.save(updatedDay);
    }

    public void deleteDay(Long id) {
        dayRepository.deleteById(id);
    }

}