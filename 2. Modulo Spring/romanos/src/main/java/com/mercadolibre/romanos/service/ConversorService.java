package com.mercadolibre.romanos.service;

import org.springframework.stereotype.Service;

import java.util.NavigableMap;
import java.util.TreeMap;

@Service
public class ConversorService {
    private final static TreeMap<Integer, String> map = new TreeMap<>();

    static {
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
    }

    public String convertirARomano(Integer numeroDecimal){

        Integer num =  map.floorKey(numeroDecimal);
        if ( numeroDecimal == num ) {
            return map.get(numeroDecimal);
        }
           return map.get(num) + convertirARomano(numeroDecimal-num);
    }
}
