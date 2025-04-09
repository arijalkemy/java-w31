package com.mercadolibre.ejnumerosromanos.service;

import org.springframework.stereotype.Service;

@Service
public class RomanosService {


    public String convertirARomanos(Integer numero) {
        if (numero < 1 || numero > 3999) {
            throw new IllegalArgumentException("El número debe estar entre 1 y 3999");
        }

        String[] miles = {"", "M", "MM", "MMM"};
        String[] centenas = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] decenas = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] unidades = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return miles[numero / 1000] +
                centenas[(numero % 1000) / 100] +
                decenas[(numero % 100) / 10] +
                unidades[numero % 10];
    }

}
