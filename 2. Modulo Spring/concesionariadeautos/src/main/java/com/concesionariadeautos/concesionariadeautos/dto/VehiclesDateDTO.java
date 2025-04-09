package com.concesionariadeautos.concesionariadeautos.dto;

import com.concesionariadeautos.concesionariadeautos.model.Service;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class VehiclesDateDTO implements Serializable {
    private Long id;
    private String brand, model;
    private Date manufacturingDate;
}
