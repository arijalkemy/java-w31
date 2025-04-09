package com.mercadolibre.maolaya.ejercicio_blog.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadolibre.maolaya.ejercicio_blog.dto.BlogEntryDto;
import com.mercadolibre.maolaya.ejercicio_blog.exception.IdDuplicatedException;
import com.mercadolibre.maolaya.ejercicio_blog.exception.NotFoundException;
import com.mercadolibre.maolaya.ejercicio_blog.model.BlogEntry;
import com.mercadolibre.maolaya.ejercicio_blog.repository.BlogRepository;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    public String createNewBlog(BlogEntryDto blogEntryDto) {
        if (isBlogEntryValid(blogEntryDto.getId())) {
            throw new IdDuplicatedException("Ya existe un blog con este id: " + blogEntryDto.getId());
        }
        BlogEntry blogEntry = new BlogEntry(
                blogEntryDto.getId(),
                blogEntryDto.getTitle(),
                blogEntryDto.getAuthor(),
                LocalDate.parse(blogEntryDto.getPublicationDate()));
        blogRepository.saveBlogEntry(blogEntry);
        return "Blog entry created successfully id: " + blogEntry.getId();
    }

    public Boolean isBlogEntryValid(Integer id) {
        return blogRepository.existBlogEntry(id);
    }

    public BlogEntryDto getBlogById(Integer id) {
        if (!isBlogEntryValid(id)) {
            throw new NotFoundException("No existe un blog con este id: " + id);
        } else {
            BlogEntry blogEntry = blogRepository.getBlogEntryById(id);
            return new BlogEntryDto(
                    blogEntry.getId(),
                    blogEntry.getTitle(),
                    blogEntry.getAuthor(),
                    blogEntry.getPublicationDate().toString());
        }
    }

    public List<BlogEntryDto> getAllBlogs() {
        List<BlogEntry> blogEntries = blogRepository.getAll();
        List<BlogEntryDto> blogEntriesDto = new ArrayList<>();
        for (BlogEntry blogEntry : blogEntries) {
            blogEntriesDto.add(new BlogEntryDto(blogEntry.getId(), blogEntry.getTitle(), blogEntry.getAuthor(),
                    blogEntry.getPublicationDate().toString()));
        }
        return blogEntriesDto;
    }
}
