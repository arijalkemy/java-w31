package org.meli.edaddeunapersona.service;

import org.meli.edaddeunapersona.model.entity.Persona;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class EdadPersonaService {
    public int calcularEdad(Persona persona) {
        LocalDate fechaNacimiento = LocalDate.of(persona.getAnio(), persona.getMes(), persona.getDia());
        LocalDate fechaActual = LocalDate.now();

        if (fechaNacimiento.isAfter(fechaActual)) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser posterior a la fecha actual");
        }

        return Period.between(fechaNacimiento, fechaActual).getYears();
    }
}