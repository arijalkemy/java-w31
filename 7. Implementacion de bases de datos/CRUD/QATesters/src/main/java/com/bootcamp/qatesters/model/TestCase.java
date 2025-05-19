package com.bootcamp.qatesters.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idCase;

    @Column(length = 100)
    @NotNull(message = "La descripción no puede ser nula")
    @Size(min = 2, max = 100, message = "La descripción debe tener entre 2 y 100 caracteres")
    private String description;

    @NotNull(message = "El número de intentos no puede ser nulo")
    @PositiveOrZero(message = "El número de intentos debe ser mayor o igual a cero")
    private Integer numberOfTries;
    
    private Boolean tested;
    private Boolean passed;
    Date lastUpdate;
}
