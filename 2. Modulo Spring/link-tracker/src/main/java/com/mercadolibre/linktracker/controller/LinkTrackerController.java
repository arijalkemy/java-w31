package com.mercadolibre.linktracker.controller;

import com.mercadolibre.linktracker.dto.LinkTrackerDTO;
import com.mercadolibre.linktracker.dto.LinkTrackerRequestDTO;
import com.mercadolibre.linktracker.dto.LinkTrackerStatsDTO;
import com.mercadolibre.linktracker.service.ILinkTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LinkTrackerController {

    @Autowired
    private ILinkTrackerService linkTrackerService;

    @PostMapping("/link")
    public ResponseEntity<String> createUrl(@RequestBody LinkTrackerRequestDTO request) {
        Integer newId = linkTrackerService.createUrl(request.getUrl(), request.getPassword());
        return new ResponseEntity<>("Link con id: " + newId + " creado con éxito", HttpStatus.CREATED);
    }

    @GetMapping("/link/{id}")
    public ResponseEntity<String> redirectUrl(@PathVariable Integer id,
                                              @RequestParam(required = false) String password) {
        LinkTrackerDTO link = linkTrackerService.redirectLink(id, password);
        return new ResponseEntity<>("Redireccionando hacia " + link.getUrl(), HttpStatus.FOUND);
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<LinkTrackerStatsDTO> getUrlMetrics(@PathVariable Integer linkId) {
        LinkTrackerStatsDTO link = linkTrackerService.getUrlMetrics(linkId);
        return new ResponseEntity<>(link, HttpStatus.OK);
    }

    @PutMapping("/invalidate/{linkId}")
    public ResponseEntity<String> invalidateUrl(@PathVariable Integer linkId,
                                                @RequestParam(required = false) String password) {
        LinkTrackerDTO link = linkTrackerService.invalidateUrl(linkId, password);
        return new ResponseEntity<>("Se invalidó la url: " + link.getUrl(), HttpStatus.ACCEPTED);
    }

}
