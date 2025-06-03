package com.example.elastic.dto;

import com.example.elastic.entities.Articulo;
import lombok.Data;

@Data
public class ArticuloDTO {
    private String id;
    private String titulo;
    private Integer anio;

    public static ArticuloDTO fromEntity(Articulo articulo) {
        ArticuloDTO dto = new ArticuloDTO();
        dto.setId(articulo.getId());
        dto.setTitulo(articulo.getTitulo());
        dto.setAnio(articulo.getAnio());
        return dto;
    }

    public Articulo toEntity() {
        Articulo articulo = new Articulo();
        articulo.setId(this.id);
        articulo.setTitulo(this.titulo);
        articulo.setAnio(this.anio);
        return articulo;
    }
} 