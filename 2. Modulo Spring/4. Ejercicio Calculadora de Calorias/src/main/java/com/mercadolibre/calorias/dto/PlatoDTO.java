package com.mercadolibre.calorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatoDTO {
    private String nombrePlato;
    private int peso; // en gramos
    private int totalCalorias;
    private List<IngredienteDTO> ingredientes;
    private IngredienteDTO maxCaloriasIngrediente;
}

