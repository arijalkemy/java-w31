package com.bootcamp.ej_linktracker.controller;

import com.bootcamp.ej_linktracker.model.LinkDto;
import com.bootcamp.ej_linktracker.service.LinkService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/link")
public class LinkController {
    @Autowired
    private LinkService linkService;

    @PostMapping
    public ResponseEntity<String> createLink(@RequestParam String url, @RequestParam(required = false) String password) {
        int linkId = linkService.createLink(url, password);
        return ResponseEntity.ok("{linkId: " + linkId + "}");
    }

    @GetMapping("/{linkId}")
    public void redirect(@PathVariable int linkId, @RequestParam(required = false) String password, HttpServletResponse response) throws Exception {
        LinkDto link = linkService.getLinkById(linkId);
        if (link.getPassword() != null && !link.getPassword().equals(password)) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Contraseña incorrecta.");
            return;
        }
        linkService.incrementVisitCount(linkId);
        response.sendRedirect(link.getUrl());
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<String> getVisitCount(@PathVariable int linkId) {
        int visitCount = linkService.getVisitCount(linkId);
        return ResponseEntity.ok("{\"visitCount\":" + visitCount + "}");
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<String> invalidateLink(@PathVariable int linkId) {
        linkService.invalidateLink(linkId);
        return ResponseEntity.ok("Link invalidado.");
    }

}
