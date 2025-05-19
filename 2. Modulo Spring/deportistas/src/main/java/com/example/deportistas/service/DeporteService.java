package com.example.deportistas.service;

import com.example.deportistas.entity.Deporte;
import com.example.deportistas.repository.DeporteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeporteService {
    private final DeporteRepository deporteRepository;

    public DeporteService(DeporteRepository deporteRepository){
        this.deporteRepository = deporteRepository;
    }

    public List<Deporte> getDeportes(){
        return deporteRepository.findAll();
    }

    public ResponseEntity<Deporte> findDeporteByName(String nombre){
        Deporte deporte = deporteRepository.findByName(nombre);
        if( deporte == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(deporte);
        }
    }
}
