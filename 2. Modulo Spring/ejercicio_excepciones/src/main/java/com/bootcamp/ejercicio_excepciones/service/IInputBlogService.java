package com.bootcamp.ejercicio_excepciones.service;


import com.bootcamp.ejercicio_excepciones.dto.InputBlogDto;

import java.util.List;

public interface IInputBlogService {
    Integer saveInputBlog(InputBlogDto inputBlogDto);
    InputBlogDto findById(Integer id);
    List<InputBlogDto> findAll();
}
