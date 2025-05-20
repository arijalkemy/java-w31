package com.bootcamp.vehiculos.model;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "fecha", nullable = false)
    @NotNull(message = "La fecha del siniestro no puede ser nula.")
    private Date fecha;

    @Column(name = "perdida_economica", nullable = false)
    private Integer perdidaEconomica;

    @ManyToOne
    @JoinColumn(name = "vehiculo_denunciado_id", referencedColumnName = "id")
    private Vehicle vehiculoDenunciado;
}
