package com.example.Deportistas.Entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeportistaDTO {
    private String nombre;
    private String apellido;
    private String nombreDeporte;

    public DeportistaDTO(String nombre, String apellido, String nombreDeporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreDeporte = nombreDeporte;
    }
}
