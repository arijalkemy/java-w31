package com.mercadolibre.consigna.service;

import com.mercadolibre.consigna.exception.BlogNotFoundException;
import com.mercadolibre.consigna.exception.DuplicateBlogIdException;
import com.mercadolibre.consigna.model.EntradaBlog;

import java.util.List;

public interface BlogService {
    EntradaBlog createBlog(EntradaBlog blog) throws DuplicateBlogIdException;
    EntradaBlog getBlogById(Integer id) throws BlogNotFoundException;
    List<EntradaBlog> getAllBlogs();
}
