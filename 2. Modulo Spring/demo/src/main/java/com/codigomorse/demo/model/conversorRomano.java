package com.codigomorse.demo.model;

import java.util.HashMap;
import java.util.Map;

public class conversorRomano {

    Map<String, Integer> romanosADecimales = new HashMap<>();
    Map<Integer, String> decimalesARomanos = new HashMap<>();



    public static String convertirDecimalARomanos(String s) {
        Integer num = Integer.parseInt(s);
        String[] decimales = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] valores = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < valores.length; i++) {
            while (num >= valores[i]) {
                num -= valores[i];
                resultado.append(decimales[i]);
            }
        }
        return resultado.toString();
    }



    public conversorRomano(){
        romanosADecimales.put("I", 1);
        romanosADecimales.put("V", 5);
        romanosADecimales.put("X", 10);
        romanosADecimales.put("L", 50);
        romanosADecimales.put("C", 100);
        romanosADecimales.put("D", 500);
        romanosADecimales.put("M", 1000);

        decimalesARomanos.put(1, "I");
        decimalesARomanos.put(5, "V");
        decimalesARomanos.put(10, "X");
        decimalesARomanos.put(50, "L");
        decimalesARomanos.put(100, "C");
        decimalesARomanos.put(500, "D");
        decimalesARomanos.put(1000, "M");
    }

}
