package com.bootcamp.ejercicio_excepciones.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InputBlog {
    private Integer id;
    private String title;
    private String author;
    private String postDate;


}
