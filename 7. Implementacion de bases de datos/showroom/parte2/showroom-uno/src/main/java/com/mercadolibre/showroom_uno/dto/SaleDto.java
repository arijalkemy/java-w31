package com.mercadolibre.showroom_uno.dto;

import com.mercadolibre.showroom_uno.model.SaleClothe;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;
import java.util.List;
@Getter @Setter
public class SaleDto {
    private Long id;
    private LocalDate fecha;
    private Double total;
    private String medioDePago;
    private List<SaleClothe> saleClothes;
}
