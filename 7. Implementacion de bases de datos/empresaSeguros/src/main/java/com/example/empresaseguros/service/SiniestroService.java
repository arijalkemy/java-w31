package com.example.empresaseguros.service;

import com.example.empresaseguros.dto.SiniestroDto;
import com.example.empresaseguros.model.Siniestro;
import com.example.empresaseguros.repository.ISiniestroRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SiniestroService implements ISiniestroService{
    @Autowired
    private ISiniestroRepository siniestroRepo;
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public List<SiniestroDto> obtenerSiniestros() {
        return siniestroRepo.findAll().stream()
                .map(s -> mapper.convertValue(s, SiniestroDto.class))
                .toList();
    }

    @Override
    public SiniestroDto crearSiniestro(SiniestroDto siniestroDto) {
        Siniestro siniestro = mapper.convertValue(siniestroDto, Siniestro.class);
        siniestroRepo.save(siniestro);
        return siniestroDto;
    }

    @Override
    public String borrarSiniestro(Long id) {
        siniestroRepo.deleteById(id);
        return "Se borro exitosamente el siniestro con id: " + id;
    }

    @Override
    public SiniestroDto modificarSiniestro(Long id, SiniestroDto newSiniestroDto) {
        Optional<Siniestro> opSiniestro = siniestroRepo.findById(id);
        if(opSiniestro.isPresent()){
            Siniestro siniestro = opSiniestro.get();
            siniestro.setFecha(newSiniestroDto.getFecha());
            siniestro.setPerdidaEconomica(newSiniestroDto.getPerdidaEconomica());
            siniestro.setIdVehiculo(newSiniestroDto.getIdVehiculo());
            siniestroRepo.save(siniestro);
            return mapper.convertValue(siniestro, SiniestroDto.class);
        }
        return null;
    }
}
