package com.mercadolibre.empresa_seguros.service;

import com.mercadolibre.empresa_seguros.dto.request.VehicleDto;
import com.mercadolibre.empresa_seguros.dto.response.VehiclePatentAndBrandDto;
import com.mercadolibre.empresa_seguros.dto.response.VehicleResponseDto;

import java.util.List;

public interface IVehicleService {
    VehicleDto addVehicle(VehicleDto vehicleDto);
    List<VehicleDto> getAll();

    VehicleDto findById(Long id);

    List<String> getQuery();
}
