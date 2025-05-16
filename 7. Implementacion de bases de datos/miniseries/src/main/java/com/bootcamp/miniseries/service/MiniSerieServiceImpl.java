package com.bootcamp.miniseries.service;

import com.bootcamp.miniseries.dto.MiniSerieDto;
import com.bootcamp.miniseries.model.MiniSerie;
import com.bootcamp.miniseries.repository.IMiniSerieRepository;
import com.bootcamp.miniseries.util.MiniSerieMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MiniSerieServiceImpl implements IMiniSerieService {
    private final IMiniSerieRepository miniSerieRepository;

    public MiniSerieServiceImpl(IMiniSerieRepository miniSerieRepository) {
        this.miniSerieRepository = miniSerieRepository;
    }

    @Override
    @Transactional
    public MiniSerieDto save(MiniSerieDto miniSerieDto) {
        MiniSerie miniSerie = MiniSerieMapper.toMiniSerie(miniSerieDto);
        MiniSerie savedMiniSerie = miniSerieRepository.save(miniSerie);
        return MiniSerieMapper.toMiniSerieDto(savedMiniSerie);
    }

    @Override
    public Optional<MiniSerie> findByName(String name) {
        return miniSerieRepository.findByName(name);
    }
}
