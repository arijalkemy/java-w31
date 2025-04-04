package com.morse.ejerciciocodigomorse.Controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class Controlador {

    @GetMapping("{texto}")
    public String traducir(@PathVariable String texto){
        return converir(splitDeCadenas(texto));
    }

    private List<String[]> splitDeCadenas(String s){
        //Ahora hago una lista de palabras separadas por 3 espacios
        String [] palabras = s.split("\\s{3}");

        List<String[]> listaDeLetras = new ArrayList<>();
        for (int i = 0; i<palabras.length;i++)
        {
            String [] letra = palabras[i].split(" ");
            listaDeLetras.add(letra);
        }
        return listaDeLetras;
    }

    private String converir(List<String[]> lista){
        //Creamos un mapa
        HashMap<String,String> morseMap = new HashMap<>();
        morseMap.put(".-", "A");
        morseMap.put("-...", "B");
        morseMap.put("-.-.", "C");
        morseMap.put("-..", "D");
        morseMap.put(".", "E");
        morseMap.put("..-.", "F");
        morseMap.put("--.", "G");
        morseMap.put("....", "H");
        morseMap.put("..", "I");
        morseMap.put(".---", "J");
        morseMap.put("-.-", "K");
        morseMap.put(".-..", "L");
        morseMap.put("--", "M");
        morseMap.put("-.", "N");
        morseMap.put("---", "O");
        morseMap.put(".--.", "P");
        morseMap.put("--.-", "Q");
        morseMap.put(".-.", "R");
        morseMap.put("...", "S");
        morseMap.put("-", "T");
        morseMap.put("..-", "U");
        morseMap.put("...-", "V");
        morseMap.put(".--", "W");
        morseMap.put("-..-", "X");
        morseMap.put("-.--", "Y");
        morseMap.put("--..", "Z");
        morseMap.put("-----", "0");
        morseMap.put(".----", "1");
        morseMap.put("..---", "2");
        morseMap.put("...--", "3");
        morseMap.put("....-", "4");
        morseMap.put(".....", "5");
        morseMap.put("-....", "6");
        morseMap.put("--...", "7");
        morseMap.put("---..", "8");
        morseMap.put("----.", "9");

        String resultado = "";

        for(int i = 0; i<lista.size(); i++){
            String [] arregloInterno = lista.get(i);
            resultado = resultado + " ";
            for(int j = 0;j< arregloInterno.length; j++){
                if(morseMap.containsKey(arregloInterno[j])){
                    resultado = resultado + morseMap.get(arregloInterno[j]);
                }
            }
        }

        return resultado;
    }
}
