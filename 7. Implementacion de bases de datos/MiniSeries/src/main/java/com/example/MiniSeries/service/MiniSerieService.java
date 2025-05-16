package com.example.MiniSeries.service;

import com.example.MiniSeries.repository.IMiniserieRepository;

public class MiniSerieService {

    private IMiniserieRepository repository;

    public MiniSerieService(IMiniserieRepository repository) {
        this.repository = repository;
    }
}
