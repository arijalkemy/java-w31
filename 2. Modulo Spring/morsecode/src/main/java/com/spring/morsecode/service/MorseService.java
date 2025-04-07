package com.spring.morsecode.service;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import com.spring.morsecode.dto.DecodeMorseRequestDTO;
import com.spring.morsecode.dto.DecodeMorseResponseDTO;
import com.spring.morsecode.repository.MorseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MorseService {

    private final MorseRepository morseRepository;

    /**
     * Decodes a Morse code message into plain text.
     *
     * @param decodeMorseDTO the DTO containing the Morse code string to be decoded.
     * @return a response DTO containing the decoded text.
     */
    public DecodeMorseResponseDTO decodeMorse(DecodeMorseRequestDTO decodeMorseDTO) {
        String decodedText = decodeMorseParagraph(decodeMorseDTO.getMorse());
        return new DecodeMorseResponseDTO(decodedText);
    }

    /**
     * Decodes a full paragraph of Morse code.
     * Morse words are separated by three spaces (" "), and letters within words by
     * single spaces.
     *
     * @param morseParagraph the Morse code paragraph to decode.
     * @return the decoded plain text.
     */
    private String decodeMorseParagraph(String morseParagraph) {
        return Arrays.stream(morseParagraph.split("   ")) // Split words
                .map(this::decodeMorseWord)
                .collect(Collectors.joining(" "));
    }

    /**
     * Decodes a single word from Morse code.
     * Morse letters are separated by single spaces.
     *
     * @param morseWord the Morse code word to decode.
     * @return the decoded word in plain text.
     */
    private String decodeMorseWord(String morseWord) {
        return Arrays.stream(morseWord.split(" ")) // Split letters
                .map(morseRepository::convertToLetter) // Convert each letter
                .collect(Collectors.joining());
    }
}
