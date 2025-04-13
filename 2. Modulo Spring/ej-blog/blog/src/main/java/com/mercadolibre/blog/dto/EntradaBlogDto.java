package com.mercadolibre.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntradaBlogDto {
    private String id;
    private String titulo;
    private String autor;
    private String fecha;
}
