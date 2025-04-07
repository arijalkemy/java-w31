package com.bootcamp.ejerciciosdtoresponseentity.controller;

import com.bootcamp.ejerciciosdtoresponseentity.dto.AgeFormatExceptionDto;
import com.bootcamp.ejerciciosdtoresponseentity.service.AgeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgeController {
    AgeService ageService;

    public AgeController(AgeService ageService) {
        this.ageService = new AgeService();
    }

    @GetMapping("/{d}/{m}/{y}")
    public Integer age(@PathVariable Integer d, @PathVariable Integer m, @PathVariable Integer y) throws AgeFormatExceptionDto {
        try{
            return ageService.actualAge(d, m, y);
        }
        catch (IllegalArgumentException e){
            throw new AgeFormatExceptionDto(e.getMessage());
        }
    }
    @ExceptionHandler(AgeFormatExceptionDto.class)
    public ResponseEntity<String> handleRuntimeException(AgeFormatExceptionDto ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Ocurrió un error: " + ex.getMessage());
    }
}
