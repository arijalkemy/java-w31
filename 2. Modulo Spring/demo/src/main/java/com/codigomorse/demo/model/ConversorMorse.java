package com.codigomorse.demo.model;

import java.util.HashMap;

public class ConversorMorse {

        private HashMap<String, String> textoAMorse;
        private HashMap<String, String> morseATexto;


    public String getMorsePorFrase(String frase){
        String nueva = "";
        String[] palabras = frase.split("   ");

        for (String palabra : palabras) {
            System.out.println(palabra);
            nueva = nueva + getMorsePorPalabra(palabra) + " ";
        }
        System.out.println(nueva);
        return nueva;
    }

    public String getMorsePorPalabra(String palabra){
        String nueva = "";
        String[] letras = palabra.split(" "); // Tres espacios como delimitador
        for (String letra : letras) {
            System.out.println(letra);
            nueva = nueva + getMorsePorLetra(letra) ;
        }
        System.out.println(nueva);
        return nueva;
    }
    public String getMorsePorLetra(String codigo){
        return morseATexto.get(codigo);
    }


    public ConversorMorse() {
        textoAMorse = new HashMap<>();
        morseATexto = new HashMap<>();

        // Números
        agregarConversion("0", "-----");
        agregarConversion("1", ".----");
        agregarConversion("2", "..---");
        agregarConversion("3", "...--");
        agregarConversion("4", "....-");
        agregarConversion("5", ".....");
        agregarConversion("6", "-....");
        agregarConversion("7", "--...");
        agregarConversion("8", "---..");
        agregarConversion("9", "----.");

        // Letras
        agregarConversion("A", ".-");
        agregarConversion("B", "-...");
        agregarConversion("C", "-.-.");
        agregarConversion("D", "-..");
        agregarConversion("E", ".");
        agregarConversion("F", "..-.");
        agregarConversion("G", "--.");
        agregarConversion("H", "....");
        agregarConversion("I", "..");
        agregarConversion("J", ".---");
        agregarConversion("K", "-.-");
        agregarConversion("L", ".-..");
        agregarConversion("M", "--");
        agregarConversion("N", "-.");
        agregarConversion("O", "---");
        agregarConversion("P", ".--.");
        agregarConversion("Q", "--.-");
        agregarConversion("R", ".-.");
        agregarConversion("S", "...");
        agregarConversion("T", "-");
        agregarConversion("U", "..-");
        agregarConversion("V", "...-");
        agregarConversion("W", ".--");
        agregarConversion("X", "-..-");
        agregarConversion("Y", "-.--");
        agregarConversion("Z", "--..");

        // Caracteres especiales
        agregarConversion(".", ".-.-.-");
        agregarConversion(",", "--..--");
        agregarConversion("?", "..--..");
        agregarConversion("'", ".----.");
        agregarConversion("!", "-.-.--");
        agregarConversion("/", "-..-.");
        agregarConversion("(", "-.--.");
        agregarConversion(")", "-.--.-");
        agregarConversion("&", ".-...");
        agregarConversion(":", "---...");
        agregarConversion(";", "-.-.-.");
        agregarConversion("=", "-...-");
        agregarConversion("+", ".-.-.");
        agregarConversion("-", "-....-");
        agregarConversion("_", "..--.-");
        agregarConversion("\"", ".-..-.");
        agregarConversion("$", "...-..-");
        agregarConversion("@", ".--.-.");
    }

    private void agregarConversion(String caracter, String codigoMorse) {
        textoAMorse.put(caracter, codigoMorse);
        morseATexto.put(codigoMorse, caracter);
    }




}
