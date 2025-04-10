package com.mercadolibre.blogapi.controller;

import com.mercadolibre.blogapi.dto.BlogDto;
import com.mercadolibre.blogapi.service.IBlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blog")
public class BlogController {

    private IBlogService entradaBlogService;

    public BlogController(IBlogService entradaBlogService) {
        this.entradaBlogService = entradaBlogService;
    }

    @PostMapping("/create")
    public ResponseEntity<BlogDto> createEntryBlog(@RequestBody BlogDto entradaBlogDto){
        return new ResponseEntity<>(entradaBlogService.save(entradaBlogDto), HttpStatus.CREATED);
    }


}
