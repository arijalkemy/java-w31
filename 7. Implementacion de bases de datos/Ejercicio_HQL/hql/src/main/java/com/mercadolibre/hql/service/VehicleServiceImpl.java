package com.mercadolibre.hql.service;

import com.mercadolibre.hql.dto.VehicleDto;
import com.mercadolibre.hql.dto.VehicleLossDTO;
import com.mercadolibre.hql.dto.VehicleSummaryDto;
import com.mercadolibre.hql.model.Accident;
import com.mercadolibre.hql.model.Vehicle;
import com.mercadolibre.hql.repository.VehicleRepository;
import com.mercadolibre.hql.utils.MapperUtil;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService {

    private VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public VehicleDto save(VehicleDto vehicleDto) {
        Vehicle vehicle = MapperUtil.toEntity(vehicleDto);
        return MapperUtil.toDto(vehicleRepository.save(vehicle));
    }

    @Override
    public List<VehicleDto> findAll() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        return vehicles.stream().map(MapperUtil::toDto).toList();
    }

    @Override
    public List<String> getAllPatents() {
        return vehicleRepository.findAllPatents();
    }

    @Override
    public List<VehicleSummaryDto> findAllPatentAndBrandOrderByManufacturingYear(){
        return vehicleRepository.findPatentAndBrandOrderByManufacturingYear();
    }

    @Override
    public List<String> getHeavyCurrentYearVehicles() {
        int currentYear = Year.now().getValue();
        return vehicleRepository.findPatentsOfHeavyVehiclesByYear(currentYear);
    }

    @Override
    public List<VehicleDto> getVehiclesWithAccidentsOver10000() {
        List<Vehicle> vehicles = vehicleRepository.findVehiclesWithAccidentsOver10000();
        return vehicles.stream().map(MapperUtil::toDto).toList();
    }


    @Override
    public List<VehicleLossDTO> getVehiclesWithHighLosses() {
        List<Vehicle> vehicles = vehicleRepository.findVehiclesWithAccidentsOver10000();

        return vehicles.stream()
                .map(vehicle -> {
                    Double totalLoss = vehicle.getAccidents().stream()
                            .filter(accident -> accident.getEconomicLoss() > 10000)
                            .mapToDouble(Accident::getEconomicLoss)
                            .sum();

                    return new VehicleLossDTO(
                            vehicle.getPatent(),
                            vehicle.getBrand(),
                            vehicle.getModel(),
                            totalLoss
                    );
                })
                .collect(Collectors.toList());
    }

        @Override
    public VehicleDto findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public VehicleDto update(Long id, VehicleDto vehicleDto) {
        return null;
    }
}
