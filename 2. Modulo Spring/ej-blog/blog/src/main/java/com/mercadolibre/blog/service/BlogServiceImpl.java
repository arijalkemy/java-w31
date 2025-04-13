package com.mercadolibre.blog.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.blog.dto.EntradaBlogDto;
import com.mercadolibre.blog.exception.BlogConflict;
import com.mercadolibre.blog.model.EntradaBlog;
import com.mercadolibre.blog.repository.EntradaBlogRepository;
import com.mercadolibre.blog.repository.EntradaBlogRepositoryImpl;

import java.util.List;

public class BlogServiceImpl implements BlogService {

    EntradaBlogRepository entradaBlogRepository = new EntradaBlogRepositoryImpl();

    @Override
    public EntradaBlogDto createBlog(EntradaBlogDto blog) {
        if (entradaBlogRepository.alreadyExists(blog.getId())) {

            throw new BlogConflict("Ya existe un blog con ese id.");

        } else {
            ObjectMapper mapper = new ObjectMapper();

            EntradaBlog entradaBlog = mapper.convertValue(blog, EntradaBlog.class);

            EntradaBlogDto dto = mapper.convertValue(entradaBlogRepository.createBlog(entradaBlog), EntradaBlogDto.class);

            return dto;
        }
    }

    @Override
    public EntradaBlogDto findById(String id) {

        ObjectMapper mapper = new ObjectMapper();

        return mapper.convertValue(entradaBlogRepository.findById(id), EntradaBlogDto.class);
    }

    @Override
    public List<EntradaBlogDto> findAll() {

        ObjectMapper mapper = new ObjectMapper();

        return entradaBlogRepository.findAll().stream().map(eb -> mapper.convertValue(eb, EntradaBlogDto.class)).toList();
    }
}
