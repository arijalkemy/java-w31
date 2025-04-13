package com.mercadolibre.blog.service;

import com.mercadolibre.blog.dto.EntradaBlogDto;
import com.mercadolibre.blog.model.EntradaBlog;

import java.util.List;

public interface BlogService {
    EntradaBlogDto createBlog(EntradaBlogDto blog);

    EntradaBlogDto findById(String id);

    List<EntradaBlogDto> findAll();
}
