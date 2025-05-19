package com.mercadolibre.hql.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patent;

    private String brand;

    private String model;

    private Integer manufacturingYear;

    private Integer wheelCount;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_id")
    List<Accident> accidents;


}
