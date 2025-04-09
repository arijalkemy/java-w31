package com.bootcamp.blog.service;

import com.bootcamp.blog.dto.BlogEntryDto;
import com.bootcamp.blog.exceptions.DuplicateEntryException;
import com.bootcamp.blog.exceptions.NotFoundException;
import com.bootcamp.blog.model.BlogEntry;
import com.bootcamp.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService implements IBlogService {

    @Autowired
    IBlogRepository blogRepository;

    @Override
    public List<BlogEntryDto> getAll() {
        List<BlogEntry> blogs = blogRepository.getAll();

        return blogs.stream()
                .map(BlogEntryDto::buildFromBlogEntry)
                .collect(Collectors.toList());
    }

    @Override
    public BlogEntryDto getById(Integer id) {
        BlogEntry blogEntry = blogRepository.getById(id);
        if (blogEntry == null) {
            throw new NotFoundException("Blog with id " + id + " not found");
        }
        return BlogEntryDto.buildFromBlogEntry(blogEntry);
    }

    @Override
    public BlogEntryDto addEntry(BlogEntryDto blogEntryDto) {
        BlogEntry blogEntry;
        if (blogRepository.existsByTitle(blogEntryDto.getTitle())) {
            blogEntry = blogRepository.getByTitle(blogEntryDto.getTitle());
            throw new DuplicateEntryException("Blog entry with title '" + blogEntryDto.getTitle()
                    + "' already exists. Posted on " + blogEntry.getPostDate().toString());
        }
        blogEntry = blogRepository.addEntry(BlogEntry.buildFromDto(blogEntryDto));
        return BlogEntryDto.buildFromBlogEntry(blogEntry);
    }
}
