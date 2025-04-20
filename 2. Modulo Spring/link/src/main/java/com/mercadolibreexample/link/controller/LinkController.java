package com.mercadolibreexample.link.controller;

import com.mercadolibreexample.link.dto.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;

@RestController
public class LinkController {
    @Autowired
    private LinkService service;

    @PostMapping("/link")
    public ResponseEntity<Map<String, Integer>> createLink(
            @RequestParam String url,
            @RequestParam(required = false) String password
    ) {
        int id = service.createLink(url, password);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("linkId", id));
    }

    @GetMapping("/link/{id}")
    public ResponseEntity<Void> redirect(@PathVariable int id, @RequestParam(required = false) String password) {
        String url = service.getRedirectUrl(id, password);
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(url)).build();
    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<Map<String, Integer>> getMetrics(@PathVariable int id) {
        int count = service.getRedirectCount(id);
        return ResponseEntity.ok(Map.of("redirectCount", count));
    }

    @PostMapping("/invalidate/{id}")
    public ResponseEntity<String> invalidate(@PathVariable int id) {
        service.invalidateLink(id);
        return ResponseEntity.ok("Link invalidado correctamente");
    }
}

