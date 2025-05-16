package com.bootcamp.joyerialasperlas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 50)
    @NotNull(message = "El nombre no puede ser nulo")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String nombre;

    @Column(length = 20)
    @NotNull(message = "El material no puede ser nulo")
    @Size(min = 2, max = 20, message = "El material debe tener entre 2 y 20 caracteres")
    private String material;

    @NotNull(message = "El peso no puede ser nulo")
    @PositiveOrZero(message = "El peso debe ser mayor o igual a cero")
    private Double peso;

    @Column(length = 100)
    @NotNull(message = "La particularidad no puede ser nula")
    @Size(min = 2, max = 100, message = "La particularidad debe tener entre 2 y 100 caracteres")
    private String particularidad;
    
    private Boolean poseePiedra;
    private Boolean ventaONo;
}
