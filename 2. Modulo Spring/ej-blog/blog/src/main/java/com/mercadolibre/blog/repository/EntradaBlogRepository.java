package com.mercadolibre.blog.repository;

import com.mercadolibre.blog.model.EntradaBlog;

import java.util.List;


public interface EntradaBlogRepository {

    EntradaBlog createBlog(EntradaBlog blog);

    EntradaBlog findById(String id);

    List<EntradaBlog> findAll();

    Boolean alreadyExists(String id);

}
