package co.com.mercadolibre.practicaconsultashql.service;

import co.com.mercadolibre.practicaconsultashql.dto.VehiculoDto;
import co.com.mercadolibre.practicaconsultashql.model.Vehiculo;
import co.com.mercadolibre.practicaconsultashql.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService{

    private final VehicleRepository vehicleRepository;

    @Override
    public List<VehiculoDto> findAllVehiclesPatente() {
        List<String> patentes = vehicleRepository.findAllVehiclesPatente()
                .stream()
                .map(Vehiculo::getPatente).toList();
    }
}
