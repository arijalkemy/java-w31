package org.mercadolibre.ejercicio_deportistas.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeportePersonaDTO {
    private String nombre;
    private String apellido;
    private String deporte;

    public DeportePersonaDTO() {
    }

    public DeportePersonaDTO(String nombre, String apellido, String deporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.deporte = deporte;
    }


}
