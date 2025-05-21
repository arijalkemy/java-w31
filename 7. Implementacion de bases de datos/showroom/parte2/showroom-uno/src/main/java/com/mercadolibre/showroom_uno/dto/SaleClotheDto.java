package com.mercadolibre.showroom_uno.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
public class SaleClotheDto {
    private LocalDate fecha;
    private Double total;
    private Integer cantidad;
    List<ClotheDto> clotheDtoList;
}
