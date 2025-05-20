package com.mercadolibre.empresa_seguros.service.implementation;

import com.mercadolibre.empresa_seguros.dto.request.VehicleDto;
import com.mercadolibre.empresa_seguros.dto.response.VehiclePatentAndBrandDto;
import com.mercadolibre.empresa_seguros.dto.response.VehicleResponseDto;
import com.mercadolibre.empresa_seguros.exception.BadRequest;
import com.mercadolibre.empresa_seguros.model.Vehicle;
import com.mercadolibre.empresa_seguros.repository.VehicleRepository;
import com.mercadolibre.empresa_seguros.service.IVehicleService;
import com.mercadolibre.empresa_seguros.utils.GlobalMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class VehicleService implements IVehicleService {
    private final VehicleRepository vehicleRepository;

    @Override
    public VehicleDto addVehicle(VehicleDto vehicleDto){
        if((existByPatent(vehicleDto))){
            throw new BadRequest("Already exist a vehicle with patent number: " + vehicleDto.getPatentNumber());
        }

        Vehicle vehicle = GlobalMapper.dtoToEntityVehicle(vehicleDto);
        vehicleRepository.save(vehicle);

        return GlobalMapper.entityToDtoVehicle(vehicle);
    }

    @Override
    public List<VehicleDto> getAll(){
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new BadRequest("No vehicles found");
        }

        return GlobalMapper.entityToDtoListVeh(vehicleList);
    }

    @Override
    public VehicleDto findById(Long id){
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(()->new BadRequest("No vehicle found with that id"));
        return GlobalMapper.entityToDtoVehicle(vehicle);
    }

    @Override
    public List<String> getQuery(){
        return vehicleRepository.findAllPatentNumbers();
    }


    private boolean existByPatent(VehicleDto vehicleDto){
        return vehicleRepository.existsByPatentNumber(vehicleDto.getPatentNumber());
    }

}
