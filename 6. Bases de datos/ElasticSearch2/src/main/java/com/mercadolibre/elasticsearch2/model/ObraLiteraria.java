package com.mercadolibre.elasticsearch2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "obras_literarias")
@AllArgsConstructor
@NoArgsConstructor
public class ObraLiteraria {
    @Id
    private Long id;
    private String nombre;
    private String autor;
    private Integer cantidadDePaginas;
    private String editorial;
    private Integer añoPublicacion;
}
