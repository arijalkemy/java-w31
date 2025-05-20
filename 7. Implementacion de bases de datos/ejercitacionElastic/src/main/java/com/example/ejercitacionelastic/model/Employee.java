package com.example.ejercitacionelastic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "employee")
@Data
@AllArgsConstructor
public class Employee {
    @Id
    private String id;

    private String name;
    private String surname;
    private int age;
    private String city;
    private String state;
}
