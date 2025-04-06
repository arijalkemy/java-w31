package co.com.mercadolibre.morsecode.morsecode.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.mercadolibre.morsecode.morsecode.service.MorseCodeService;

@RestController
public class MorseCodeController {

    @PostMapping("/morseTotText")
    public String morseToText(@RequestParam String morse) {
        return MorseCodeService.translateToText(morse);
    }
}
