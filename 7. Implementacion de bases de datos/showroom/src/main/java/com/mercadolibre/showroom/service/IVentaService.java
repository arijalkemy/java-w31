package com.mercadolibre.showroom.service;

import com.mercadolibre.showroom.dto.request.VentaRequestDto;
import com.mercadolibre.showroom.dto.response.PrendaResponseDto;
import com.mercadolibre.showroom.dto.response.VentaResponseDto;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {
    public VentaResponseDto addVenta(VentaRequestDto ventaRequest);
    public List<VentaResponseDto> getAllVentas();
    public VentaResponseDto getByNumero(String numero);
    public VentaResponseDto updateVenta(String numero, VentaRequestDto ventaRequest);
    public void deleteVenta(String numero);
    public List<VentaResponseDto> getByDate(LocalDate fecha);
    public List<PrendaResponseDto> findPrendaFromVenta(String nombre);
}
