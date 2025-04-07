package com.bootcamp.age;

import org.apache.coyote.Response;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/")
public class AgeController {
    @GetMapping(path = "{day}/{month}/{year}")
    public ResponseEntity<String> getAge(@PathVariable Integer day,
                                         @PathVariable Integer month,
                                         @PathVariable Integer year) {
        LocalDate today = LocalDate.now();
        LocalDate date;
        try{
            if (year.toString().length() != 4) {
                throw new DateTimeException("Invalid year: " + year);
            }
            date = LocalDate.of(year, month, day);
        } catch (DateTimeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        if (date.isAfter(today)) {
            return new ResponseEntity<>("Date cannot be in the future", HttpStatus.BAD_REQUEST);
        }

        int age = Period.between(date, today).getYears();
        return new ResponseEntity<>("Age: " + age, HttpStatus.OK);
    }
}
