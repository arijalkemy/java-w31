package com.mercadolibre.demo.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.demo.dto.MiniSerieDTO;
import com.mercadolibre.demo.model.MiniSerie;
import com.mercadolibre.demo.repository.IMiniserieRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MiniSerieService implements IMiniSerieService{

    @Autowired
    private IMiniserieRespository miniSerieRepository;

    @Override
    public List<MiniSerieDTO> findAll() {
        ObjectMapper mapper = new ObjectMapper();
        return miniSerieRepository.findAll()
                .stream().map(m -> mapper.convertValue(m, MiniSerieDTO.class))
                .toList();
    }

    @Override
    public Optional<MiniSerieDTO> findById(Long id) {
        ObjectMapper mapper = new ObjectMapper();
        return miniSerieRepository.findById(id)
                .map(miniserie -> mapper.convertValue(miniserie, MiniSerieDTO.class));
    }
    @Override
    public void save(MiniSerieDTO miniSerie) {
        ObjectMapper mapper = new ObjectMapper();
        MiniSerie miniSerieClass = mapper.convertValue(miniSerie, MiniSerie.class);
        miniSerieRepository.save(miniSerieClass);
    }

    @Override
    public void delete(Long id) {
    miniSerieRepository.deleteById(id);
    }
}
