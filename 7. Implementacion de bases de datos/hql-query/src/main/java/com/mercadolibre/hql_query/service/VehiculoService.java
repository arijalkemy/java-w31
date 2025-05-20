package com.mercadolibre.hql_query.service;

import com.mercadolibre.hql_query.entity.Vehiculo;
import com.mercadolibre.hql_query.repository.IVehiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService implements IVehiculoService{

    private final IVehiculoRepository vehiculoRepository;

    public VehiculoService(IVehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public Vehiculo crearVehiculo(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    @Override
    public List<Vehiculo> listarPatentes(){
        List<Vehiculo> vehiculoList = vehiculoRepository.listarPatentes();

        vehiculoList.stream().forEach(e -> e.getPatente());

        return null;
    }
}
