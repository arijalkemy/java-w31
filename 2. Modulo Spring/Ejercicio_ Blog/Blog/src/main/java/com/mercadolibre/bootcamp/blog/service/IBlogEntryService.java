package com.mercadolibre.bootcamp.blog.service;

import com.mercadolibre.bootcamp.blog.dto.BlogEntryDto;

import java.util.List;

public interface IBlogEntryService {
    List<BlogEntryDto> getAllBlogs();
    BlogEntryDto createBlogEntry(BlogEntryDto blogEntryDto);
    BlogEntryDto getBlogEntryById(Long id);
}
