package co.com.mercadolibre.practicaconsultashql.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String patente, marca, modelo;
    private Date anioDeFabricacion;
    private int cantidadDeRuedas;

    @OneToMany(mappedBy = "vehiculo", fetch = FetchType.LAZY)
    private Set<Siniestro> siniestros;
}
