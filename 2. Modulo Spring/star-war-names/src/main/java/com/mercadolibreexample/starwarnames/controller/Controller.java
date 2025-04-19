package com.mercadolibreexample.starwarnames.controller;

import com.mercadolibreexample.starwarnames.service.IService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    IService service;

    @GetMapping("/{name}")
    public String getName(@PathVariable String name) {
        service.loadData();
        return service.getName(name);
    }
}
