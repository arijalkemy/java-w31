package com.mercadolibre.showroom.dto.response;

import com.mercadolibre.showroom.dto.request.PrendaDetalleRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VentaResponseDto {
    private Long id;
    private String numero;
    private LocalDate fecha;
    private double total;
    private String medioDePago;
    private List<PrendaDetalleRequestDto> prendas;
}
