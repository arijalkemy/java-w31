package com.bootcamp.obrasliterarias.dto;

import com.bootcamp.obrasliterarias.domain.ObraLiteraria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ObraLiterariaDto {
    private String nombre;
    private String autor;
    private Integer cantidadDePaginas;
    private String editorial;
    private Integer anioPublicacion;

    public static ObraLiterariaDto fromEntity(ObraLiteraria obra) {
        return new ObraLiterariaDto(
                obra.getNombre(),
                obra.getAutor(),
                obra.getCantidadDePaginas(),
                obra.getEditorial(),
                obra.getAnioPublicacion());
    }

    public ObraLiteraria toEntity() {
        ObraLiteraria obra = new ObraLiteraria();
        obra.setNombre(nombre);
        obra.setAutor(autor);
        obra.setCantidadDePaginas(cantidadDePaginas);
        obra.setEditorial(editorial);
        obra.setAnioPublicacion(anioPublicacion);

        return obra;
    }
}
