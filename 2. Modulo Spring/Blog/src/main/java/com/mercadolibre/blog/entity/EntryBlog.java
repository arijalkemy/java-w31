package com.mercadolibre.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EntryBlog {
    private int id;
    private String title;
    private String name;
    private String date;


}
