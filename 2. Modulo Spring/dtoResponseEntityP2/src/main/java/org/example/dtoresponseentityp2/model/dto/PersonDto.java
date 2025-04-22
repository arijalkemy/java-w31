package org.example.dtoresponseentityp2.model.dto;


import lombok.AllArgsConstructor;
import org.example.dtoresponseentityp2.model.entity.Symptom;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
public class PersonDto implements Serializable {
    private String nombre;
    private String apellido;
    private int edad;
}
