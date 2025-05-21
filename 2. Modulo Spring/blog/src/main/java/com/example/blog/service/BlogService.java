package com.example.blog.service;

import com.example.blog.dto.EntradaBlogDto;
import com.example.blog.entity.EntradaBlog;
import com.example.blog.exception.NotFoundException;
import com.example.blog.repository.IBlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService implements IBlogService {

    private final IBlogRepository blogRepository;

    public BlogService(IBlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public EntradaBlogDto createBlog(EntradaBlogDto eBlogDto) {
        EntradaBlog blog = new EntradaBlog(eBlogDto.getId(),eBlogDto.getTitulo()
        ,eBlogDto.getNombre_autor(), eBlogDto.getFecha_publicacion());

        EntradaBlog created = blogRepository.save(blog);

        return new EntradaBlogDto(created.getId(),
                created.getTitulo(), created.getNombre_autor(), created.getFecha_publicacion());
    }

    @Override
    public EntradaBlogDto getById(Integer id) {
        EntradaBlog blog = blogRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("El blog no se encuentra."));
        return new EntradaBlogDto(blog.getId(), blog.getTitulo(), blog.getNombre_autor(),
                blog.getFecha_publicacion());
    }

    @Override
    public List<EntradaBlogDto> getAllDto() {
        return blogRepository.findAll()
                .stream().map(blog-> new EntradaBlogDto(blog.getId(), blog.getTitulo(), blog.getNombre_autor(),
                        blog.getFecha_publicacion()))
                        .collect(Collectors.toList());
    }
}
