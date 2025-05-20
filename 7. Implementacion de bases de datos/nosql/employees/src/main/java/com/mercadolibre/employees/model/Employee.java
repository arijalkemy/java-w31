package com.mercadolibre.employees.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "employees")
@Getter @Setter
public class Employee {

    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String city;
    private String state;
}
