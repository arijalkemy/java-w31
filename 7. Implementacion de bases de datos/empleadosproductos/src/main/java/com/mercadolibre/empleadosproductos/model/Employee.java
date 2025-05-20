package com.mercadolibre.empleadosproductos.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(indexName = "employees")
public class Employee {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String city;
    private String state;
}

