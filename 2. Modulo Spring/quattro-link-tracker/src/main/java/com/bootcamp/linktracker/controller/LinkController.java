package com.bootcamp.linktracker.controller;

import com.bootcamp.linktracker.dto.LinkDto;
import com.bootcamp.linktracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LinkController {

    @Autowired
    ILinkService linkService;

    @PostMapping("link/")
    public ResponseEntity<LinkDto> createLink(@RequestBody LinkDto linkDto, @RequestParam String password) {
        linkDto.setPassword(password);
        return new ResponseEntity<>(linkService.create(linkDto), HttpStatus.CREATED);
    }

    @GetMapping("link/{id}")
    public ResponseEntity<LinkDto> redirect(@PathVariable Integer id, @RequestParam String password) {
        LinkDto linkDto = linkService.getByIdToUpdate(id, password);
        if (linkDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.status(HttpStatus.FOUND)
                .header(HttpHeaders.LOCATION, linkDto.getUrl())
                .build();
    }

    @GetMapping("metrics/{id}")
    public ResponseEntity<LinkDto> getMetrics(@PathVariable Integer id) {
        return new ResponseEntity<>(linkService.getMetrics(id), HttpStatus.OK);
    }

    @PostMapping("invalidate/{id}")
    public ResponseEntity<?> invalidateLink(@PathVariable Integer id, @RequestParam String password) {
        if(linkService.removeById(id, password)){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Link does not exist or password is wrong");
    }
}
