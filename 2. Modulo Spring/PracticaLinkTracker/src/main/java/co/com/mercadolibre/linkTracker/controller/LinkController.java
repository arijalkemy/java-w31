package co.com.mercadolibre.linkTracker.controller;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.mercadolibre.linkTracker.dto.LinkDto;
import co.com.mercadolibre.linkTracker.service.LinkService;

@RestController
public class LinkController {

    private final LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/create")
    public ResponseEntity<LinkDto> createLink(@RequestBody LinkDto linkDto) throws MalformedURLException, URISyntaxException {
        return new ResponseEntity<>(linkService.save(linkDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Void> redirectUrl(@PathVariable Long id){
        return new ResponseEntity<>(linkService.redirect(id), HttpStatus.FOUND);
    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<LinkDto> getMetrics(@PathVariable Long id){
        return new ResponseEntity<>(linkService.getMetricsById(id), HttpStatus.OK);
    }
    
}
