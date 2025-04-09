package com.concesionariadeautos.concesionariadeautos.service;

import com.concesionariadeautos.concesionariadeautos.dto.VehicleDTO;
import com.concesionariadeautos.concesionariadeautos.dto.VehiclesDateDTO;
import com.concesionariadeautos.concesionariadeautos.dto.VehiclesOffServiceResponseDTO;
import com.concesionariadeautos.concesionariadeautos.dto.VehiclesPriceDTO;

import java.util.Date;
import java.util.List;

public interface DealershipService {
    public void addVehicle(VehicleDTO v);
    public List<VehiclesOffServiceResponseDTO> getListVehiclesOffService();
    public List<VehiclesDateDTO> getListVehiclesDate(Date since, Date to);
    public List<VehiclesPriceDTO> getListVehiclesPrice(Double precioInicio,Double precioFinal);
    public VehicleDTO getVehicleId(Long id);
}
