package com.mercadolibre.demo.dto;

import com.mercadolibre.demo.model.MiniSerie;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CapituloDTO {
        private Long id;
        private String name;
        private Double raiting;
        private Integer duracion;
        private MiniSerie miniSerie;
    }

