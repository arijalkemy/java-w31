package org.ejercicios.ytblog.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.ejercicios.ytblog.dto.BlogDTO;
import org.ejercicios.ytblog.entity.Blog;
import org.ejercicios.ytblog.exception.AlreadyExistException;
import org.ejercicios.ytblog.exception.NotFoundException;
import org.ejercicios.ytblog.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    private BlogRepository repository;
    private ObjectMapper mapper;

    public BlogService(BlogRepository repository) {
        this.repository = repository;
        this.mapper = new ObjectMapper();
    }

    public int addBlog(BlogDTO blogDto) {
        if(repository.idAlreadyExists(blogDto.getId())) {
            throw new AlreadyExistException("Blog id already exists");
        }

        Blog blog = new Blog(blogDto.getId(), blogDto.getTitulo(), blogDto.getNombreAutor(), blogDto.getFecha());
        repository.addBlog(blog);
        return blog.getId();

    }

    public List<BlogDTO> getAllBlogs() {
        List<Blog> blogs = repository.getAllBlogs();
        return blogs.stream().map(b -> new BlogDTO(b.getId(), b.getTitulo(), b.getNombreAutor(), b.getFecha())).toList();
    }

    public BlogDTO getBlog(int id) {
        Blog blog = repository.getBlog(id);
        if(blog == null) {
            throw new NotFoundException("Blog with id: " + id + " not found");
        }

        return new BlogDTO(blog.getId(), blog.getTitulo(), blog.getNombreAutor(), blog.getFecha());
    }
}
