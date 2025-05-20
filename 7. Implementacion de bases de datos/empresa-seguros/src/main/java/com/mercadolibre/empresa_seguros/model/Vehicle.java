package com.mercadolibre.empresa_seguros.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String patentNumber;
    private String brand;
    private String model;
    @Temporal(TemporalType.DATE)
    private LocalDate madeDate;
    private Integer wheelsQuantity;
    @OneToMany(mappedBy = "reportedVehicle")
    private List<VehicleAccident> reportedAccidents;
}
