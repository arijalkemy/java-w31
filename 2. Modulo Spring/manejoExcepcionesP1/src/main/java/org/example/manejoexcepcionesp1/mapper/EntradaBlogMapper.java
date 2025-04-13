package org.example.manejoexcepcionesp1.mapper;

import org.example.manejoexcepcionesp1.dto.EntradaBlogDto;
import org.example.manejoexcepcionesp1.entity.EntradaBlog;

public abstract class EntradaBlogMapper {

    public static EntradaBlog dtoToEntity(EntradaBlogDto entradaBlogDto){
        return new EntradaBlog(
                entradaBlogDto.getId(),
                entradaBlogDto.getTitulo(),
                entradaBlogDto.getNombreAutor(),
                entradaBlogDto.getFechaPublicacion()
        );
    }

    public static EntradaBlogDto entityToDto(EntradaBlog entradaBlog){
        return new EntradaBlogDto(
                entradaBlog.getId(),
                entradaBlog.getTitulo(),
                entradaBlog.getNombreAutor(),
                entradaBlog.getFechaPublicacion()
        );
    }
}
