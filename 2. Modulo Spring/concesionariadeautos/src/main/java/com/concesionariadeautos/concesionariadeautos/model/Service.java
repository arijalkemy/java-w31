package com.concesionariadeautos.concesionariadeautos.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Service {
    private Date date;
    private String descriptions, kilometers;
}
