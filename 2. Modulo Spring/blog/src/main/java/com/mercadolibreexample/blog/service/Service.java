package com.mercadolibreexample.blog.service;

import com.mercadolibreexample.blog.dto.EntradaBlogDto;
import com.mercadolibreexample.blog.entity.EntradaBlog;
import com.mercadolibreexample.blog.exception.BlogNotFoundException;
import com.mercadolibreexample.blog.mapper.EntradaBlogMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class Service {
    private final List<EntradaBlog> entradaBlogDtoList = new ArrayList<>();

    public String createBlog(EntradaBlogDto entradaBlogDto) throws Exception {
        try {
            int id = entradaBlogDtoList.size();
            EntradaBlog entradaBlog = EntradaBlogMapper.toEntradaBlog(id, entradaBlogDto);
            entradaBlogDtoList.add(entradaBlog);
            return "Blog con ID: " + id + " creado correctamente.";
        }
        catch (Exception e) {
            throw new Exception("Error creando nuevo blog");
        }
    }

    public EntradaBlogDto getBlog(int id) {
        if (id < 0 || id > entradaBlogDtoList.size()) {
            throw new BlogNotFoundException("No se encontro el blog con el id solicitado.");
        }
        EntradaBlog blog = entradaBlogDtoList.get(id);
        return EntradaBlogMapper.toEntradaBlogDto(blog);
    }

    public List<EntradaBlogDto> getAllBlogs() {
        if (entradaBlogDtoList.isEmpty()) {
            throw new BlogNotFoundException("No se encontraron blogs para mostrar.");
        }

        return entradaBlogDtoList.stream()
                .map(EntradaBlogMapper::toEntradaBlogDto)
                .toList();
    }
}
