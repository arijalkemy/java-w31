package com.mercadolibre.miniseries.service;

import com.mercadolibre.miniseries.dto.VehicleDto;
import com.mercadolibre.miniseries.repository.IRepository;
import com.mercadolibre.miniseries.util.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VehicleServiceImpl implements IVehicleService{
    private IRepository iRepository;

    public VehicleServiceImpl(IRepository iRepository) {
        this.iRepository = iRepository;
    }

    @Override
    public List<String> getAll() {
        return iRepository.getAll();
    }

    @Override
    public List<VehicleDto> getAllOrder() {
        return iRepository.getAllOrdered().stream().map(Mapper::toDto).toList();
    }

    @Override
    public List<VehicleDto> getByYear() {
        return iRepository.getAllByAnoFabricacionAndNumRuedasGreaterThan(2025L,4).stream().map(Mapper::toDto).toList();
    }

    @Override
    public List<VehicleDto> getSinister() {
        return iRepository.getSinister().stream().map(Mapper::toDto).toList();
    }
}
