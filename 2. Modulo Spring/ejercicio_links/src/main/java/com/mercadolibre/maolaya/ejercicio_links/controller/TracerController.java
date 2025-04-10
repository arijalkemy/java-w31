package com.mercadolibre.maolaya.ejercicio_links.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.mercadolibre.maolaya.ejercicio_links.dto.LinkDto;
import com.mercadolibre.maolaya.ejercicio_links.service.TracerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class TracerController {

    @Autowired
    TracerService tracerService;

    @PostMapping("/createUrl")
    public LinkDto postUrl(@RequestBody LinkDto linkDto) {
        return tracerService.createUrl(linkDto);
    }

    @GetMapping("/metrics/{linkId}")
    public Integer getMetricsUrl(@PathVariable Integer linkId) {
        return tracerService.getMetricsByLink(linkId);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<?> postInvalidateLink(@PathVariable Integer linkId) {
        tracerService.invalidateLink(linkId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/link/{linkId}")
    public RedirectView getRedirectLink(@PathVariable Integer linkId) {
        String redirectedUrl = tracerService.getRedirectLink(linkId);
        return new RedirectView(redirectedUrl);
    }

    @GetMapping(value = "/link/{linkId}", params = { "password" })
    public RedirectView getRedirectLink(@PathVariable Integer linkId, @RequestParam("password") String password) {
        String redirectedUrl = tracerService.getRedirectLink(linkId, password);
        return new RedirectView(redirectedUrl);
    }

}
