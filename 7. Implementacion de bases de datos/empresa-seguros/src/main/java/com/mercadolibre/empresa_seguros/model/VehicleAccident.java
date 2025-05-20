package com.mercadolibre.empresa_seguros.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
public class VehicleAccident {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Temporal(TemporalType.DATE)
    private LocalDate accidentDate;
    private Double moneyLost;
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle reportedVehicle;
}
