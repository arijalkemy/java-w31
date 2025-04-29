package com.mercadolibre.be_java_hisp_w31_g02.utils;

import com.mercadolibre.be_java_hisp_w31_g02.exception.CustomDateTimeParseException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class FormatUtils {

    public static LocalDate StringDateToLocalDateOrThrow(String stringDate) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            return LocalDate.parse(stringDate, formatter);
        } catch (DateTimeParseException e) {
            throw new CustomDateTimeParseException("Could not parse date.");
        }
    }

}
