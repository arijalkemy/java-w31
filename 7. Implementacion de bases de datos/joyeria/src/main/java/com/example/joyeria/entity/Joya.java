package com.example.joyeria.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "joyas")
public class Joya {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nro_identificatorio;

    @Column(name = "name")
    private String nombre;

    @Column(name = "material")
    private String material;

    @Column(name = "weight")
    private double peso;

    @Column(name = "details")
    private String particularidad;

    @Column(name = "has_valuable_stones")
    private boolean poseePiedra = Boolean.FALSE;

    @Column(name = "sellOrNot")
    private boolean ventaONo = Boolean.TRUE;
}
