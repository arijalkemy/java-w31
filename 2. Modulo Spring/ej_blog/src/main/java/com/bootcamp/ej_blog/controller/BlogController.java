package com.bootcamp.ej_blog.controller;

import com.bootcamp.ej_blog.model.EntradaBlog;
import com.bootcamp.ej_blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @PostMapping
    public ResponseEntity<String> crearEntrada(@RequestParam String titulo, @RequestParam String autor){
        EntradaBlog entrada = blogService.crearEntrada(titulo,autor);
        return ResponseEntity.ok("Entrada de blog creada con id: "+ entrada.getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntradaBlog> obtenerEntradaPorId(@PathVariable int id){
        EntradaBlog entrada = blogService.obtenerEntradaPorId(id);
        return ResponseEntity.ok(entrada);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<EntradaBlog>> listarEntradas(){
        List<EntradaBlog> entradas = blogService.listarEntradas();
        return ResponseEntity.ok(entradas);
    }
}
