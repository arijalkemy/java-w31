package com.mercadolibre.linktracker.controller;

import com.mercadolibre.linktracker.dto.LinkDto;
import com.mercadolibre.linktracker.service.ILinkService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/link")
public class LinkController {

    private final ILinkService linkService;

    public LinkController(ILinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/create")
    public ResponseEntity<LinkDto> createLink(@RequestBody LinkDto linkDto) throws MalformedURLException, URISyntaxException {
        return new ResponseEntity<>(linkService.save(linkDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Void> redirectUrl(@PathVariable Long id){
        return new ResponseEntity<>(linkService.redirectLink(id), HttpStatus.FOUND);
    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<LinkDto> getMetrics(@PathVariable Long id){
        return new ResponseEntity<>(linkService.metrics(id), HttpStatus.OK);
    }
}
