package com.mercadolibreexample.blog.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class EntradaBlog {
    private int id;
    private String title;
    private String nameAutor;
    private LocalDate publication;
}
