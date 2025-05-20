package com.bootcamp.showroom.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sales")
@Data
@NoArgsConstructor
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;
    private LocalDate date;
    private Double total;
    private String paymentMethod;

    @OneToMany
    private List<Clothing> clothesList = new ArrayList<>();


    public Sale(String number, LocalDate date, Double total, String paymentMethod, List<Clothing> clothes) {
        this.number = number;
        this.date = date;
        this.total = total;
        this.paymentMethod = paymentMethod;
        this.clothesList = clothes;
    }

}
