package com.blog.blog.mapper;

import com.blog.blog.dto.EntradaBlogDTO;
import com.blog.blog.model.EntradaBlog;

public interface IMapper {
    public EntradaBlogDTO entradaBlogToEntradaBlogDTO(EntradaBlog e);
    public EntradaBlog entradaBlogDTOToEntradaBlog(EntradaBlogDTO e);
}
