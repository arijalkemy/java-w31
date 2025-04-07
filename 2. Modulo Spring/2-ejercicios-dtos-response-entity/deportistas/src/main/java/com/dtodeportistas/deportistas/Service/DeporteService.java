package com.dtodeportistas.deportistas.Service;

import com.dtodeportistas.deportistas.DTO.DeporteDTO;
import com.dtodeportistas.deportistas.Model.Deporte;
import com.dtodeportistas.deportistas.Repository.DeporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeporteService {

    @Autowired
    private DeporteRepository deporteRepository;

    public List<DeporteDTO> getTodosLosDeportes() {
        List<Deporte> deportes = deporteRepository.getDeportes();

        return deportes.stream()
                .map(deporte -> new DeporteDTO(deporte.getNombre(), deporte.getNivel()))
                .toList();
    }

    public Integer getNivelByDeporte(String deporte) {
        return deporteRepository.getNivelByDeporte(deporte);
    }

}
