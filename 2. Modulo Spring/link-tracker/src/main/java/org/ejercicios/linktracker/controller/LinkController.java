package org.ejercicios.linktracker.controller;

import org.ejercicios.linktracker.dto.LinkDTO;
import org.ejercicios.linktracker.service.LinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LinkController {
    private LinkService service;

    public LinkController(LinkService service) {
        this.service = service;
    }

    @PostMapping("/link")
    public ResponseEntity<?> createNewLink(@RequestBody LinkDTO link) {
        return new ResponseEntity<>(service.createLink(link.getLink()), HttpStatus.OK);
    }

    @GetMapping("/link/{id}")
    public ResponseEntity<String> getLinkFromID(@PathVariable int id) {
        return new ResponseEntity<>(service.getLinkFromID(id), HttpStatus.OK);
    }

    @GetMapping("/link/metrics/{id}")
    public ResponseEntity<Integer> getMetricsForLink(@PathVariable int id) {
        return new ResponseEntity<>(service.getLinkCount(id), HttpStatus.OK);
    }

    @PostMapping("/invalidate/{id}")
    public ResponseEntity<Integer> invalidateLink(@PathVariable int id) {
        service.invalidateLink(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
