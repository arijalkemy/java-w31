package com.mercadolibre.blogapi.mapper;

import com.mercadolibre.blogapi.dto.BlogDto;
import com.mercadolibre.blogapi.model.Blog;

public class BlogMapper {


    public static BlogDto blogToBlogDto(Blog blog){
        return new BlogDto(
                blog.getId(),
                blog.getBlogTitle(),
                blog.getAutorName(),
                blog.getPublishDate()
        );
    }

    public static Blog blogDtoToBlog(BlogDto blogDto){
        return new Blog(
                blogDto.getId(),
                blogDto.getBlogTitle(),
                blogDto.getAutorName(),
                blogDto.getPublishDate()
        );
    }


}
