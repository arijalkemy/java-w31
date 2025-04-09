package com.bootcamp.ejercicio_excepciones.service;

import com.bootcamp.ejercicio_excepciones.dto.InputBlogDto;
import com.bootcamp.ejercicio_excepciones.model.InputBlog;
import com.bootcamp.ejercicio_excepciones.repository.IInputBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InputBlogService implements IInputBlogService {

    @Autowired
    private IInputBlogRepository inputBlogRepository;


    @Override
    public Integer saveInputBlog(InputBlogDto inputBlogDto) {
        return inputBlogRepository.save(new InputBlog(inputBlogDto.getId(), inputBlogDto.getTitle(), inputBlogDto.getAuthor(), inputBlogDto.getPostDate()));
    }

    @Override
    public InputBlogDto findById(Integer id) {
        InputBlog inputBlog = inputBlogRepository.findById(id);
        return new InputBlogDto(inputBlog.getId(), inputBlog.getTitle(), inputBlog.getAuthor(), inputBlog.getPostDate());
    }

    @Override
    public List<InputBlogDto> findAll() {
        return inputBlogRepository.findAll().stream().map(i -> new InputBlogDto(i.getId(), i.getTitle(), i.getAuthor(), i.getPostDate())).toList();
    }
}
