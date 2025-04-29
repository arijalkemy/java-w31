package com.bootcamp.blogs.service;

import com.bootcamp.blogs.dto.BlogDto;
import com.bootcamp.blogs.dto.BlogDtoRequest;
import com.bootcamp.blogs.entity.EntryBlog;
import com.bootcamp.blogs.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    BlogRepository blogRepository;
    @Override
    public BlogDto create(BlogDtoRequest req) throws Exception {
        EntryBlog blog = new EntryBlog(req.getId(), req.getTitulo(), req.getNombreAutor(), req.getFechaPublicacion());
        EntryBlog blogResponse = blogRepository.create(blog);
        return new BlogDto(blogResponse.getId(), blogResponse.getTitulo(),
                blogResponse.getNombreAutor(), blogResponse.getFechaPublicacion());
    }
}
