package com.example.MiniSeries.service;

import com.example.MiniSeries.dto.MiniSerieDTO;
import com.example.MiniSeries.dto.UpdateMiniSerieDTO;
import com.example.MiniSeries.entity.MiniSerie;
import com.example.MiniSeries.repository.IMiniserieRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MiniSerieServiceImpl implements  IMiniSerieService{

    private IMiniserieRepository repository;
    ObjectMapper mapper = new ObjectMapper();

    public MiniSerieServiceImpl(IMiniserieRepository repository) {
        this.repository = repository;
    }


    @Override
    @Transactional(readOnly = true)
    public List<MiniSerieDTO> getMiniSerie() {
        List<MiniSerie> miniSeries = repository.findAll();

        return miniSeries.stream()
                .map(ms -> mapper.convertValue(ms, MiniSerieDTO.class)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void saveMiniSerie(MiniSerieDTO miniserieDTO) {
        MiniSerie miniSerie = mapper.convertValue(miniserieDTO, MiniSerie.class);
        repository.save(miniSerie);
    }

    @Override
    @Transactional
    public void deleteMiniSerie(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public MiniSerieDTO findMiniSerie(Long id) {
        MiniSerie miniSerie = repository.findById(id).orElse(null);
        return mapper.convertValue(miniSerie, MiniSerieDTO.class);
    }

    @Override
    @Transactional
    public String updateMiniSerie(Long id, UpdateMiniSerieDTO updateData) {
        MiniSerie miniSerie = repository.findById(id).orElse(null);

        if(miniSerie == null) {
            return "No se encontró la Mini Serie buscada";
        }

        miniSerie.setName(updateData.getName());
        miniSerie.setRating(updateData.getRating());
        miniSerie.setAmount_of_awards(updateData.getAmount_of_awards());

        return "Se actualizaron los datos correctamente";
    }
}
