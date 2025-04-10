package com.mercadolibre.bootcamp.linktracker.controller;

import com.mercadolibre.bootcamp.linktracker.dto.LinkDto;
import com.mercadolibre.bootcamp.linktracker.dto.MetricsDto;
import com.mercadolibre.bootcamp.linktracker.service.ILinkService;
import com.mercadolibre.bootcamp.linktracker.service.LinkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/links")
public class LinkController {

    private ILinkService linkService;

    @Autowired
    public LinkController(ILinkService linkService, LinkServiceImpl linkServiceImpl) {
        this.linkService = linkService;
    }

    @GetMapping
    public ResponseEntity<List<LinkDto>> findAll() {
        List<LinkDto> links = linkService.findAll();
        return ResponseEntity.ok(links);
    }

    @PostMapping
    public ResponseEntity<LinkDto> create(@RequestBody LinkDto linkDto) {
        return new ResponseEntity<>(linkService.save(linkDto),HttpStatus.CREATED);

    }

    @GetMapping("/{linkId}")
    public RedirectView redirects(@PathVariable Long linkId){
        return new RedirectView(linkService.redirectsUrl(linkId));
    }

    @GetMapping(value = "/{linkId}", params = {"password"})
    public RedirectView redirects(@PathVariable Long linkId, @RequestParam String password){
        return new RedirectView(linkService.redirectsUrl(linkId, password));
    }

    @GetMapping("/metrics/{linkID}")
    public ResponseEntity<MetricsDto> getMetricsByLinkId(@PathVariable Long linkID){
        return new ResponseEntity<>(linkService.getLinkMetrics(linkID), HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkID}")
    public ResponseEntity<LinkDto> invalidateLink(@PathVariable Long linkID){
        return new ResponseEntity<>(linkService.invalidateLink(linkID), HttpStatus.OK);

    }

}
