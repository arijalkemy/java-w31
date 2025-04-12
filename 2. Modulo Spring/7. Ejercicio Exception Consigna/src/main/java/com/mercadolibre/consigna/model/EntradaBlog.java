package com.mercadolibre.consigna.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntradaBlog {
    private Integer id;
    private String titulo;
    private String autor;
    private LocalDate fechaPublicacion;
}
