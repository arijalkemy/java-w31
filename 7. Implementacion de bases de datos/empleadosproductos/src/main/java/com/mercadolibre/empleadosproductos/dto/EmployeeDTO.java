package com.mercadolibre.empleadosproductos.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDTO {
    private String firstName;
    private String lastName;
    private Integer age;
    private String city;
    private String state;
}

