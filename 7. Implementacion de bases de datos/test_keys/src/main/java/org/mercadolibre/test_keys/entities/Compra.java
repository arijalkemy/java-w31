package org.mercadolibre.test_keys.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@Entity
@Table(name = "compras")
@IdClass(value = CompraKey.class)
public class Compra {
    @Id
    private Long clientId;

    @Id
    private LocalDate fecha;
}
