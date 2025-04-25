package com.example.ejyoutuber.service;

import com.example.ejyoutuber.dto.BlogDto;
import com.example.ejyoutuber.exception.InstanceAlreadyExistException;
import com.example.ejyoutuber.exception.NotFoundException;
import com.example.ejyoutuber.model.BlogEntry;
import com.example.ejyoutuber.repository.IBlogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    IBlogRepository repository;

    @Override
    public String addBlog(BlogDto blog) {
        List<BlogEntry> blogEntries = repository.findAll();
        ObjectMapper mapper = new ObjectMapper();
        for (BlogEntry blogEntry : blogEntries){
            if(blogEntry.getId().equals(blog.getId())){
                throw new InstanceAlreadyExistException("Ya existe un blog con el Id: " + blog.getId());
            }
        }
        repository.loadBlog(mapper.convertValue(blog, BlogEntry.class));
        return "Se agrego de manera exitosa el blog";

    }

    @Override
    public BlogDto findBlogById(String id) {
        List<BlogEntry> blogEntries = repository.findAll();
        ObjectMapper mapper = new ObjectMapper();
        for(BlogEntry blog : blogEntries){
            if(blog.getId().equals(id)){
                return mapper.convertValue(blog, BlogDto.class);
            }
        }
        throw new NotFoundException("No se encotro ningun blog con el id: " + id);
    }

    @Override
    public List<BlogDto> findBlogs() {
        List<BlogEntry> blogEntries = repository.findAll();
        ObjectMapper mapper = new ObjectMapper();
        List<BlogDto> blogDtoList = blogEntries.stream().map(b-> mapper.convertValue(b, BlogDto.class))
                .toList();

        if(blogDtoList.isEmpty()){
            throw new NotFoundException("No se encotro ningun blog");
        }
        return blogDtoList;
    }
}
