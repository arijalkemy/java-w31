package com.mercadolibre.modulospring.morsecode.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RestController
public class NewController {
    public HashMap<String,String>diccionario = new HashMap<>();
    public NewController() {
        diccionario.put(".-","A");
        diccionario.put("-...","B");
        diccionario.put("-.-.","C");
        diccionario.put("-..","D");
        diccionario.put(".","E");
        diccionario.put("..-.","F");
        diccionario.put("--.","G");
        diccionario.put("....","H");
        diccionario.put("..","I");
        diccionario.put(".---","J");
        diccionario.put("-.-","K");
        diccionario.put(".-..","L");
        diccionario.put("--","M");
        diccionario.put("-.","N");
        diccionario.put("---","O");
        diccionario.put(".--.","P");
        diccionario.put("--.-","Q");
        diccionario.put(".-.","R");
        diccionario.put("...","S");
        diccionario.put("-","T");
        diccionario.put("..-","U");
        diccionario.put("...-","V");
        diccionario.put(".--","W");
        diccionario.put("-..-","X");
        diccionario.put("-.--","Y");
        diccionario.put("--..","Z");
        diccionario.put(""," ");



    }

    @GetMapping("codigo/{variable}")
    public String codigo(@PathVariable String variable) {
        String[]  letras=variable.split(" ");
        List<String> palabra=Arrays.stream(letras).map(x->diccionario.get(x)).toList();
        String resultado="";
        for(String letra: palabra){
            resultado+=letra;
        }

        return "codigo " + resultado;
    }
}
