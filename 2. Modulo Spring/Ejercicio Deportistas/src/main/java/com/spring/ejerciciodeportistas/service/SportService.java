package com.spring.ejerciciodeportistas.service;

import com.spring.ejerciciodeportistas.model.Sport;
import com.spring.ejerciciodeportistas.repository.SportRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportService {

    private final SportRepository sportRepository;

    public SportService(SportRepository sportRepository) {
        this.sportRepository = sportRepository;
    }

    public List<Sport> getSports() {
        return sportRepository.findAll();
    }

    public ResponseEntity<Sport> findSportByName(String name) {
        Sport sport = sportRepository.findByName(name);
        if (sport == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(sport);
        }
    }
}
