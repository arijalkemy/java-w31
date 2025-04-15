package com.bootcamp.ejercicio_linktracker.controller;

import com.bootcamp.ejercicio_linktracker.dto.CreateLinkDto;
import com.bootcamp.ejercicio_linktracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LinkController {
    @Autowired
    private ILinkService linkService;

    @PostMapping()
    public ResponseEntity<Integer> saveLink(@RequestBody CreateLinkDto createLinkDto){
        return ResponseEntity.ok(linkService.saveLink(createLinkDto));
    }

    @GetMapping("/link/{linkId}")
    public ResponseEntity<String> getLink(@PathVariable Integer linkId, @RequestParam String password){
        return new ResponseEntity<>(linkService.getRedirect(linkId, password), HttpStatus.OK);
    }

    @GetMapping("metrics/{linkId}")
    public ResponseEntity<Integer> getMetrics(@PathVariable Integer linkId){
        return new ResponseEntity<>(linkService.getVisitCount(linkId), HttpStatus.OK);
    }

    @PostMapping("invalidate/{linkId}")
    public ResponseEntity<Void> invalidateLink(@PathVariable Integer linkId){
        linkService.invalidateLink(linkId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
