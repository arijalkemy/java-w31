package com.example.LinkTracker.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.LinkTracker.Entities.Link;
import com.example.LinkTracker.Service.LinkTrackerService;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class LinkTrackerController {

    @Autowired
    LinkTrackerService linkTrackerService;

    @PostMapping("/newLink")
    public ResponseEntity<?> postNewLink(@RequestBody Link newLink) {        
        return new ResponseEntity<>(linkTrackerService.newLink(newLink), HttpStatus.OK);
    }
    
    @GetMapping("/link/{linkId}")
    public ResponseEntity<?> getRedirection(@PathVariable Integer linkId) {
        String url = linkTrackerService.getRedirection(linkId);
        return ResponseEntity.status(HttpStatus.FOUND)
                            .location(URI.create(url))
                            .build();
    }
    
    @GetMapping("/metrics/{linkID}")
    public ResponseEntity<?> getNumberOfRedirections(@PathVariable Integer linkID) {
        return new ResponseEntity<>(linkTrackerService.getNumberOfRedirections(linkID), HttpStatus.OK);
    }

    @PostMapping("invalidate/{linkID}")
    public ResponseEntity<?> postInvalidateLink(@PathVariable Integer linkID) {
        return new ResponseEntity<>(linkTrackerService.invalidateLink(linkID), HttpStatus.OK);
    }
}
