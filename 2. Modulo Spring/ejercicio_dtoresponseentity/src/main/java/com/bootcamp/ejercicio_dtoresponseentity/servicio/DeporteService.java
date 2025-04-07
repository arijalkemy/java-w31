package com.bootcamp.ejercicio_dtoresponseentity.servicio;

import com.bootcamp.ejercicio_dtoresponseentity.dto.DeporteDto;
import com.bootcamp.ejercicio_dtoresponseentity.modelo.Deporte;
import com.bootcamp.ejercicio_dtoresponseentity.repositorio.DeporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeporteService {
    private final DeporteRepository deporteRepository;

    @Autowired
    public DeporteService(DeporteRepository deporteRepository) {
        this.deporteRepository = deporteRepository;
        loadData();
    }

    private void loadData(){
        deporteRepository.save(new Deporte("Baloncesto", 1));
        deporteRepository.save(new Deporte("Fútbol", 2));
        deporteRepository.save(new Deporte("Tenis", 3));
        deporteRepository.save(new Deporte("Natación", 4));
        deporteRepository.save(new Deporte("Ciclismo", 5));
        deporteRepository.save(new Deporte("Golf", 6));
        deporteRepository.save(new Deporte("Rugby", 7));
        deporteRepository.save(new Deporte("Voleibol", 8));
        deporteRepository.save(new Deporte("Boxeo", 9));
        deporteRepository.save(new Deporte("Esquí", 10));
    }

    public List<DeporteDto> findAll() {
        return deporteRepository.findAll().stream().map(d -> new DeporteDto(d.getNombre(), d.getNivel())).toList();
    }

    public DeporteDto findByName(String nombre) {
        Deporte deporte = deporteRepository.findByName(nombre);
        return deporte == null ? null : new DeporteDto(deporte.getNombre(), deporte.getNivel());
    }
}
