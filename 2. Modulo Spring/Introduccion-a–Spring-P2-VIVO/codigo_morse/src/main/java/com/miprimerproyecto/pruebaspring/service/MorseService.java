package com.miprimerproyecto.pruebaspring.service;

import org.springframework.stereotype.Service;

import com.miprimerproyecto.pruebaspring.dto.DecodedMessageDto;
import com.miprimerproyecto.pruebaspring.repository.MorseRepository;

@Service
public class MorseService {

    MorseRepository morseRepository;

    public MorseService(MorseRepository morseRepository){
        this.morseRepository = morseRepository;
    }

    public DecodedMessageDto getDecodedMessage(String message){
        String decodedMessage = morseRepository.getDecodedMessage(message);
        return new DecodedMessageDto(decodedMessage);
    }
}
