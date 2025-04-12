package com.mercadolibre.consigna.service;

import com.mercadolibre.consigna.exception.BlogNotFoundException;
import com.mercadolibre.consigna.exception.DuplicateBlogIdException;
import com.mercadolibre.consigna.model.EntradaBlog;
import com.mercadolibre.consigna.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;

    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public EntradaBlog createBlog(EntradaBlog blog) throws DuplicateBlogIdException {
        if (blogRepository.existsById(blog.getId())) {
            throw new DuplicateBlogIdException("Ya existe un blog con el ID: " + blog.getId());
        }
        blogRepository.save(blog);
        return blog;
    }

    @Override
    public EntradaBlog getBlogById(Integer id) throws BlogNotFoundException {
        EntradaBlog blog = blogRepository.findById(id);
        if (blog == null) {
            throw new BlogNotFoundException("El blog con ID: " + id + " no existe");
        }
        return blog;
    }

    @Override
    public List<EntradaBlog> getAllBlogs() {
        return new ArrayList<>(blogRepository.findAll().values());
    }
}