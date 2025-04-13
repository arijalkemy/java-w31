package com.mercadolibre.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntradaBlog {
    private String id;
    private String titulo;
    private String autor;
    private String fecha;
}
