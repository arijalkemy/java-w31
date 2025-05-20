package org.mercadolibre.showroom.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sales")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "sale_number")
    private int numero;

    @Column(name = "sale_date")
    private LocalDate fecha;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_method_id", referencedColumnName = "id")
    private MedioPago medioPago;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "clothes_id")
    private Set<Prenda> prendaList;
}
