package com.mercadolibre.linktracker.controller;

import com.mercadolibre.linktracker.dto.LinkRequestDto;
import com.mercadolibre.linktracker.dto.LinkResponseDto;
import com.mercadolibre.linktracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/link")
public class LinkController {

    @Autowired
    private ILinkService linkService;

    @PostMapping("/create")
    public ResponseEntity<?> createLink(@RequestBody LinkRequestDto linkRequest) {
        LinkResponseDto createdLink = linkService.createLink(linkRequest);
        return ResponseEntity.ok(createdLink);
    }

    @GetMapping("/{linkId}")
    public ResponseEntity<Void> redirectLink(@PathVariable String linkId, @RequestParam(required = false) String password) {
        String url = linkService.redirectLink(linkId, password);
        return ResponseEntity.status(301).header("Location", url).build();
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<Integer> getRedirectionCount(@PathVariable String linkId) {
        int count = linkService.getRedirectionCount(linkId);
        return ResponseEntity.ok(count);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<Void> invalidateLink(@PathVariable String linkId) {
        linkService.invalidateLink(linkId);
        return ResponseEntity.noContent().build();
    }
}
