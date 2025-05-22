package com.example.link_tracker.controller;

import com.example.link_tracker.dto.LinkRequestDto;
import com.example.link_tracker.dto.LinkResponseDto;
import com.example.link_tracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/link")
public class LinkController {

    private ILinkService iLinkService;

    @PostMapping("/create")
    public ResponseEntity<?> createLink(@RequestBody LinkRequestDto linkRequest) {
        LinkResponseDto createdLink = iLinkService.createLink(linkRequest);
        return ResponseEntity.ok(createdLink);
    }

    @GetMapping("/{linkId}")
    public ResponseEntity<Void> redirectLink(@PathVariable String linkId, @RequestParam(required = false) String password) {
        String url = iLinkService.redirectLink(linkId, password);
        return ResponseEntity.status(301).header("Location", url).build();
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<Integer> getRedirectionCount(@PathVariable String linkId) {
        int count = iLinkService.getRedirectionCount(linkId);
        return ResponseEntity.ok(count);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<Void> invalidateLink(@PathVariable String linkId) {
        iLinkService.invalidateLink(linkId);
        return ResponseEntity.noContent().build();
    }
}
