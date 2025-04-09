package org.mercadolibre.ejercicio_blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntradaBlogDTO {
    private int id;
    private String titulo;
    private String nombreAutor;
    private String fechaPublicacion;
}
