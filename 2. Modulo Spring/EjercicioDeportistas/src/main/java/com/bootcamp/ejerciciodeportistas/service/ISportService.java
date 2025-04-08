package com.bootcamp.ejerciciodeportistas.service;

import com.bootcamp.ejerciciodeportistas.dto.SportDto;

import java.util.List;

public interface ISportService {
    public List<SportDto> allSports();

    SportDto findSport(String name);
}
