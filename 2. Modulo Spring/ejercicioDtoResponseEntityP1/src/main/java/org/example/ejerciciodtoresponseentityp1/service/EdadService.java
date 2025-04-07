package org.example.ejerciciodtoresponseentityp1.service;


import org.example.ejerciciodtoresponseentityp1.models.entity.ResponseEdad;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Pattern;

@Service
public class EdadService {

    final String regex = "^(0[1-9]|\\d{4})$";

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


public ResponseEdad calcularEdad(String fechaNacimiento, ResponseEdad responseEdad){
        responseEdad.setEdad(Period.between(LocalDate.parse(fechaNacimiento), LocalDate.now()).getYears());

        if(responseEdad.getEdad()<0){
            responseEdad.setError("La persona no ha nacido.");
        }else if(responseEdad.getEdad()>=120){
            responseEdad.setError("Esa edad está rara.");
        }

       return responseEdad;
    }

    public boolean sonCorrectosLosDigitos(String dia, String mes, String anio){
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(dia).matches() && pattern.matcher(mes).matches() && pattern.matcher(anio).matches();
    }
}
