package com.mercadolibre.blogapi.service;

import com.mercadolibre.blogapi.dto.BlogDto;
import com.mercadolibre.blogapi.exception.DuplicateEntryExcpetion;
import com.mercadolibre.blogapi.mapper.BlogMapper;
import com.mercadolibre.blogapi.repository.IBlogRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BlogService implements IBlogService {

    private final IBlogRepository entradaBlogRepository;

    public BlogService(IBlogRepository entradaBlogRepository) {
        this.entradaBlogRepository = entradaBlogRepository;
    }

    @Override
    public BlogDto save(BlogDto blogDto) {

        if (Objects.nonNull(entradaBlogRepository.findById(blogDto.getId()))){
            throw new DuplicateEntryExcpetion("Blog Already Exist");
        }
        Long idSaved = entradaBlogRepository.save(BlogMapper.blogDtoToBlog(blogDto));
        BlogDto blogDtoReturn = new BlogDto();
        blogDtoReturn.setId(idSaved);

        return blogDtoReturn;
    }
}
