package com.numerosRomanos.apiNumRomanos.service;

import java.util.HashMap;
import java.util.Map;

public class NumeroRomano {

    private static HashMap<Integer, String> map = new HashMap<>();
    static {

        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

    }

    public String convertirARomano(Integer numeroDecimal){
        int num = 1;
        for (Map.Entry<Integer,String> entrada : map.entrySet()) {
            if (entrada.getKey() <= numeroDecimal){
                num = entrada.getKey();
            }
        }
        if ( numeroDecimal == num ) {
            return map.get(numeroDecimal);
        }
        // si se envia un 12, daria 10 num, luego 12-10=2 y en el llamado recursivo se arma el romano de 2 y forma XII
        return map.get(num) + convertirARomano(numeroDecimal-num);
    }
}
