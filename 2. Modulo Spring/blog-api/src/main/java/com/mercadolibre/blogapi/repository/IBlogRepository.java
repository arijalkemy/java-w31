package com.mercadolibre.blogapi.repository;

import com.mercadolibre.blogapi.model.Blog;

public interface IBlogRepository {

    Long save(Blog entradaBlog);

    Blog findById(Long id);


}
