package com.example.joyerialasperlas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Joya {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    @JsonIgnore
    private Long id;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    private Boolean poseePidra;
    private Boolean ventaONo;
}
