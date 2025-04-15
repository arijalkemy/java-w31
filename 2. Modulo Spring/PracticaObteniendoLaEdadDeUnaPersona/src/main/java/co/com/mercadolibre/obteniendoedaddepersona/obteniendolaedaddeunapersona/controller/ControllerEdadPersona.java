package co.com.mercadolibre.obteniendoedaddepersona.obteniendolaedaddeunapersona.controller;

import org.springframework.web.bind.annotation.RestController;
import co.com.mercadolibre.obteniendoedaddepersona.service.EdadDeUnaPersonaService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ControllerEdadPersona {

    private final EdadDeUnaPersonaService edadDeUnaPersonaService;

    public ControllerEdadPersona(EdadDeUnaPersonaService edadDeUnaPersonaService) {
        this.edadDeUnaPersonaService = edadDeUnaPersonaService;
    }

    @GetMapping("/{day}/{month}/{year}")
    public ResponseEntity<Integer> getAgeOfAnUser(@PathVariable int day, @PathVariable int month, @PathVariable int year ) {
        return ResponseEntity.ok((edadDeUnaPersonaService.getPeopleAge(day, month, year)));
    }
    
}
