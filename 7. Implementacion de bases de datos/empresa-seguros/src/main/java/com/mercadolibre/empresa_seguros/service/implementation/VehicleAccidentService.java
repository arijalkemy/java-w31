package com.mercadolibre.empresa_seguros.service.implementation;

import com.mercadolibre.empresa_seguros.dto.request.VehicleAccidentDto;
import com.mercadolibre.empresa_seguros.dto.request.VehicleDto;
import com.mercadolibre.empresa_seguros.exception.BadRequest;
import com.mercadolibre.empresa_seguros.model.VehicleAccident;
import com.mercadolibre.empresa_seguros.repository.VehicleAccidentRepository;
import com.mercadolibre.empresa_seguros.service.IVehicleAccidentService;
import com.mercadolibre.empresa_seguros.service.IVehicleService;
import com.mercadolibre.empresa_seguros.utils.GlobalMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VehicleAccidentService implements IVehicleAccidentService {
    private final VehicleAccidentRepository vehicleAccidentRepository;
    private final IVehicleService vehicleService;

    @Override
    public VehicleAccidentDto addVehicleAccident(VehicleAccidentDto vehicleAccidentDto){
        VehicleAccident vehicleAccident = GlobalMapper.dtoToEntityAccident(vehicleAccidentDto);
        if(existByDateAndVehicle(vehicleAccident)){
            throw new BadRequest("Already exist an accident with that data");
        }

        VehicleDto vehicleDto = vehicleService.findById(vehicleAccident.getReportedVehicle().getId());
        vehicleAccident.setReportedVehicle(GlobalMapper.dtoToEntityVehicle(vehicleDto));

        vehicleAccidentRepository.save(vehicleAccident);
        return GlobalMapper.entityToDtoAccident(vehicleAccident);
    }

    @Override
    public List<VehicleAccidentDto> getAll(){
        List<VehicleAccident> vehicleAccidentList = vehicleAccidentRepository.findAll();
        if(vehicleAccidentList.isEmpty()){
            throw new BadRequest("No vehicles accident found");
        }
        return GlobalMapper.entityToDtoListAcc(vehicleAccidentList);
    }


    private boolean existByDateAndVehicle(VehicleAccident vehicleAccident){
        return vehicleAccidentRepository.existsByAccidentDateAndReportedVehicle(
                vehicleAccident.getAccidentDate(), vehicleAccident.getReportedVehicle());
    }


}
