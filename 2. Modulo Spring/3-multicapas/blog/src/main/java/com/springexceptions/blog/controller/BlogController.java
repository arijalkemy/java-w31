package com.springexceptions.blog.controller;

import com.springexceptions.blog.dto.BlogEntryDTO;
import com.springexceptions.blog.dto.ResponseDTO;
import com.springexceptions.blog.service.BlogEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    private BlogEntryService blogEntryService;

    /*
    Crear una nueva entrada de Blog y devolver un mensaje adecuado diciendo
    que ha sido creada correctamente mostrando su “Id”. (URI: /blog).
     */

    @PostMapping("/blog")
    public ResponseEntity<ResponseDTO> createBlogEntry(@RequestBody BlogEntryDTO entry) {
        blogEntryService.save(entry);
        return new ResponseEntity<ResponseDTO>(new ResponseDTO("Blog entry created successfully"), HttpStatus.CREATED);
    }

    /*
    Devolver la información de una entrada de Blog específico, recibiendo el
    “Id” del mismo. (URI: /blog/{id}). Si el “Id” ingresado no corresponde a
    ninguna entrada de Blog, indicarlo con un mensaje adecuado.
     */

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogEntryDTO> createBlogEntry(@PathVariable Integer id) {
        BlogEntryDTO entryFound = blogEntryService.get(id);
        return new ResponseEntity<BlogEntryDTO>(entryFound, HttpStatus.CREATED);
    }

    /*
    Devolver el listado de todas las entradas de blogs existentes. (URI: /blogs).
     */

    @GetMapping("/blogs")
    public List<BlogEntryDTO> getAllBlogEntries() {
        return blogEntryService.getAllEntries();
    }
}