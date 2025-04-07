package com.dtodeportistas.deportistas.Controller;

import com.dtodeportistas.deportistas.DTO.PersonaDTO;
import com.dtodeportistas.deportistas.Service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/findSportsPersons")
    public List<PersonaDTO> getPersonasDeportistas() {
        return personaService.getPersonas();
    }

}
