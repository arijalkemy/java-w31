package com.mercadolibre.concesionariaauto.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceFromVehicle {
    String date;
    String kilometers;
    String descriptions;
}
