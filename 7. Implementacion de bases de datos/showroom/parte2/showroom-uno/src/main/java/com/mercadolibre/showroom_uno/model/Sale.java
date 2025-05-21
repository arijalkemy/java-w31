package com.mercadolibre.showroom_uno.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "numero")
    private Long id;

    private LocalDate fecha;
    private Double total;
    @Column(name = "medio_de_pago")
    private String medioDePago;
    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<SaleClothe> saleClothes;
}
