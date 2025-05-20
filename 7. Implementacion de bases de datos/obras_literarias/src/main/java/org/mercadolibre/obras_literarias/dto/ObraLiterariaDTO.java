package org.mercadolibre.obras_literarias.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ObraLiterariaDTO {
    @Id
    private String id;
    private String nombre;
    private String autor;
    private int cantPaginas;
    private String editorial;
    private int anioPublicacion;
}
