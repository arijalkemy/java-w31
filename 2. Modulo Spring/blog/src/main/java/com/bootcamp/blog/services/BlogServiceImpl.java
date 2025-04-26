package com.bootcamp.blog.services;

import com.bootcamp.blog.dto.BlogDTO;
import com.bootcamp.blog.model.Blog;
import com.bootcamp.blog.repository.IBlogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService{
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Long saveBlog(BlogDTO blogDTO) {
        ObjectMapper objectMapper = new ObjectMapper();
        blogRepository.saveBlog(objectMapper.convertValue(blogDTO, Blog.class));
        return blogDTO.getId();
    }

    @Override
    public BlogDTO getBlog(Long id) {
        ObjectMapper objectMapper = new ObjectMapper();
        Blog blog = blogRepository.getById(id);
        return objectMapper.convertValue(blog, BlogDTO.class);
    }

    @Override
    public List<BlogDTO> getAllBlogs() {
        ObjectMapper mapper = new ObjectMapper();
        return blogRepository.getAll().stream().map(blog -> mapper.convertValue(blog, BlogDTO.class))
                .toList();
    }
}
