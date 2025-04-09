package com.mercadolibre.concesionariaauto.repository;

import com.mercadolibre.concesionariaauto.model.ServiceFromVehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ServiceFromVehicleRepository {
    private List<ServiceFromVehicle> services;

    public ServiceFromVehicleRepository(){
        this.services = new ArrayList<>();
    }

    public void saveService(ServiceFromVehicle service){
        this.services.add(service);
    }

    public List<ServiceFromVehicle> findAll() {
        return services;
    }
}
