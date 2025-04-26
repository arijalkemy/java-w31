package com.bootcamp.blog.repository;

import com.bootcamp.blog.dto.BlogDTO;
import com.bootcamp.blog.exeptions.DuplicatedEntryException;
import com.bootcamp.blog.exeptions.NotFoundEntryException;
import com.bootcamp.blog.model.Blog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepositoryImpl implements IBlogRepository{
    private List<Blog> listaBlogs= new ArrayList();

    @Override
    public void saveBlog(Blog blog) {
        if(listaBlogs.stream().anyMatch(b-> b.getId().equals(blog.getId()))) {
            throw new DuplicatedEntryException("Blog existente con el id: " + blog.getId());
        }
        listaBlogs.add(blog);
    }

    @Override
    public Blog getById(Long id) {
        return listaBlogs.stream().filter(blog -> blog.getId().equals(id)).findFirst()
                .orElseThrow(()->new NotFoundEntryException("No se encontro el blog con el id: " + id));
    }

    @Override
    public List<Blog> getAll() {
        return listaBlogs;
    }
}
