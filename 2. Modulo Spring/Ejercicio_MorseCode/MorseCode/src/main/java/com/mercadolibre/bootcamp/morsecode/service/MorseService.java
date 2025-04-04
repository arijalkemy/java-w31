package com.mercadolibre.bootcamp.morsecode.service;

import com.mercadolibre.bootcamp.morsecode.util.MorseCode;
import org.springframework.stereotype.Service;

/**
 * Service class for decoding Morse code into plain text.
 * This service processes a string of Morse code, translating it
 * into text by leveraging the MorseCode utility class.
 */
@Service
public class MorseService {

    public String decodeMorseCode(String input) {
        StringBuilder result = new StringBuilder();
        for(String word : input.split("   ")) {
            for(String morseLetter: word.split(" ")) {
                result.append(MorseCode.getLetter(morseLetter));
            }
            result.append(" ");
        }
        return result.toString();
    }

}
