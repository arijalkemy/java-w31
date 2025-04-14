package com.excep.excepcionesvivo.repository;

import com.excep.excepcionesvivo.exceptions.AlreadyExistException;
import com.excep.excepcionesvivo.model.Blog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class BlogRepository implements IBlogRepository{
    List<Blog> inputBlogs = new ArrayList<>();


    @Override
    public Integer save(Blog blog) {
        var existe = inputBlogs.stream().anyMatch(x->x.getId().equals(blog.getId()));
        if(existe){
            throw new AlreadyExistException("El id ya existe");
        }
        return blog.getId();
    }
}
