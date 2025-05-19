package com.mercadolibre.demo.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.demo.dto.CapituloDTO;
import com.mercadolibre.demo.dto.MiniSerieDTO;
import com.mercadolibre.demo.model.Capitulo;
import com.mercadolibre.demo.model.MiniSerie;
import com.mercadolibre.demo.repository.ICapituloRepository;
import com.mercadolibre.demo.repository.IMiniserieRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CapituloService implements ICapituloService {

    @Autowired
    private ICapituloRepository capituloRepository;
    @Autowired
    private IMiniserieRespository miniserieRespository;
    @Override
    public List<CapituloDTO> findAll() {
        ObjectMapper mapper = new ObjectMapper();
        return capituloRepository.findAll()
                .stream().map(m -> mapper.convertValue(m, CapituloDTO.class))
                .toList();
    }

    @Override
    public Optional<CapituloDTO> findById(Long id) {
        ObjectMapper mapper = new ObjectMapper();
        return capituloRepository.findById(id)
                .map(capitulo -> mapper.convertValue(capitulo, CapituloDTO.class));

    }

    @Override
    public void save(Long id, CapituloDTO capitulo) {
        ObjectMapper mapper = new ObjectMapper();
        Capitulo capituloClass = mapper.convertValue(capitulo, Capitulo.class);
        Optional<MiniSerie> miniserie = miniserieRespository.findById(id);
        MiniSerie miniserieClass = miniserie.get();
        capituloClass.setMiniSerie(miniserieClass);
        capituloRepository.save(capituloClass);
    }

    @Override
    public void delete(Long id) {
    capituloRepository.deleteById(id);
    }
}
