package com.concesionariadeautos.concesionariadeautos.service;

import com.concesionariadeautos.concesionariadeautos.dto.VehicleDTO;
import com.concesionariadeautos.concesionariadeautos.dto.VehiclesDateDTO;
import com.concesionariadeautos.concesionariadeautos.dto.VehiclesOffServiceResponseDTO;
import com.concesionariadeautos.concesionariadeautos.dto.VehiclesPriceDTO;
import com.concesionariadeautos.concesionariadeautos.repository.DealershipRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class DealershipServiceImpl implements DealershipService{


    private final DealershipRepositoryImpl dealershipRepository;

    public DealershipServiceImpl(DealershipRepositoryImpl dealershipRepository) {
        this.dealershipRepository = dealershipRepository;
    }

    //Manejar Id incremental
    private AtomicLong idCounter = new AtomicLong(3);

    @Override
    public void addVehicle(VehicleDTO v) {
        List<VehicleDTO> vehicleList = dealershipRepository.getAllVehicles();
        v.setId(idCounter.getAndIncrement());
        vehicleList.add(v);
    }

    @Override
    public List<VehiclesOffServiceResponseDTO> getListVehiclesOffService() {
        List<VehicleDTO> vehicleList = dealershipRepository.getAllVehicles();
        return vehicleList.stream()
                .map(a-> new VehiclesOffServiceResponseDTO(
                        a.getId(),
                        a.getBrand(),
                        a.getModel(),
                        a.getCurrency(),
                        a.getNumberOfKilometers(),
                        a.getDoors(),
                        a.getCountOfOwner(),
                        a.getPrice(),
                        a.getManufacturingDate())).collect(Collectors.toList());
    }

    @Override
    public List<VehiclesDateDTO> getListVehiclesDate(Date since, Date to) {
        List<VehicleDTO> vehicleList = dealershipRepository.getAllVehicles();
        return vehicleList.stream()
                .filter(a-> a.getManufacturingDate().after(since))
                .filter(c->c.getManufacturingDate().before(to))
                .map(b-> new VehiclesDateDTO(b.getId(),b.getBrand(),b.getModel(),b.getManufacturingDate()))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehiclesPriceDTO> getListVehiclesPrice(Double since, Double to) {
        List<VehicleDTO> vehicleList = dealershipRepository.getAllVehicles();
        return vehicleList.stream()
                .filter(a-> Double.parseDouble(a.getPrice()) >= since)
                .filter(b-> Double.parseDouble(b.getPrice()) <= to)
                .map(c -> new VehiclesPriceDTO(c.getId(),
                        c.getBrand(),
                        c.getModel(),
                        c.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public VehicleDTO getVehicleId(Long id) {
        List<VehicleDTO> vehicleList = dealershipRepository.getAllVehicles();
        return vehicleList.stream()
                .filter(a-> a.getId().equals(id))
                .map(b-> new VehicleDTO(b.getId(),
                        b.getBrand(),
                        b.getModel(),
                        b.getCurrency(),
                        b.getNumberOfKilometers(),
                        b.getDoors(),
                        b.getCountOfOwner(),
                        b.getPrice(),
                        b.getManufacturingDate(),
                        b.getServices()))
                .findFirst()
                .orElse(null);
    }
}
