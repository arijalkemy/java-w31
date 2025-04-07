package org.example.ejerciciodtoresponseentityp1.models.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseEdad {
    int edad;
    String error = "No hay errores.";

    @Override
    public String toString() {
        return "ResponseEdad{" +
                "edad=" + edad +
                ", error='" + error + '\'' +
                '}';
    }
}
