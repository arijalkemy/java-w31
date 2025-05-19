package com.mercadolibre.clave.compuesta.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class CompraClienteId {

    @Column(name = "cliente_id")
    private Long clientId;

    @Column(name = "date")
    private LocalDate date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompraClienteId that = (CompraClienteId) o;
        return Objects.equals(clientId, that.clientId) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, date);
    }

}
