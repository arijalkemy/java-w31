package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.Mapper.IMapper;
import com.bootcampW22.EjercicioGlobal.dto.UpdateFuelDto;
import com.bootcampW22.EjercicioGlobal.dto.UpdateSpeedDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.ExceptionIdDuplicate;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
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
            VehicleDto vehicleDto = mapper.vehicleToVehicleDto(v);
            vehicleDtoList.add(vehicleDto);
        }

        return vehicleDtoList;
    }

    //Ejercicio 1

    public void addVehicle(VehicleDto v){
        //Consulto si el Id existe
        if(repository.findAll().stream().anyMatch(a-> a.getId().equals(v.getId()))){
            throw new ExceptionIdDuplicate("EL ID YA EXISTE EN LA BD");
        }
        //Lo mapeo a vehicle
        Vehicle vehicle = mapper.vehicleDtoToVehicle(v);
        //Lo guardo
        repository.save(vehicle);
    }

    //Ejercicio 2

    public List<VehicleDto> searchColorAndYear(String color, int year){
        List<Vehicle> vehicleList = repository.findAll().stream()
                .filter(a-> a.getColor().equals(color))
                .filter(b-> b.getYear() == year)
                .collect(Collectors.toList());

        //Chequeo que no sea vacia
        if(vehicleList.isEmpty())
        {
            throw new NotFoundException("LISTA VACIA. NO HAY NADA PARA MOSTRAR");
        }
        List<VehicleDto> vehicleDtoList = new ArrayList<>();
        for(Vehicle v : vehicleList){
            vehicleDtoList.add(mapper.vehicleToVehicleDto(v));
        }

        return vehicleDtoList;
    }

    //Ejercicio 3
    public List<VehicleDto> getVehicleBrandAndYears(String marca, int since, int to){
        //Filtrar
        List<Vehicle> vehicleList = repository.findAll().stream()
                .filter(a-> a.getBrand().equals(marca))
                .filter(b-> b.getYear()>= since)
                .filter(c -> c.getYear() <= to)
                .collect(Collectors.toList());
        //Chequear que no sea vacia la lista
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontraron vehiculos de marca: " + marca +
                    "que coincidan entre los años "+ since + " y "+to);
        }

        List<VehicleDto> vehicleDtoList = new ArrayList<>();

        //Mappear iterando
        for(Vehicle v: vehicleList){
            vehicleDtoList.add(mapper.vehicleToVehicleDto(v));
        }

        //Retornar Lista TDo
        return vehicleDtoList;
    }

    //Ejercicio 4
    public Double getVelocidadPromedio(String marca){
        Double promedio = repository.findAll().stream()
                .filter(a-> a.getBrand().equals(marca))
                .mapToDouble(Vehicle::getMax_speed)
                .average()
                .orElse(0);
        if(promedio == 0){
            throw new NotFoundException("No se encontro vehiculos de marca: "+ marca + "" +
                    " para promediar velocidad");
        }

        return promedio;

    }

    //Ejercicio 5
    public void addListVehicle(List<VehicleDto> vehicleDtoList){
        if(vehicleDtoList.isEmpty()){
            throw new NotFoundException("Lista vacia");
        }
        for(VehicleDto v: vehicleDtoList){
            addVehicle(v);
        }
    }

    //Ejercicio 6
    public void updateSpeed(int id, UpdateSpeedDto updateSpeedDto){
        Vehicle vehicle = repository.findAll().stream()
                .filter(a-> a.getId() == id)
                .findFirst()
                .orElse(null);

        if(vehicle == null)
        {
            throw new NotFoundException("El id: "+ id + " no corresponde a ningun vehiculo en la bd");
        }

        vehicle.setMax_speed(updateSpeedDto.getNewSpeed());
        repository.save(vehicle);
    }

    public List<VehicleDto> findTypeFuel(String fuel){
        List<Vehicle> vehicleList = repository.findAll().stream()
                .filter(a-> a.getFuel_type().equals(fuel))
                .collect(Collectors.toList());

        if(vehicleList.isEmpty()){
            throw new NotFoundException("Lista vacia");
        }

        return mapper.vehicleListToVehicleDtoList(vehicleList);

    }

    public void deleteVehicle(int id){
        Vehicle vehicle = repository.findById(id);
        if(vehicle == null) {
            throw new NotFoundException("No se encontro el vehiculo");
        }
        repository.findAll().remove(vehicle);
    }

    //Ejercicio 9
    public List<VehicleDto> findTransmission(String transmission){
        List<Vehicle> vehicleList = repository.findAll().stream()
                .filter(a-> a.getTransmission().equals(transmission))
                .collect(Collectors.toList());
        if(vehicleList.isEmpty()){
            throw new NotFoundException("Lista vacia");
        }
        return mapper.vehicleListToVehicleDtoList(vehicleList);
    }

    //Ejercicio 10
    public void updateFuel(int id, UpdateFuelDto updateFuel){
        Vehicle vehicle = repository.findById(id);
        if(vehicle == null){
            throw new NotFoundException("Vehiculo no encontrado");
        }
        vehicle.setFuel_type(updateFuel.getNewFuel());
        repository.save(vehicle);
    }

    //Ejercicio 11
    public Double promedioCountPersonas(String marca){
        Double promedio = repository.findAll().stream()
                .filter(a-> a.getBrand().equals(marca))
                .mapToDouble(b->b.getPassengers())
                .average()
                .orElse(0);
        if(promedio == 0){
            throw new NotFoundException("No hay vehiculos para promediar");
        }
        return promedio;
    }

    //Ejercicio 12
    public List<VehicleDto> findDimenciones (String lenght, String width){
        //Hago un split para optener los campos
        String [] cadena1 = lenght.split("-");
        String [] cadena2 = width.split("-");

        Double lengthMin = Double.parseDouble(cadena1[0]);
        Double lengthMax = Double.parseDouble(cadena1[1]);

        Double widthMin = Double.parseDouble(cadena2[0]);
        Double widthMax = Double.parseDouble(cadena2[1]);

        List<Vehicle> vehicleList = repository.findAll().stream()
                .filter(a-> a.getHeight() >= lengthMin)
                .filter(b-> b.getHeight() <= lengthMax)
                .filter(c-> c.getWidth() >= widthMin)
                .filter(d-> d.getWidth() <= widthMax)
                .collect(Collectors.toList());

        if(vehicleList.isEmpty()){
            throw  new NotFoundException("No hay coincidencias");
        }

        return mapper.vehicleListToVehicleDtoList(vehicleList);
    }

    //Ejercicio 13
    public List<VehicleDto> findByWeigth(Double weigthMin, Double weigthMax){
        List<Vehicle> vehicleList = repository.findAll().stream()
                .filter(a-> a.getWeight()>= weigthMin)
                .filter(b-> b.getWeight() <= weigthMax)
                .collect(Collectors.toList());
        if(vehicleList.isEmpty()){
            throw new NotFoundException("Lista vacia");
        }

        return mapper.vehicleListToVehicleDtoList(vehicleList);
    }

}
