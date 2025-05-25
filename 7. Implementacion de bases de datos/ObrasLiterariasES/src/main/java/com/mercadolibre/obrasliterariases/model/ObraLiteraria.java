package com.mercadolibre.obrasliterariases.model;

import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "obras_literarias")
public class ObraLiteraria {
    @Id
    private String id;
    private String nombre;
    private String autor;
    private int cantidadPaginas;
    private String editorial;
    private int anioPublicacion;

}