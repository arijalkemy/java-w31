package com.mercadolibre.obrasliterarias.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ObraLiterariaDto {
    private String id;
    private String nombre;
    private String autor;
    private String cantidadPaginas;
    private String editorial;
    private String anioPrimeraPublicacion;
}
