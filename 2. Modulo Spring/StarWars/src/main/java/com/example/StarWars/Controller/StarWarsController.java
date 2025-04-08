package com.example.StarWars.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.StarWars.DTO.PersonajeDTO;
import com.example.StarWars.Service.StarWarsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/StarWars")
public class StarWarsController {

    @Autowired
    private StarWarsService starWarsService;

    @GetMapping("BuscarPersonaje/{name}")
    @ResponseBody
    public List<PersonajeDTO> findCharacterByName(@PathVariable String name) {
        return starWarsService.findCharacterByName(name);
    }
}
