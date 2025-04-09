package com.blog.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntradaBlogDTO implements Serializable {
    private Integer id;
    private String titulo, nombreAutor;
    private LocalDate fechaPublicacion;

}
