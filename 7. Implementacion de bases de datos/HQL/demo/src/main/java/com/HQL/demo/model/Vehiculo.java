package com.HQL.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Setter @Getter @Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "vehiculos")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idVehiculo;

    private String patente, marca, modelo;
    private LocalDate anioFabricación;
    private Integer cantidadRuedad;

    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL)
    private List<Siniestro> siniestroList = new ArrayList<>();

}
