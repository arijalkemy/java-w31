package co.com.mercadolibre.practicaconsultashql.service;

import co.com.mercadolibre.practicaconsultashql.dto.VehiculoDto;
;

import java.util.List;

public interface VehicleService {

    List<VehiculoDto> findAllVehiclesPatente();
}
