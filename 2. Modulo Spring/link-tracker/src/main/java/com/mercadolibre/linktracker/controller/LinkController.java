package com.mercadolibre.linktracker.controller;

import com.mercadolibre.linktracker.dto.LinkDto;
import com.mercadolibre.linktracker.service.ILinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/link")
public class LinkController {

    private final ILinkService linkService;

    public LinkController(ILinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/create")
    public ResponseEntity<Long> createLink(@RequestBody LinkDto linkDto){
        return new ResponseEntity<>(linkService.save(linkDto), HttpStatus.CREATED);
    }
}
