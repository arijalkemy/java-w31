package com.linktracker.link.controller;

import com.linktracker.link.dto.LinkRequestDTO;
import com.linktracker.link.dto.LinkResponseDTO;
import com.linktracker.link.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class LinkController {

    @Autowired
    private LinkService linkService;

    @PostMapping("/link")
    public ResponseEntity<LinkResponseDTO> postLink(@RequestBody LinkRequestDTO body) {
        LinkResponseDTO res = linkService.addLink(body);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @GetMapping("/link/{linkId}")
    public ResponseEntity<UUID> redirectToLink(@PathVariable UUID linkId) {
        linkService.redirectToLink(linkId);
        return new ResponseEntity<>(linkId, HttpStatus.CREATED);
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<LinkResponseDTO> getMetrics(@PathVariable UUID linkId) {
        LinkResponseDTO res = linkService.getMetrics(linkId);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/{linkId}")
    public ResponseEntity<LinkResponseDTO> getMetrics(@PathVariable UUID linkId) {
        LinkResponseDTO res = linkService.getMetrics(linkId);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
