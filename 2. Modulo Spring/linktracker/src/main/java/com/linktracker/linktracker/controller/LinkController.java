package com.linktracker.linktracker.controller;

import com.linktracker.linktracker.dto.LinkDTO;
import com.linktracker.linktracker.service.ILinkService;
import com.linktracker.linktracker.service.LinkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LinkController {

    @Autowired
    ILinkService service;

    @GetMapping("/create")
    public ResponseEntity<?> createLink(@RequestParam String url,
                                        @RequestParam(required = false) String password) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createLink(url,password));
    }

    @GetMapping("/link/{id}")
    public RedirectView redirect(@PathVariable int id,
                                 @RequestParam(required = false) String password) {
        return new RedirectView(service.getRedirectUrl(id,password));
    }

    @GetMapping("/metrics/{id}")
    public Integer getMetrics(@PathVariable int id) {
        return service.getRedirectCount(id);
    }

    @PostMapping("/invalidate/{id}")
    public ResponseEntity<?> invalidate(@PathVariable int id) {
        service.invalidateLink(id);
        return ResponseEntity.status(HttpStatus.OK).body("Link invalidado");
    }

}
