package com.bootcampW22.EjercicioGlobal.Mapper;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IMapper {
    public VehicleDto vehicleToVehicleDto(Vehicle v);
    public Vehicle vehicleDtoToVehicle(VehicleDto v);

    public List<VehicleDto> vehicleListToVehicleDtoList(List<Vehicle> v);
    public List<Vehicle> vehicleDtoListToVehicleList(List<VehicleDto> v);

}
