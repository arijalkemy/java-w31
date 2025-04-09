package com.bootcamp.ejercicio_excepciones.repository;

import com.bootcamp.ejercicio_excepciones.exception.AlreadyExistException;
import com.bootcamp.ejercicio_excepciones.exception.NotFoundException;
import com.bootcamp.ejercicio_excepciones.model.InputBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class InputBlogRepository implements IInputBlogRepository {
    private List<InputBlog> inputBlogs = new ArrayList<>();

    @Override
    public Integer save(InputBlog inputBlog) {
        if(inputBlogs.stream().anyMatch(inputBlog1 -> Objects.equals(inputBlog1.getId(), inputBlog.getId()))) {
            throw new AlreadyExistException("El id del blog ya existe");
        }
        inputBlogs.add(inputBlog);
        return inputBlog.getId();
    }

    @Override
    public InputBlog findById(Integer id) {
        InputBlog inputBlog1 = inputBlogs.stream().filter(inputBlog -> Objects.equals(inputBlog.getId(), id)).findFirst().orElse(null);
        if(inputBlog1 == null) {
            throw new NotFoundException("El blog no existe");
        }
        return inputBlog1;
    }

    @Override
    public List<InputBlog> findAll() {
        return inputBlogs;
    }
}
