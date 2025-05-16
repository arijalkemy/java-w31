package com.bootcamp.miniseries.service;

import com.bootcamp.miniseries.dto.MiniSerieDto;
import com.bootcamp.miniseries.model.MiniSerie;

import java.util.Optional;

public interface IMiniSerieService {
    MiniSerieDto save(MiniSerieDto miniSerieDto);

    Optional<MiniSerie> findByName(String name);
}
