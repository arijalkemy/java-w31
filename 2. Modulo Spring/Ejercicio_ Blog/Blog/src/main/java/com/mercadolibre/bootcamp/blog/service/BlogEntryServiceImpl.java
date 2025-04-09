package com.mercadolibre.bootcamp.blog.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.bootcamp.blog.dto.BlogEntryDto;
import com.mercadolibre.bootcamp.blog.exceptions.ConflictExcetion;
import com.mercadolibre.bootcamp.blog.exceptions.NotFoundException;
import com.mercadolibre.bootcamp.blog.model.BlogEntry;
import com.mercadolibre.bootcamp.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogEntryServiceImpl implements IBlogEntryService{

    private IBlogRepository blogRepository;

    @Autowired
    public BlogEntryServiceImpl(IBlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public List<BlogEntryDto> getAllBlogs() {
        ObjectMapper mapper = new ObjectMapper();
        List<BlogEntry> blogEntries = blogRepository.getAllBlogEntries();
        if(blogEntries.isEmpty()) {
            throw new NotFoundException("No blogs found");
        }
        return blogEntries.stream().map(blogEntry -> mapper.convertValue(blogEntry, BlogEntryDto.class)).collect(Collectors.toList());
    }

    @Override
    public BlogEntryDto createBlogEntry(BlogEntryDto blogEntryDto){
        ObjectMapper mapper = new ObjectMapper();
        if(blogRepository.getBlogEntry(blogEntryDto.getId()) != null) {
            throw new ConflictExcetion("Blog entry with id " + blogEntryDto.getId() + " already exists");
        }
        BlogEntry createdEntry = blogRepository.save( new BlogEntry(blogEntryDto));
        return mapper.convertValue(createdEntry, BlogEntryDto.class);
    }

    @Override
    public BlogEntryDto getBlogEntryById(Long id){
        ObjectMapper mapper = new ObjectMapper();
        BlogEntry blogEntry = blogRepository.getBlogEntry(id);
        if(blogEntry == null) {
            throw new NotFoundException("Blog entry with id " + id + " not found");
        }
        return mapper.convertValue(blogEntry, BlogEntryDto.class);
    }


}
