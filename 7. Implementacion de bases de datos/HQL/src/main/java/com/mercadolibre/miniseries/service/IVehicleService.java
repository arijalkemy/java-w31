package com.mercadolibre.miniseries.service;

import com.mercadolibre.miniseries.dto.VehicleDto;

import java.util.List;

public interface IVehicleService {
    public List<String> getAll();

    public List<VehicleDto> getAllOrder();

    public List<VehicleDto> getByYear();

    public List<VehicleDto> getSinister();

}
