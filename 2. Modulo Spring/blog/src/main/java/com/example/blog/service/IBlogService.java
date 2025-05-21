package com.example.blog.service;

import com.example.blog.dto.EntradaBlogDto;
import com.example.blog.entity.EntradaBlog;

import java.util.List;

public interface IBlogService {
    EntradaBlogDto createBlog(EntradaBlogDto eBlogDto);

    EntradaBlogDto getById(Integer id);

    List<EntradaBlogDto> getAllDto();
}
