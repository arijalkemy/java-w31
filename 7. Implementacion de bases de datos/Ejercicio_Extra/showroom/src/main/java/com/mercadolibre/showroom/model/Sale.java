package com.mercadolibre.showroom.model;


import com.mercadolibre.showroom.dto.ClothingItemDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;

    private LocalDate date;           // Fecha de la venta

    private Double total;             // Total de la venta

    private String paymentMethod;     // Medio de pago

    @ManyToMany()
    @JoinTable(
            name = "sale_clothing_items",
            joinColumns = @JoinColumn(name = "sale_number"),
            inverseJoinColumns = @JoinColumn(name = "clothing_item_id")
    )
    private List<ClothingItem> clothingItems = new ArrayList<>();;

}
