package org.mercadolibre.ejercicio_blog.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntradaBlog {
    private int id;
    private String titulo;
    private String nombreAutor;
    private String fechaPublicacion;
}
