package com.mercadolibre.blog.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.blog.dto.BlogDTO;
import com.mercadolibre.blog.exception.BlogAlreadyCreatedException;
import com.mercadolibre.blog.exception.BlogNotFoundException;
import com.mercadolibre.blog.model.Blog;
import com.mercadolibre.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public void postNewBlog(BlogDTO blogDTO) {
        if (blogRepository.findById(blogDTO.getId()) != null) {
            throw new BlogAlreadyCreatedException("Ya existe un post con ese ID");
        }

        Blog newBlog = new Blog(blogDTO.getId(), blogDTO.getTitle(), blogDTO.getAuthor(), blogDTO.getPublishDate());
        blogRepository.saveNewBlog(newBlog);
    }

    @Override
    public BlogDTO findById(Integer id) {
        Blog blog = blogRepository.findById(id);
        if (blog == null) {
            throw new BlogNotFoundException("No existe un post con ese ID");
        }

        return new BlogDTO(blog.getId(), blog.getTitle(), blog.getAuthor(), blog.getPublishDate());
    }

    @Override
    public HashMap<Integer, BlogDTO> findAll() {
        ObjectMapper mapper = new ObjectMapper();

        return blogRepository.findAll().entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> mapper.convertValue(entry.getValue(), BlogDTO.class),
                        (oldValue, newValue) -> oldValue,
                        HashMap::new
                ));
    }
}
