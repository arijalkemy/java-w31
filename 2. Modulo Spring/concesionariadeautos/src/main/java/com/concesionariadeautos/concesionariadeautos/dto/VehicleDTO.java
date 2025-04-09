package com.concesionariadeautos.concesionariadeautos.dto;

import com.concesionariadeautos.concesionariadeautos.model.Service;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class VehicleDTO implements Serializable {
    private Long id;
    private String brand, model,currency,numberOfKilometers,doors, countOfOwner,price;
    private Date manufacturingDate;
    private List<Service> services;
}
