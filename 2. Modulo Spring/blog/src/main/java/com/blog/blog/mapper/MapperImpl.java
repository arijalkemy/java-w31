package com.blog.blog.mapper;

import com.blog.blog.dto.EntradaBlogDTO;
import com.blog.blog.model.EntradaBlog;
import org.springframework.stereotype.Component;

@Component
public class MapperImpl implements IMapper{

    @Override
    public EntradaBlogDTO entradaBlogToEntradaBlogDTO(EntradaBlog e) {
        EntradaBlogDTO entradaBlogDTO = new EntradaBlogDTO(
                e.getId(),
                e.getTitulo(),
                e.getNombreAutor(),
                e.getFechaPublicacion());
        return entradaBlogDTO;
    }

    @Override
    public EntradaBlog entradaBlogDTOToEntradaBlog(EntradaBlogDTO e) {
        EntradaBlog entradaBlog = new EntradaBlog(
                e.getId(),
                e.getTitulo(),
                e.getNombreAutor(),
                e.getFechaPublicacion());
        return entradaBlog;
    }
}
