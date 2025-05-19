package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.repository.IMiniserieRepository;

@Service
public class MiniserieService {
    
    private final IMiniserieRepository miniSerieRepo;

    public MiniserieService (IMiniserieRepository miniSerieRepo){
        this.miniSerieRepo = miniSerieRepo;
    }
}
