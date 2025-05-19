package com.bootcamp.ClavesCompuestas.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
public class CompraPK implements Serializable {

    @Column(name = "cliente_id")
    private Long idCliente;

    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompraPK)) return false;
        CompraPK that = (CompraPK) o;
        return Objects.equals(getIdCliente(), that.getIdCliente()) &&
               Objects.equals(getFecha(), that.getFecha());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdCliente(), getFecha());
    }
}