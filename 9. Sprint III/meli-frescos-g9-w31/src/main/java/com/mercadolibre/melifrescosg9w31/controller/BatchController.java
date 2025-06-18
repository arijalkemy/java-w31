package com.mercadolibre.melifrescosg9w31.controller;

import com.mercadolibre.melifrescosg9w31.dtos.response.BatchResponseDTO;
import com.mercadolibre.melifrescosg9w31.service.IBatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fresh-products/batch")
@RequiredArgsConstructor
public class BatchController {

    private final  IBatchService IBatchService;

    @GetMapping("/list/due-date/{cantDays}")
    public ResponseEntity<BatchResponseDTO> getBatchesByDueDate(@PathVariable Integer cantDays, @RequestParam(required = false) String category, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(IBatchService.getExpiringBatches(cantDays, category, order), HttpStatus.OK);
    }
}
