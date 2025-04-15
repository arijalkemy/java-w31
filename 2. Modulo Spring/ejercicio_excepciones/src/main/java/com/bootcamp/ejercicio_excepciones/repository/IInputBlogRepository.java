package com.bootcamp.ejercicio_excepciones.repository;

import com.bootcamp.ejercicio_excepciones.model.InputBlog;

import java.util.List;

public interface IInputBlogRepository {
    Integer save(InputBlog inputBlog);
    InputBlog findById(Integer id);
    List<InputBlog> findAll();
}
