package com.springexceptions.blog.service;

import com.springexceptions.blog.dto.BlogEntryDTO;
import com.springexceptions.blog.model.BlogEntry;
import com.springexceptions.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogEntryService implements IBlogEntryService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public void save(BlogEntryDTO entry) {
        BlogEntry blogEntry = new BlogEntry(
                entry.getAuthor(),
                entry.getId(),
                entry.getPublicationDate(),
                entry.getTitle());
        blogRepository.addBlogEntry(blogEntry);
    }

    public BlogEntryDTO get(Integer id) {
        BlogEntry entry = blogRepository.getBlogEntry(id);
        return new BlogEntryDTO(entry);
    }

    public List<BlogEntryDTO> getAllEntries() {
        List<BlogEntry> entries = blogRepository.getAllEntries();
        return entries.stream().map(e -> new BlogEntryDTO(e)).collect(Collectors.toList());
    }

}
