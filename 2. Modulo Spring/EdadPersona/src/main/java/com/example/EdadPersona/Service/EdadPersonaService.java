package com.example.EdadPersona.Service;

import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class EdadPersonaService {
    public String calcularEdad(Integer dia, Integer mes, Integer anio) {
        if (dia < 1 || dia > 31 || mes < 1 || mes > 12 || anio < 1900) {
            return "Fecha inválida.";
        }

        LocalDate hoy = LocalDate.now();
        if ((anio == hoy.getYear() && mes == hoy.getMonthValue() && dia >= hoy.getDayOfMonth())
                || (anio == hoy.getYear() && mes >= hoy.getMonthValue())
                || (anio > hoy.getYear())) {
            return "No nació todavía.";
        }

        LocalDate nacimiento = LocalDate.of(anio, mes, dia);

        Integer edad = hoy.getYear() - nacimiento.getYear();
        if (hoy.getDayOfYear() < nacimiento.getDayOfYear()) {
            edad--;
        }
        return Integer.toString(edad);
    }
}