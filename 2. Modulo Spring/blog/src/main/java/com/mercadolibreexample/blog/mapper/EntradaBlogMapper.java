package com.mercadolibreexample.blog.mapper;

import com.mercadolibreexample.blog.dto.EntradaBlogDto;
import com.mercadolibreexample.blog.entity.EntradaBlog;

public class EntradaBlogMapper {
    static public EntradaBlog toEntradaBlog(int id, EntradaBlogDto entradaBlogDto) {
        EntradaBlog entradaBlog = new EntradaBlog();
        entradaBlog.setId(id);
        entradaBlog.setTitle(entradaBlogDto.getTitle());
        entradaBlog.setNameAutor(entradaBlogDto.getNameAutor());
        entradaBlog.setPublication(entradaBlogDto.getPublication());
        return entradaBlog;
    }

    static public EntradaBlogDto toEntradaBlogDto(EntradaBlog entradaBlog) {
        EntradaBlogDto entradaBlogDto = new EntradaBlogDto();
        entradaBlogDto.setNameAutor(entradaBlog.getNameAutor());
        entradaBlogDto.setPublication(entradaBlog.getPublication());
        entradaBlogDto.setTitle(entradaBlog.getTitle());
        return entradaBlogDto;
    }
}
