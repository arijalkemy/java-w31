package siniestros.vehiculos.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import siniestros.vehiculos.dto.VehicleDto;
import siniestros.vehiculos.model.Vehicle;
import siniestros.vehiculos.repository.IVehicleRepository;
import siniestros.vehiculos.service.IVehicleService;

import java.util.List;

@Service
public class VehicleServiceImpl implements IVehicleService {

    @Autowired
    private IVehicleRepository vehicleRepository;

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public List<VehicleDto> findAll() {
        List<Vehicle> result = vehicleRepository.findAll();
        return result.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .toList();
    }

    @Override
    public VehicleDto save(VehicleDto vehicleDto) {
        Vehicle result = vehicleRepository.save(mapper.convertValue(vehicleDto, Vehicle.class));
        return mapper.convertValue(result, VehicleDto.class);
    }

    @Override
    public List<VehicleDto> findAllOrderByYear() {
        List<Vehicle> result = vehicleRepository.findAllOrderByYear();
        return result.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .toList();
    }

    @Override
    public List<VehicleDto> findByWheelsGreaterThan4AndCurrentYear() {
        List<Vehicle> result = vehicleRepository.findByWheelsGreaterThanAndCurrentYear(4);
        return result.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .toList();
    }
}
