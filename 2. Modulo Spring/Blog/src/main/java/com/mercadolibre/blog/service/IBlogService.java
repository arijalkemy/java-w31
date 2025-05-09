package com.mercadolibre.blog.service;

import com.mercadolibre.blog.dto.EntryBlogDto;

import java.util.List;

public interface IBlogService {
    EntryBlogDto createBlog(EntryBlogDto entryBlogDto);

    EntryBlogDto getBlogById(Integer id);

    List<EntryBlogDto> getAllBlogs();
}
