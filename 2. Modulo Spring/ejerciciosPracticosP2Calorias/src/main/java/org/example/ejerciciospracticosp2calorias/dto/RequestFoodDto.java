package org.example.ejerciciospracticosp2calorias.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class RequestFoodDto implements Serializable {
    private String name;
    private Double weight;
}
