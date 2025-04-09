package com.meli.deportistas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.meli.deportistas.model.SportModel;
import com.meli.deportistas.repository.SportRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SportService {

    private final SportRepository sportRepository;

    public List<SportModel> getAllSports() {
        return sportRepository.getAllSports();
    }

    public SportModel getSportByName(String name) {
        return sportRepository.getSportByName(name);
    }

}
