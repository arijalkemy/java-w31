package com.mercadolibre.hql.service;

import com.mercadolibre.hql.dto.VehicleDto;
import com.mercadolibre.hql.dto.VehicleLossDTO;
import com.mercadolibre.hql.dto.VehicleSummaryDto;

import java.util.List;

public interface IVehicleService {

    VehicleDto save(VehicleDto vehicleDto);
    List<VehicleDto> findAll();

    List<String> getAllPatents();

    List<VehicleSummaryDto> findAllPatentAndBrandOrderByManufacturingYear();

    List<String> getHeavyCurrentYearVehicles();

    List<VehicleDto> getVehiclesWithAccidentsOver10000();

    List<VehicleLossDTO> getVehiclesWithHighLosses();

    VehicleDto findById(Long id);
    void delete(Long id);
    VehicleDto update(Long id, VehicleDto vehicleDto);
}
