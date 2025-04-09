package org.ejercicios.ytblog.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Blog {
    private int id;
    private String titulo;
    private String nombreAutor;
    private String fecha;
}
