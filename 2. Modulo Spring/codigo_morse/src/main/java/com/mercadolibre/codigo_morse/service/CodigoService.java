package com.mercadolibre.codigo_morse.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CodigoService implements ICodigoService{

    private static final Map<String, String> abecedario = new HashMap<>();

    static {
        abecedario.put(".-", "A");
        abecedario.put("-...", "B");
        abecedario.put("-.-.", "C");
        abecedario.put("-..", "D");
        abecedario.put(".", "E");
        abecedario.put("..-.", "F");
        abecedario.put("--.", "G");
        abecedario.put("....", "H");
        abecedario.put("..", "I");
        abecedario.put(".---", "J");
        abecedario.put("-.-", "K");
        abecedario.put(".-..", "L");
        abecedario.put("--", "M");
        abecedario.put("-.", "N");
        abecedario.put("---", "O");
        abecedario.put(".--.", "P");
        abecedario.put("--.-", "Q");
        abecedario.put(".-.", "R");
        abecedario.put("...", "S");
        abecedario.put("-", "T");
        abecedario.put("..-", "U");
        abecedario.put("...-", "V");
        abecedario.put(".--", "W");
        abecedario.put("-..-", "X");
        abecedario.put("-.--", "Y");
        abecedario.put("--..", "Z");
    }


    @Override
    public String descifrarCodigoService(String codigo){

        String[] palabras = codigo.split("   ");
        StringBuilder salida = new StringBuilder();

        for (String palabra : palabras){
            String[] letras = palabra.split(" ");
            for (String letra : letras){
                salida.append(abecedario.get(letra));
            }
            salida.append(" ");
        }

        return salida.toString();
    }
}
