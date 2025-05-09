package com.mercadolibre.blog.service;

import com.mercadolibre.blog.dto.EntryBlogDto;
import com.mercadolibre.blog.entity.EntryBlog;
import com.mercadolibre.blog.exception.NotFoundException;
import com.mercadolibre.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl implements IBlogService {

    private final IBlogRepository blogRepository;

    @Autowired
    public BlogServiceImpl(IBlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public EntryBlogDto createBlog(EntryBlogDto entryBlogDto) {
        EntryBlog blog = new EntryBlog(entryBlogDto.getId(), entryBlogDto.getTitle(), entryBlogDto.getName(), entryBlogDto.getDate());
        EntryBlog createdBlog = blogRepository.save(blog);
        return new EntryBlogDto(createdBlog.getId(), createdBlog.getTitle(), createdBlog.getName(), createdBlog.getDate());
    }

    @Override
    public EntryBlogDto getBlogById(Integer id) {
        EntryBlog blog = blogRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Blog not found with id " + id));
        return new EntryBlogDto(blog.getId(), blog.getTitle(), blog.getName(), blog.getDate());
    }

    @Override
    public List<EntryBlogDto> getAllBlogs() {
        return blogRepository.findAll().stream()
                .map(blog -> new EntryBlogDto(blog.getId(), blog.getTitle(), blog.getName(), blog.getDate()))
                .collect(Collectors.toList());
    }
}

