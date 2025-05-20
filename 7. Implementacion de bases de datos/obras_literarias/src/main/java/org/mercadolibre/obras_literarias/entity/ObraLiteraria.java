package org.mercadolibre.obras_literarias.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Document(indexName = "obra-literaria")
public class ObraLiteraria {
    @Id
    private String id;
    private String nombre;
    private String autor;
    private int cantPaginas;
    private String editorial;
    private int anioPublicacion;
}
