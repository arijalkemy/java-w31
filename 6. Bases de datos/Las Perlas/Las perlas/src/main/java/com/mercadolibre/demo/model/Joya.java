package com.mercadolibre.demo.model;

import com.mercadolibre.demo.utils.Material;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "joyas")
public class Joya {
    /*Para ello, de cada joya se registran los siguientes datos:
    nro_identificatorio, nombre, material (oro, plata, etc), peso (en gramos),
     particularidad, posee_piedra, ventaONo.
     */
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "nro_identificatorio")
    private Long id;

    @Column (name = "nombre")
    private String name;


    @Enumerated(EnumType.STRING)
    @Column(name = "material")
    private Material material;

    @Column (name = "peso_en_gramos")
    private Double pesoEnGramos;

    @Column (name = "particularidad")
    private String particularidad;

    @Column (name = "posee_piedras")
    private Boolean poseePiedra;

    @Column (name = "venta_o_no")
    private Boolean ventaONo;

}
