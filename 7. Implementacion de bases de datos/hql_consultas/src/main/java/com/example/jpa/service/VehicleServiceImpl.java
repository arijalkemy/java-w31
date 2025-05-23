package com.example.jpa.service;

import com.example.jpa.dto.VehiculoSiniestroDto;
import com.example.jpa.model.Vehicle;
import com.example.jpa.projection.VehiclePlacaMarcaModeloProjection;
import com.example.jpa.projection.VehiclePlacaMarcaProjection;
import com.example.jpa.repository.IVehicleRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleServiceImpl implements IVehicleService {
    private final IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(IVehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<String> findAllPlacas(){
        return vehicleRepository.findAllPlacas();
    }

    @Override
    public List<VehiclePlacaMarcaProjection> findPlacaAndMarca(){
        return vehicleRepository.findPlacaAndMarca();
    }

    @Override
    public List<String> findAllPlacasByNumberOfWheels(){
        Integer nowYear = LocalDate.now().getYear();
        Integer numberOfWheels = 4;
        return vehicleRepository.findAllPlacasByNumberOfWheelsAndYearOfManufacture(numberOfWheels, nowYear);
    }

    @Override
    public List<VehiclePlacaMarcaModeloProjection> findPlacaAndMarcaAndModelo(){
        Double loss = 10000D;
        return vehicleRepository.findPlacaAndMarcaAndModeloByPlaca(loss);
    }

    @Override
    public List<VehiculoSiniestroDto> obtenerVehiculosConPerdidaMayorA() {
        Double loss = 10000D;
        List<Object[]> resultados = vehicleRepository.findVehicleAndLossSumWhereLossGreaterThan(loss);

        List<VehiculoSiniestroDto> lista = new ArrayList<>();

        for (Object[] fila : resultados) {
            Vehicle vehiculo = (Vehicle) fila[0];
            Double perdidaTotal = (Double) fila[1];
            lista.add(new VehiculoSiniestroDto(vehiculo, perdidaTotal));
        }

        return lista;
    }
}
