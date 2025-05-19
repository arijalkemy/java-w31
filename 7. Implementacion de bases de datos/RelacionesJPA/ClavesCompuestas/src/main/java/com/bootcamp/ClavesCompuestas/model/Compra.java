package com.bootcamp.ClavesCompuestas.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@IdClass(CompraPK.class)
public class Compra {

    @Id
    @Column(name = "cliente_id")
    private Long idCliente;
    
    @Id
    @Column(name = "compra_fecha")
    private Date fecha;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "compra_producto",
        joinColumns = {
            @JoinColumn(name = "cliente_id", referencedColumnName = "cliente_id"),
            @JoinColumn(name = "compra_fecha", referencedColumnName = "fecha")
        },
        inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    private List<Producto> productos;
}