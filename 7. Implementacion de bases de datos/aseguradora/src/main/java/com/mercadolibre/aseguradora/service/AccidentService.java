package com.mercadolibre.aseguradora.service;

import com.mercadolibre.aseguradora.model.Accident;
import com.mercadolibre.aseguradora.repository.IAccidentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccidentService {

    private final IAccidentRepository accidentRepository;

    public AccidentService(IAccidentRepository accidentRepository) {
        this.accidentRepository = accidentRepository;
    }

    // Ejemplo genérico si alguna lógica se requiere exclusivamente desde accidentes
    public List<Accident> getAllAccidentsByVehicleId(Long vehicleId) {
        return accidentRepository.findByVehicleId(vehicleId);
    }
}
