package com.bootcamp.ejercicio_api_obras_literarias.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private Long id;
    private String name;
    private String author;
    private Integer pages;
    private String editorial;
    private Integer publishDate;
}
