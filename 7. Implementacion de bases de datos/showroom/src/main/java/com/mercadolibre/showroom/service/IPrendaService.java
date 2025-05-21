package com.mercadolibre.showroom.service;

import com.mercadolibre.showroom.dto.request.PrendaRequestDto;
import com.mercadolibre.showroom.dto.response.PrendaResponseDto;
import com.mercadolibre.showroom.model.Prenda;

import java.util.List;

public interface IPrendaService {
    public PrendaResponseDto addPrenda(PrendaRequestDto prendaRequest);
    public List<PrendaResponseDto> getAll();
    public PrendaResponseDto getByCodigo(String codigo);
    public PrendaResponseDto updatePrenda(String codigo, PrendaRequestDto prendaRequest);
    public void deleteByCodigo(String codigo);
    public List<PrendaResponseDto> getAllByTalle(String talle);

    List<PrendaResponseDto> getByExistNombre(String nombre);

    Prenda findByCodigo(String codigo);
}
