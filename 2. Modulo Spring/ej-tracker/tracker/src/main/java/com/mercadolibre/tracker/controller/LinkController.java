package com.mercadolibre.tracker.controller;

import com.mercadolibre.tracker.dto.RequestLinkDto;
import com.mercadolibre.tracker.dto.ResponseLinkDto;
import com.mercadolibre.tracker.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LinkController {

    @Autowired
    LinkService linkService;

    @PostMapping("/link")
    public ResponseEntity<ResponseLinkDto> createLink(@RequestBody RequestLinkDto requestLink) {
        return new ResponseEntity<>(linkService.createLink(requestLink), HttpStatus.CREATED);
    }

    @GetMapping("/link/{linkId}")
    public ResponseEntity<String> redirect(@PathVariable String linkId, @RequestParam String password) {
        return new ResponseEntity<>(linkService.redirect(linkId, password), HttpStatus.PERMANENT_REDIRECT);
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<Integer> getMetrics(@PathVariable String linkId) {
        return new ResponseEntity<>(linkService.getMetrics(linkId), HttpStatus.OK);
    }

    @PutMapping("/invalidate/{linkId}")
    public ResponseEntity<String> invalidate(@PathVariable String linkId) {
        return new ResponseEntity<>(linkService.invalidate(linkId), HttpStatus.OK);
    }
}
