package co.com.mercadolibre.youtuber.mapper;

import co.com.mercadolibre.youtuber.dto.EntradaBlogDto;
import co.com.mercadolibre.youtuber.model.EntradaBlog;

public class EntradaBlogMapper {

    public static EntradaBlogDto toDto(EntradaBlog entradaBlog) {
        if (entradaBlog == null) return null;
        return new EntradaBlogDto(
                entradaBlog.getId(),
                entradaBlog.getTitulo(),
                entradaBlog.getAutor(),
                entradaBlog.getFechaPublicacion()
        );
    }

    public static EntradaBlog toEntity(EntradaBlogDto entradaBlogDto) {
        if (entradaBlogDto == null) return null;
        return new EntradaBlog(
                entradaBlogDto.getId(),
                entradaBlogDto.getTitulo(),
                entradaBlogDto.getAutor(),
                entradaBlogDto.getFechaPublicacion()
        );
    }
}
