package com.bootcamp.springp2vivomorse.service;

import com.bootcamp.springp2vivomorse.dto.DecryptRequestBody;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MorseService {
    public String decrypt(DecryptRequestBody req){
        String morse = req.morse();
        String decryptedMorse = decryptMorse(morse);
        return decryptedMorse;
    }

    private String decryptMorse(String morse) {
        String out = "";
        List<String> words = List.of(morse.split("   "));
        for(String word : words){
            out += " "+ this.decryptedWord(word);
        }
        return out;
    }

    private String decryptedWord(String word) {
        List<String> listOfChar = List.of(word.split(" "));
        String decrypted = "";
        for(String c : listOfChar){
            decrypted += getMorseMap().get(c);
        }
        return decrypted;
    }


    private Map<String,String> getMorseMap(){
        Map<String, String> map = new HashMap<>();
        map.put(".-", "A");
        map.put("-...", "B");
        map.put("-.-.", "C");
        map.put("-..", "D");
        map.put(".", "E");
        map.put("..-.", "F");
        map.put("--.", "G");
        map.put("....", "H");
        map.put("..", "I");
        map.put(".---", "J");
        map.put("-.-", "K");
        map.put(".-..", "L");
        map.put("--", "M");
        map.put("-.", "N");
        map.put("---", "O");
        map.put(".--.", "P");
        map.put("--.-", "Q");
        map.put(".-.", "R");
        map.put("...", "S");
        map.put("-", "T");
        map.put("..-", "U");
        map.put("...-", "V");
        map.put(".--", "W");
        map.put("-..-", "X");
        map.put("-.--", "Y");
        map.put("--..", "Z");
        map.put("-----", "0");
        map.put(".----", "1");
        map.put("..---", "2");
        map.put("...--", "3");
        map.put("....-", "4");
        map.put(".....", "5");
        map.put("-....", "6");
        map.put("--...", "7");
        map.put("---..", "8");
        map.put("----.", "9");
        map.put("..--..", "?");
        map.put("-.-.--", "!");
        map.put(".-.-.-", ".");
        map.put("--..--", ",");
        return map;
    }
}
