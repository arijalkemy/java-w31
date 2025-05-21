package com.mercadolibre.showroom_uno.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "sale_clothes")
public class SaleClothe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;
    @ManyToOne
    @JoinColumn(name = "clothe_id")
    private Clothe clothe;
    private Integer cantidad;
    private Double precioUnitario;
}