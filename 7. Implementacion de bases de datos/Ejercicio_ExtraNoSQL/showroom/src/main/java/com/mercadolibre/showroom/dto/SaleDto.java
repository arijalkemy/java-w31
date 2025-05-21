package com.mercadolibre.showroom.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleDto {

    private String number;

    private LocalDate date;           // Fecha de la venta

    private Double total;             // Total de la venta

    private String paymentMethod;     // Medio de pago

    private List<ClothingItemDto> clothingItems =  new ArrayList<>();
}
