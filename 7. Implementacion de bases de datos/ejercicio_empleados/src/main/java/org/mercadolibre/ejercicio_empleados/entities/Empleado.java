package org.mercadolibre.ejercicio_empleados.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "employee")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Empleado {
    @Id
    private String id;

    private String name;

    private String lastName;

    private int edad;

    private String ciudad;

    private String provincia;
}
