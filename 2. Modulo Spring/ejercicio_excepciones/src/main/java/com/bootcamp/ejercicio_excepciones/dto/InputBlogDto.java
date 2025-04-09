package com.bootcamp.ejercicio_excepciones.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class InputBlogDto implements Serializable {
    private Integer id;
    private String title;
    private String author;
    private String postDate;
}
