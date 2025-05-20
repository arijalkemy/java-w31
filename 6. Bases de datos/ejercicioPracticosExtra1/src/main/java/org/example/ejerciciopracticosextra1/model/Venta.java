package org.example.ejerciciopracticosextra1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ventas")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "numero")
    private Long numero;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "total")
    private Double total;

    @Enumerated(EnumType.STRING)
    @Column(name = "medio_pago")
    private MedioPago medioPago;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_prenda")
    private List<Prenda> prendas;

    private enum MedioPago{EFECTIVO,TARJETA_CREDITO,TARJETA_DEBITO,BITCOIN}
}
