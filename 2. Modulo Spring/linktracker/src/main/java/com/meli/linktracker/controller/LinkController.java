package com.meli.linktracker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meli.linktracker.dto.CreateLinkRequestDTO;
import com.meli.linktracker.dto.CreateLinkResponseDTO;
import com.meli.linktracker.dto.GetLinkResponseDTO;
import com.meli.linktracker.service.LinkService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LinkController {
    private final LinkService linkService;

    @GetMapping("/link/metrics/{linkId}")
    public ResponseEntity<GetLinkResponseDTO> getLinkMetrics(
            @RequestParam String linkId) {
        GetLinkResponseDTO response = linkService.getLinkWithMetrics(linkId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/link")
    public ResponseEntity<CreateLinkResponseDTO> createLink(@RequestBody CreateLinkRequestDTO dto) {
        CreateLinkResponseDTO response = linkService.createLink(dto);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/link/invalidate/{linkId}")
    public ResponseEntity<GetLinkResponseDTO> invalidateLink(
            @RequestParam String linkId) {
        GetLinkResponseDTO response = linkService.invalidateLink(linkId);
        return ResponseEntity.ok(response);
    }
}
