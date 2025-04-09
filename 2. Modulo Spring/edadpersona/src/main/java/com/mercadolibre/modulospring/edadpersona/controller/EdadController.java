package com.mercadolibre.modulospring.edadpersona.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


@RestController
public class EdadController {
    @GetMapping("{dia}/{mes}/{ano}")
    public String getEdad(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer ano) {
        String format = "dd/MM/yyyy";
        String date = String.format("%02d/%02d/%d", dia, mes, ano);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try{
            if(this.isValidDate(date, format)) {

                LocalDate fechaNac = LocalDate.parse(date, fmt);
                LocalDate fechaActual = LocalDate.now();

                Period periodo = Period.between(fechaNac, fechaActual);
                Integer edad = periodo.getYears();


                return edad.toString();

            }
            else{
                throw new Exception("Fecha incorrecta");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Fecha incorrecta";
    }




        public boolean isValidDate(String d, String dateFormat) {
            DateFormat df = new SimpleDateFormat(dateFormat);
            df.setLenient(false);
            try {
                df.parse(d);
            } catch (ParseException e) {
                return false;
            }
            return true;
        }

    }



