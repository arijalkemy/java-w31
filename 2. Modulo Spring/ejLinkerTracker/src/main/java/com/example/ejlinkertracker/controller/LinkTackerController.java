package com.example.ejlinkertracker.controller;

import com.example.ejlinkertracker.dto.LinkDtoRequest;
import com.example.ejlinkertracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LinkTackerController {
    @Autowired
    ILinkService linkService;

    @GetMapping("/link")
    ResponseEntity<?> getLinks(){
        return ResponseEntity.ok(linkService.searchAll());
    }

    @PostMapping("/link")
    ResponseEntity<?> postNewLink(@RequestBody LinkDtoRequest link){
        return ResponseEntity.ok(linkService.addLink(link));
    }

    @GetMapping("/link/{linkId}")
    ResponseEntity<?> getRedirection(@PathVariable Long linkId){
        return ResponseEntity.ok(linkService.redirect(linkId));
    }

    @GetMapping("/metrics/{linkId}")
    ResponseEntity<?> getMetrics(@PathVariable Long linkId){
        return ResponseEntity.ok(linkService.metrics(linkId));
    }

    @PostMapping("/invalidate/{linkId}")
    ResponseEntity<?> postInvalidarLink(@PathVariable Long linkId){
        return ResponseEntity.ok(linkService.invalidate(linkId));
    }

}
