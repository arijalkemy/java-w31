package com.miprimerproyecto.pruebaspring.repository;

import org.springframework.stereotype.Repository;

import com.miprimerproyecto.pruebaspring.utils.MorseDecoder;

@Repository
public class MorseRepository {

    public String getDecodedMessage(String message){
        return MorseDecoder.decodeMorse(message);
    }
}
