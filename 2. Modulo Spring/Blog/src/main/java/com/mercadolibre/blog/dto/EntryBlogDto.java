package com.mercadolibre.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EntryBlogDto {
    private int id;
    private String title;
    private String name;
    private String date;
}
