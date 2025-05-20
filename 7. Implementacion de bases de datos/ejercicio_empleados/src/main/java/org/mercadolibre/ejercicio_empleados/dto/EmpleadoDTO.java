package org.mercadolibre.ejercicio_empleados.dto;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmpleadoDTO {
    private String id;
    private String name;
    private String lastName;
    private int edad;
    private String ciudad;
    private String provincia;
}
