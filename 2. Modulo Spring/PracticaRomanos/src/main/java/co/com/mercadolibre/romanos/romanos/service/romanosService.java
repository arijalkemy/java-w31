package co.com.mercadolibre.romanos.romanos.service;

import java.util.HashMap;
import java.util.Map;

public class romanosService {

    public static String toRoman(int number){
        Map<Integer, String> dictionaryOfRomanNumber = new HashMap<>();
        dictionaryOfRomanNumber.put(1, "I");
        dictionaryOfRomanNumber.put(2, "II");
        dictionaryOfRomanNumber.put(3, "III");
        dictionaryOfRomanNumber.put(4, "IV");
        dictionaryOfRomanNumber.put(5, "V");
        dictionaryOfRomanNumber.put(7, "VII");
        dictionaryOfRomanNumber.put(10, "X");
        dictionaryOfRomanNumber.put(13, "XIII");
        dictionaryOfRomanNumber.put(50, "L");
        dictionaryOfRomanNumber.put(100, "C");
        dictionaryOfRomanNumber.put(500, "D");
        dictionaryOfRomanNumber.put(1000, "M");
        return dictionaryOfRomanNumber.get(number);
    }
}
