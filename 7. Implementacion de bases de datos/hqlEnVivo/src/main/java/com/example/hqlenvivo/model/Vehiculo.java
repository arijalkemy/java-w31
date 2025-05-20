package com.example.hqlenvivo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;

    private String patente;
    private String brand;
    private String model;
    private String year;
    private Integer wheels;
}
