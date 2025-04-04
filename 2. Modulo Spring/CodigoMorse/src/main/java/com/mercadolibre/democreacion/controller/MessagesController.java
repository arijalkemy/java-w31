package com.mercadolibre.democreacion.controller;

import com.mercadolibre.democreacion.repository.ConvertMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MessagesController {
    private final ConvertMessage message;

    @GetMapping("/ObtenerPalabra")
    public String getWord(@RequestParam String word) {
        return message.convertToMessage(word);
    }

}
