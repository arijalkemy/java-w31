package com.mercadolibre.contador.calorias.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlateDto implements Serializable{
    private List<IngredientDto> listIngredientDto;
}
