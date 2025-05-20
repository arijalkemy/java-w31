package com.bootcamp.vehiculos.model;

import java.util.Date;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 10, nullable = false)
    @NotNull(message = "La patente del vehículo no puede ser nula.")
    @Size(min = 2, max = 10, message = "La patente debe tener entre 2 y 10 caracteres.")
    private String patente;

    @Column(length = 50, nullable = false)
    @NotNull(message = "La marca del vehículo no puede ser nula.")
    @Size(min = 2, max = 50, message = "La marca debe tener entre 2 y 50 caracteres.")
    private String marca;

    @Column(length = 50, nullable = false)
    @NotNull(message = "El modelo del vehículo no puede ser nulo.")
    @Size(min = 2, max = 50, message = "El modelo debe tener entre 2 y 50 caracteres.")
    private String modelo;

    @Column(name = "fecha_fabricacion", nullable = false)
    private Date fechaFabricacion;

    @PositiveOrZero
    @Column(name = "cantidad_de_ruedas", nullable = false)
    private Integer cantidadDeRuedas;
}
