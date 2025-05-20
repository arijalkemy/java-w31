package com.mercadolibre.showroom.dto;

import com.mercadolibre.showroom.model.ClothingItem;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

    private Long number;

    private LocalDate date;           // Fecha de la venta

    private Double total;             // Total de la venta

    private String paymentMethod;     // Medio de pago

    private List<ClothingItemDto> clothingItems =  new ArrayList<>();
}
