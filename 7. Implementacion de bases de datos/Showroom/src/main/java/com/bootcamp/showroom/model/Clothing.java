package com.bootcamp.showroom.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;

@Entity
@Table(name="clothing")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clothing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String code;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String size;
    private int quantity;
    private double salePrice;

    public Clothing(String code, String name, String type, String brand, String color, String size, int quantity, double salePrice) {
        this.code=code;
        this.name=name;
        this.type=type;
        this.brand=brand;
        this.color=color;
        this.size=size;
        this.quantity=quantity;
        this.salePrice=salePrice;
    }
}
