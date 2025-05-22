package org.meli.segurosautos.service;

import org.meli.segurosautos.dto.VehicleDto;
import org.meli.segurosautos.dto.VehicleTotalLossDto;

import java.util.List;

public interface IVehicleService {
    List<String> getAllLicensePlates();
    List<VehicleDto> getLicensePlateAndBrandOrderedByManufactureYear();
    List<VehicleDto> getLicensePlateByNumberOfWheelsAndCurrentYear();
    List<VehicleDto> getVehiclesByEconomicLoss();
    List<VehicleTotalLossDto> getVehiclesByEconomicLossSum();
}
