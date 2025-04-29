package com.bootcamp.blogs.service;

import com.bootcamp.blogs.dto.BlogDto;
import com.bootcamp.blogs.dto.BlogDtoRequest;

public interface BlogService {
    public BlogDto create(BlogDtoRequest req) throws Exception;
}
