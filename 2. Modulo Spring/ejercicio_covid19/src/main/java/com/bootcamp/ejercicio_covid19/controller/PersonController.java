package com.bootcamp.ejercicio_covid19.controller;

import com.bootcamp.ejercicio_covid19.service.IPersonService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    private IPersonService personService;
}
