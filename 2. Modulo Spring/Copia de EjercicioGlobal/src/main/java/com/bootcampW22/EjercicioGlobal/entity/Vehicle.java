package com.bootcampW22.EjercicioGlobal.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    private Long id;
    private String brand;
    private String model;
    private String registration;
    private String color;
    private int year;
    private int max_speed;
    private int passengers;
    private String fuel_type;
    private String transmission;
    private double height;
    private double width;
    private double weight;
}
