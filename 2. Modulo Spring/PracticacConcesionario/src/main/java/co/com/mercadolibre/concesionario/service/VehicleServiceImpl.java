package co.com.mercadolibre.concesionario.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import co.com.mercadolibre.concesionario.dto.ServiceDto;
import co.com.mercadolibre.concesionario.dto.VehicleDto;
import co.com.mercadolibre.concesionario.model.Vehicle;
import co.com.mercadolibre.concesionario.model.Service;
import co.com.mercadolibre.concesionario.repository.VehicleRepository;


@org.springframework.stereotype.Service
public class VehicleServiceImpl implements VehicleService{

    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<VehicleDto> getAll() {
        return vehicleRepository.getAll().stream().map(v -> new VehicleDto(
            v.getId(),
            v.getBrand(),
            v.getModel(),
            v.getManufacturingDate(),
            v.getNumberOfKilometers(),
            v.getDoors(),
            v.getPrice(),
            v.getCurrency(),
            null,
            v.getCountOfOwners())).toList();
    }

    @Override
    public List<VehicleDto> getAllByManuFacturingDate(LocalDate since, LocalDate to) {
        List<ServiceDto> listOfServiceDtos = vehicleRepository.getAll()
        .stream()
        .map(v -> v.getListOfServices())
        .flatMap(s -> s.stream()
            .map(sDto -> new ServiceDto(sDto.getDate(), sDto.getKilometers(), sDto.getDescription())))
        .toList();

        return vehicleRepository.getAllByManuFacturingDate(LocalDate.of(2010, 2, 12), 
        LocalDate.now()).stream().map(v -> new VehicleDto(
            v.getId(),
            v.getBrand(),
            v.getModel(),
            v.getManufacturingDate(),
            v.getNumberOfKilometers(),
            v.getDoors(),
            v.getPrice(),
            v.getCurrency(),
            listOfServiceDtos,
            v.getCountOfOwners()
        )).toList();
    }

    @Override
    public VehicleDto getById(Long id) {
        return vehicleRepository.getById(id)
            .map(v -> {
                List<ServiceDto> serviceDtoList = (v.getListOfServices() != null)
                    ? v.getListOfServices().stream()
                        .map(service -> new ServiceDto(
                            service.getDate(),
                            service.getKilometers(),
                            service.getDescription()))
                        .toList()
                    : null;
                return new VehicleDto(
                    v.getId(),
                    v.getBrand(),
                    v.getModel(),
                    v.getManufacturingDate(),
                    v.getNumberOfKilometers(),
                    v.getDoors(),
                    v.getPrice(),
                    v.getCurrency(),
                    serviceDtoList,
                    v.getCountOfOwners()
                );
            })
            .orElseThrow(() -> new RuntimeException("Vehicle with id " + id + " not found"));
    }

    @Override
    public void save(VehicleDto vehicle) {
        List<Service> services = vehicle.getListOfServices().stream()
        .map(s -> new Service(s.getDate(), s.getKilometers(), s.getDescription()))
        .toList();

        Optional<Vehicle> vehicleToBeSaved = Optional.of(vehicle).map(v -> new Vehicle(
            v.getId(),
            v.getBrand(),
            v.getModel(),
            v.getManufacturingDate(),
            v.getNumberOfKilometers(),
            v.getDoors(),
            v.getPrice(),
            v.getCurrency(),
            services,
            v.getCountOfOwners()
        ));

        vehicleRepository.save(vehicleToBeSaved.get());
    }

    public List<VehicleDto> getAllByPrices(double since, double to) {
        return vehicleRepository.getAll().stream()
            .filter(v -> v.getPrice() >= since && v.getPrice() <= to)
            .map(v -> new VehicleDto(
                v.getId(),
                v.getBrand(),
                v.getModel(),
                v.getManufacturingDate(),
                v.getNumberOfKilometers(),
                v.getDoors(),
                v.getPrice(),
                v.getCurrency(),
                (v.getListOfServices() != null) ? v.getListOfServices().stream()
                    .map(service -> new ServiceDto(
                        service.getDate(), 
                        service.getKilometers(), 
                        service.getDescription()))
                    .toList() : null,
                v.getCountOfOwners()
            ))
            .toList();
    }

}
