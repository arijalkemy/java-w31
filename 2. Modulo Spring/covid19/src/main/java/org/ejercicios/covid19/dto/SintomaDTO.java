package org.ejercicios.covid19.dto;

import lombok.*;
import org.springframework.http.HttpStatusCode;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SintomaDTO {
    private String codigo;
    private String nombre;
    private String nivelDeGravedad;
}
