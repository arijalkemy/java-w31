package com.bootcamp.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Blog {
    private Long id;
    private String titulo, nombreAutor, fechaDePublicacion;
}
