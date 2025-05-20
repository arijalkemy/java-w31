package com.mercadolibre.obrasliterarias.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LiteraryWorkDTO {
    private String id;
    private String title;
    private String author;
    private int pages;
    private String publisher;
    private int year;
}
