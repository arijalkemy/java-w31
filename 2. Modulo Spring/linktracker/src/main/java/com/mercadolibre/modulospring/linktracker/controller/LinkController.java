package com.mercadolibre.modulospring.linktracker.controller;

import com.mercadolibre.modulospring.linktracker.dto.LinkDTO;
import com.mercadolibre.modulospring.linktracker.dto.ResponseLinkDTO;
import com.mercadolibre.modulospring.linktracker.service.LinkServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LinkController {
    @Autowired
    LinkServiceIMP linkServiceIMP;
    @GetMapping("/link/{linkId}")
    public ResponseEntity<String> getLink(@PathVariable Integer linkId,@RequestParam(defaultValue = "") String password){

        return new ResponseEntity<>(linkServiceIMP.getLink(linkId,password),HttpStatus.OK);

    }
    @GetMapping("/metrics/{linkID}" )
    public ResponseEntity<String> getMetrics(@PathVariable Integer linkID){

    return new ResponseEntity<>("El numero de veces que el link fue visitado es: "+linkServiceIMP.getMetrics(linkID).toString(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseLinkDTO addLink(@RequestBody LinkDTO linkDTO){
        ResponseLinkDTO response=linkServiceIMP.addLink(linkDTO);

        return response;

    }

    @PostMapping("/invalidate/{linkID}")
    public ResponseEntity<String> invalidLink(@PathVariable Integer linkID){
        String response=linkServiceIMP.invalidLink(linkID);

        return new ResponseEntity<>(response,HttpStatus.OK);

    }

}
