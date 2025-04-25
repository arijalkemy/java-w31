package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.IdDuplicateException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.mapper.IMapper;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    @Autowired
    IVehicleRepository repository;

    @Autowired
    IMapper mapper;

    @Override
    public List<VehicleDto> searchAllVehicles() {
        List<Vehicle> vehicleList = repository.findAll();
        if(vehicleList.isEmpty())
        {
            throw new NotFoundException("No se encontro ningun auto en el sistema.");
        }

        List<VehicleDto> vehicleDtoList = new ArrayList<>();
        for(Vehicle v:vehicleList){
            VehicleDto vehicleDto = new VehicleDto(
                    v.getId(),
                    v.getBrand(),
                    v.getModel(),
                    v.getRegistration(),
                    v.getColor(),
                    v.getYear(),
                    v.getMax_speed(),
                    v.getPassengers(),
                    v.getFuel_type(),
                    v.getTransmission(),
                    v.getHeight(),
                    v.getWidth(),
                    v.getWeight()
            );
            vehicleDtoList.add(vehicleDto);
        }

        return vehicleDtoList;
    }

    //Exercise 1
    @Override
    public void addVehicle(VehicleDto vehicleDto){
        Vehicle vehicle = repository.findById(vehicleDto.getId());

        if(vehicle != null) {
            throw new IdDuplicateException("ERROR: EL ID "+ vehicleDto.getId()+" YA EXISTE EN LA BASE DE DATOS.");
        }
        Vehicle vehicle1 = mapper.vehicleDtoToVehicle(vehicleDto);
        repository.save(vehicle1);
    }

    //exercise 2
    @Override
    public List<VehicleDto> findByColorAndYear(String color, int year){
        List<Vehicle> vehicleList = repository.findAll().stream()
                .filter(a-> a.getColor().equals(color))
                .filter(b-> b.getYear() == year)
                .collect(Collectors.toList());

        if(vehicleList.isEmpty()){
            throw new NotFoundException("NO HAY VEHICULOS PARA MOSTRAR");
        }
        return mapper.vehicleListToVehicleDtoList(vehicleList);
    }

    //Exercise 3
    @Override
    public List<VehicleDto> findByBrandAndRangerYears(String brand, int starYear, int endYear){
        List<Vehicle> vehicleList = repository.findAll().stream()
                .filter(a->a.getBrand().equals(brand))
                .filter(b-> b.getYear() >= starYear)
                .filter(c-> c.getYear() <= endYear)
                .collect(Collectors.toList());

        if(vehicleList.isEmpty()){
            throw new NotFoundException("NO HAY COINCIDENCIAS");
        }

        return mapper.vehicleListToVehicleDtoList(vehicleList);
    }

    //Exercise 4
    @Override
    public Double calculateSpeedAverage(String brand){
        Double speedAverage = repository.findAll().stream()
                .filter(a -> a.getBrand().equals(brand))
                .mapToDouble(Vehicle::getMax_speed)
                .average()
                .orElse(0);

        if(speedAverage == 0){
            throw new NotFoundException("NO SE ENCONTRARON VEHICULOS DE ESA MARCA");
        }
        return speedAverage;
    }

    //Exercise 5
    @Override
    public void addSeveralVehicles(List<VehicleDto> vehicleDtoList){
        for(VehicleDto v: vehicleDtoList){
            addVehicle(v);
        }
    }

    //Exercise 6
    @Override
    public VehicleDto updateSpeed(long id, int speed){
        Vehicle vehicle = repository.findById(id);

        if(vehicle == null){
            throw new NotFoundException("NO SE ENCONTRO NINGUN VEHICULO");
        }
        vehicle.setMax_speed(speed);
        repository.save(vehicle);

        return mapper.vehicleToVehicleDto(vehicle);
    }

    //Exercise 7
    @Override
    public List<VehicleDto> findByTypeFuel(String type){
        List<Vehicle> vehicleList = repository.findAll().stream()
                .filter(a-> a.getFuel_type().equals(type))
                .collect(Collectors.toList());

        if(vehicleList.isEmpty()){
            throw new NotFoundException("NADA PARA MOSTRAR");
        }
        return  mapper.vehicleListToVehicleDtoList(vehicleList);
    }

    //Exercise 8
    @Override
    public void deleteVehicle(long id){
        Vehicle vehicle = repository.findById(id);
        if(vehicle == null){
            throw new NotFoundException("NO HAY COINCIDENCIAS");
        }
        repository.delete(vehicle);
    }

    //Exercise 9
    @Override
    public List<VehicleDto> findByTransmission(String type){
        List<Vehicle> vehicleList = repository.findAll().stream()
                .filter(a-> a.getTransmission().equals(type))
                .collect(Collectors.toList());

        if(vehicleList.isEmpty()){
            throw new NotFoundException("NO HAY COINCIDENCIAS");
        }
        return mapper.vehicleListToVehicleDtoList(vehicleList);
    }

    //Exercise 10
    @Override
    public VehicleDto updateFuel(long id, String type){
        Vehicle vehicle = repository.findById(id);

        if(vehicle == null){
            throw new NotFoundException("NO HAY COINCIDENCIAS");
        }
        vehicle.setFuel_type(type);
        repository.save(vehicle);

        return mapper.vehicleToVehicleDto(vehicle);
    }

    //Exercise 11
    public Double averagePeopleByBrand(String brand){
        Double average = repository.findAll().stream()
                .filter(a-> a.getBrand().equals(brand))
                .mapToDouble(b-> b.getPassengers())
                .average()
                .orElse(0);
        if(average == 0){
            throw new NotFoundException("NO HAY COINCIDENCIA DE LA MARCA: " + brand);
        }
        return average;
    }

    //Exercise 12
    public List<VehicleDto> findLengthAndWidth(String length, String width){
        String [] string1 = length.split("-");
        String [] string2 = width.split("-");

        Double lengthMin = Double.parseDouble(string1[0]);
        Double lengthMax = Double.parseDouble(string1[1]);

        Double widthMin = Double.parseDouble(string2[0]);
        Double widthMax = Double.parseDouble(string2[1]);

        List<Vehicle> vehicleList = repository.findAll().stream()
                .filter(a-> a.getHeight()>=lengthMin)
                .filter(b-> b.getHeight() <= lengthMax)
                .filter(c-> c.getWidth()>=widthMin)
                .filter(d-> d.getWidth()<= widthMax)
                .collect(Collectors.toList());

        if(vehicleList.isEmpty()){
            throw new NotFoundException("NO HAY COINCIDENCIA EN ESAS DIMENSIONES");
        }

        return mapper.vehicleListToVehicleDtoList(vehicleList);
    }

    //Exercise 13
    @Override
    public List<VehicleDto> findRangeByWeigth(Double min, Double max){
        List<Vehicle> vehicleList = repository.findAll().stream()
                .filter(a-> a.getWeight() >= min)
                .filter(b-> b.getWeight() <= max)
                .collect(Collectors.toList());

        if(vehicleList.isEmpty()){
            throw new NotFoundException("NADA PARA MOSTRAR");
        }

        return  mapper.vehicleListToVehicleDtoList(vehicleList);
    }
}
