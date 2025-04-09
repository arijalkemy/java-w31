package com.mercadolibre.blog.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.blog.dto.BlogPostDTO;
import com.mercadolibre.blog.exception.BlogAlreadyCreatedException;
import com.mercadolibre.blog.exception.BlogNotFoundException;
import com.mercadolibre.blog.model.BlogPost;
import com.mercadolibre.blog.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BlogPostService implements IBlogPostService{
    @Autowired
    BlogPostRepository blogRep;

    @Override
    public void createBlog(BlogPostDTO blogDTO) {
        BlogPost blogPrueba = this.blogRep.findById(blogDTO.getId_blog());
        if (blogPrueba != null) {
           throw new BlogAlreadyCreatedException("Este blog ya fue creado");

        }
        BlogPost blog = new BlogPost(blogDTO.getId_blog(), blogDTO.getBlog_title(), blogDTO.getAuthor_name(),
                blogDTO.getDate_of_publication());
        this.blogRep.saveBlog(blog);
    }

    @Override
    public BlogPostDTO getBlogById(Integer id) {
        BlogPost blog = this.blogRep.findById(id);
        if(blog == null){
            throw new BlogNotFoundException("No existe blog con ese id");
        }
        BlogPostDTO blogDTO = new BlogPostDTO(id, blog.getBlog_title(), blog.getAuthor_name(),
                blog.getDate_of_publication());
        return blogDTO;
    }

    @Override
    public HashMap<Integer, BlogPostDTO> getListOfBlogs() {
        ObjectMapper mapper = new ObjectMapper();
        HashMap<Integer, BlogPostDTO> blogsDTO = this.blogRep.findAll().entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> mapper.convertValue(entry.getValue(), BlogPostDTO.class),
                        (oldValue, newValue) -> oldValue,
                        HashMap::new
                ));
        return blogsDTO;
    }
}
