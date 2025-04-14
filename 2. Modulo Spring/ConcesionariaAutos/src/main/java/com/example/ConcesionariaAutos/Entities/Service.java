package com.example.ConcesionariaAutos.Entities;

import java.time.LocalDate;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Service {
    private LocalDate date;
    private String descriptions;
    private Integer kilometers;

    public Service() {
    }

    public Service(LocalDate date, String descriptions, Integer kilometers) {
        this.date = date;
        this.descriptions = descriptions;
        this.kilometers = kilometers;
    }
}
