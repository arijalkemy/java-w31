package com.mercadolibre.demo.dto;

import com.mercadolibre.demo.model.Capitulo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class MiniSerieDTO {
    private Long id;
    private String name;
    private Double raiting;
    private int amountOfAwards;
    private Set<Capitulo> capitulos;


}
