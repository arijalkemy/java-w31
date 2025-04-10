package com.mercadolibre.linktracker.controller;

import com.mercadolibre.linktracker.dto.LinkDTO;
import com.mercadolibre.linktracker.dto.LinkStatsDTO;
import com.mercadolibre.linktracker.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/url")
public class LinkController {
    @Autowired
    LinkService linkService;

    @PostMapping
    public ResponseEntity<String> createLink(@RequestBody LinkDTO request) {
        Integer newId = linkService.createLink(request.getUrl(), request.getPassword());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Se ha creado el link con el id: " + newId);
    }

    @GetMapping("/link/{id}")
    public ResponseEntity<String> redirect(@PathVariable Integer id,
                                      @RequestParam(required = false) String password) {
        LinkDTO link = linkService.handleRedirect(id, password);
        return ResponseEntity.status(HttpStatus.OK).body("La url es: " + link.getUrl());
    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<String> getStats(@PathVariable Integer id) {
        LinkStatsDTO link = linkService.getMetrics(id);
        return ResponseEntity.status(HttpStatus.OK).body("La cantidad de veces que se redireccionó fueron: " + link.getRedirectCount());
    }

    @PostMapping("/invalidate/{id}")
    public ResponseEntity<String> invalidate(@PathVariable Integer id, @RequestParam (required = false) String password){
        linkService.invalidateLink(id, password);
        return ResponseEntity.status(HttpStatus.OK).body("Se ha invalidado el link correctamente.");
    }
}


