package com.bootcamp.blog.service;

import com.bootcamp.blog.dto.BlogEntryDto;

import java.util.List;

public interface IBlogService {
    List<BlogEntryDto> getAll();
    BlogEntryDto getById(Integer id);
    BlogEntryDto addEntry(BlogEntryDto entry);
}
