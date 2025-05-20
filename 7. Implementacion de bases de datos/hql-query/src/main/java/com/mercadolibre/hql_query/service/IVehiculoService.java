package com.mercadolibre.hql_query.service;

import com.mercadolibre.hql_query.entity.Vehiculo;
import com.mercadolibre.hql_query.entity.dto.VehiculoDto;

import java.util.List;

public interface IVehiculoService {

    List<Vehiculo> listarPatentes();

    Vehiculo crearVehiculo(Vehiculo vehiculo);
}
