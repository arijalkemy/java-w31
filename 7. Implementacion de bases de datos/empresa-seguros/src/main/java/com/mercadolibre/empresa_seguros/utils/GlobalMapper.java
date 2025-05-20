package com.mercadolibre.empresa_seguros.utils;

import com.mercadolibre.empresa_seguros.dto.request.VehicleAccidentDto;
import com.mercadolibre.empresa_seguros.dto.request.VehicleDto;
import com.mercadolibre.empresa_seguros.dto.response.VehicleAccidenteResponseDto;
import com.mercadolibre.empresa_seguros.dto.response.VehicleResponseDto;
import com.mercadolibre.empresa_seguros.model.Vehicle;
import com.mercadolibre.empresa_seguros.model.VehicleAccident;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class GlobalMapper {
    public static VehicleAccidentDto entityToDtoAccident(VehicleAccident vehicleAccident){
        return new VehicleAccidentDto(
                vehicleAccident.getId(),
                vehicleAccident.getAccidentDate(),
                vehicleAccident.getMoneyLost(),
                GlobalMapper.vehicleToResponseDto(vehicleAccident.getReportedVehicle()));
    }

    public static VehicleAccident dtoToEntityAccident(VehicleAccidentDto vehicleAccidentDto){
        return new VehicleAccident(
                vehicleAccidentDto.getId(),
                vehicleAccidentDto.getAccidentDate(),
                vehicleAccidentDto.getMoneyLost(),
                GlobalMapper.vehicleResponseDtoToEntity(vehicleAccidentDto.getReportedVehicle()));
    }

    public static List<VehicleAccidentDto> entityToDtoListAcc(List<VehicleAccident> vehicleAccidents){
        return vehicleAccidents.stream().map(GlobalMapper::entityToDtoAccident).toList();
    }

    public static VehicleDto entityToDtoVehicle(Vehicle vehicle) {
        List<VehicleAccidenteResponseDto> accidentsDto = new ArrayList<>();

        if (vehicle.getReportedAccidents() != null) {
            for (VehicleAccident accident : vehicle.getReportedAccidents()) {
                accidentsDto.add(entityToDtoAccidenteResponse(accident));
            }
        }

        return new VehicleDto(
                vehicle.getId(),
                vehicle.getPatentNumber(),
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getMadeDate(),
                vehicle.getWheelsQuantity(),
                accidentsDto
        );
    }

    private static VehicleAccidenteResponseDto entityToDtoAccidenteResponse(VehicleAccident accident) {
        return new VehicleAccidenteResponseDto(
                accident.getAccidentDate(),
                accident.getMoneyLost()
        );
    }

    public static Vehicle dtoToEntityVehicle(VehicleDto vehicleDto) {
        List<VehicleAccident> accidents = new ArrayList<>();

        if (vehicleDto.getReportedAccidents() != null) {
            for (VehicleAccidenteResponseDto accidentDto : vehicleDto.getReportedAccidents()) {
                VehicleAccident accident = new VehicleAccident();
                accident.setAccidentDate(accidentDto.getAccidentDate());
                accident.setMoneyLost(accidentDto.getMoneyLost());
                accident.setReportedVehicle(null);
                accidents.add(accident);
            }
        }

        Vehicle vehicle = new Vehicle();
        vehicle.setId(vehicleDto.getId());
        vehicle.setPatentNumber(vehicleDto.getPatentNumber());
        vehicle.setBrand(vehicleDto.getBrand());
        vehicle.setModel(vehicleDto.getModel());
        vehicle.setMadeDate(vehicleDto.getMadeDate());
        vehicle.setWheelsQuantity(vehicleDto.getWheelsQuantity());
        vehicle.setReportedAccidents(accidents);

        for (VehicleAccident accident : accidents) {
            accident.setReportedVehicle(vehicle);
        }

        return vehicle;
    }

    public static List<VehicleDto> entityToDtoListVeh(List<Vehicle> vehicleList){
        return vehicleList.stream().map(GlobalMapper::entityToDtoVehicle).toList();
    }

    public VehicleResponseDto vehicleToResponseDto(Vehicle vehicle){
        VehicleResponseDto vehicleResponseDto = new VehicleResponseDto();
        vehicleResponseDto.setId(vehicle.getId());
        vehicleResponseDto.setModel(vehicle.getModel());
        vehicleResponseDto.setBrand(vehicle.getBrand());
        vehicleResponseDto.setPatentNumber(vehicle.getPatentNumber());
        return vehicleResponseDto;
    }

    public static Vehicle vehicleResponseDtoToEntity(VehicleResponseDto dto) {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(dto.getId());
        vehicle.setPatentNumber(dto.getPatentNumber());
        vehicle.setBrand(dto.getBrand());
        vehicle.setModel(dto.getModel());
        return vehicle;
    }



}
