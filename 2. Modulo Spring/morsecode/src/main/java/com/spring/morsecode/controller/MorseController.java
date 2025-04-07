package com.spring.morsecode.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.morsecode.dto.DecodeMorseRequestDTO;
import com.spring.morsecode.dto.DecodeMorseResponseDTO;
import com.spring.morsecode.service.MorseService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Controller for handling Morse code decoding requests.
 * Provides an endpoint to convert Morse code into plain text.
 */
@RestController
@RequestMapping("/api/morse")
@RequiredArgsConstructor
public class MorseController {

    private final MorseService morseService;

    /**
     * Decodes a given Morse code string into plain text.
     *
     * @param decodeMorseDTO the request containing the Morse code
     * @return a ResponseEntity containing the decoded text
     */
    @PostMapping("/decode")
    public ResponseEntity<DecodeMorseResponseDTO> postMethodName(@RequestBody DecodeMorseRequestDTO decodeMorseDTO) {
        DecodeMorseResponseDTO response = morseService.decodeMorse(decodeMorseDTO);
        return ResponseEntity.ok(response);
    }
}
