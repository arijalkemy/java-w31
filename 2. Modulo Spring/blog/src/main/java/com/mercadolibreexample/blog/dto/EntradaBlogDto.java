package com.mercadolibreexample.blog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class EntradaBlogDto {
    private String title;
    private String nameAutor;
    private LocalDate publication;
}
