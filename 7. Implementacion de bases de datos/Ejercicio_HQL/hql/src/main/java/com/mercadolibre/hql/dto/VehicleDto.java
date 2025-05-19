package com.mercadolibre.hql.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class VehicleDto {

    private Long id;

    private String patent;

    private String brand;

    private String model;

    private Integer manufacturingYear;

    private Integer wheelCount;

    List<AccidentDto> accidents;

}
