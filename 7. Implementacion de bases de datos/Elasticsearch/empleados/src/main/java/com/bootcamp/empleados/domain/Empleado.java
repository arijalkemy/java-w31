package com.bootcamp.empleados.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(indexName = "empleado")
public class Empleado {
     @Id
     private String id;

     private String nombre;
     private String apellido;
     private Integer edad;
     private String ciudad;
     private String provincia;
}
