package com.mercadolibre.contadorcalorias.controller;

import com.mercadolibre.contadorcalorias.dto.IngredientDTO;
import com.mercadolibre.contadorcalorias.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ingredient")
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;

    @GetMapping("/highestCalorie")
    public IngredientDTO getIngredientWithHighestCalorie(){
      return  this.ingredientService.getIngredientWithHighestCalorie();
    }

}
