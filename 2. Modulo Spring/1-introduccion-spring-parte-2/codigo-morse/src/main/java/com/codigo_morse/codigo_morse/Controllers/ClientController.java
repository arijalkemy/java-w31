package com.codigo_morse.codigo_morse.Controllers;

import com.codigo_morse.codigo_morse.Service.Traductor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ClientController {

    @PostMapping("/traducir")
    public String decodificar(@RequestBody Map<String, String> body) {
        String codigoMorse = body.get("codigoMorse");
        return Traductor.traducir(codigoMorse);
    }
}
