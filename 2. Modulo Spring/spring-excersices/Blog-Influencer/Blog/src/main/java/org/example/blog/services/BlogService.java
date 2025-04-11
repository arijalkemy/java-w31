package org.example.blog.services;

import org.example.blog.DTO.EntradaBlogDTO;
import org.example.blog.entities.EntradaBlog;
import org.example.blog.exceptions.DuplicateIdBlog;
import org.example.blog.repositories.BlogRepository;
import org.example.blog.util.Mapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


@Service
public class BlogService implements IBlogService{

    BlogRepository blogRepository;
    Mapper mapper;


    public BlogService(BlogRepository blogRepository, Mapper mapper) {
        this.blogRepository = blogRepository;
        this.mapper = mapper;
    }

    public EntradaBlogDTO createBlog(EntradaBlogDTO entradaBlogDTO) {
        EntradaBlog blogTemp = blogRepository.getBlogById(entradaBlogDTO.getId());
        if(!Objects.isNull(blogTemp)){
            throw new DuplicateIdBlog("El blog ya existe");
        }
        EntradaBlog blog = mapper.mapBlog(entradaBlogDTO);
        blogRepository.createBlog(blog);
        return mapper.mapEntradaBlog(blog);
    }

    @Override
    public EntradaBlogDTO getBlogById(int id) {
        return mapper.mapEntradaBlog(blogRepository.getBlogById(id));
    }

    @Override
    public List<EntradaBlogDTO> getAllBlogs() {
        return blogRepository.getBlogs().stream()
                .map(mapper::mapEntradaBlog)
                .toList();
    }

}
