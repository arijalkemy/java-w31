package com.excep.excepcionesvivo.service;

import com.excep.excepcionesvivo.dto.BlogDTO;
import com.excep.excepcionesvivo.model.Blog;
import com.excep.excepcionesvivo.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository blogRepository;

    public Integer saveBlog(BlogDTO blogDto){
        return blogRepository.save(new Blog(blogDto.getId(), blogDto.getTitulo(),
                blogDto.getNombreAutor(),blogDto.getFechaPublicacion()));
    }

}
