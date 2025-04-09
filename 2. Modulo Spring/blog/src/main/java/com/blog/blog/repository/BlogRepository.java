package com.blog.blog.repository;

import com.blog.blog.dto.EntradaBlogDTO;

import java.util.List;

public interface BlogRepository {
    public void init();
    public List<EntradaBlogDTO> getAllEntradaBlog();
    public void addEntradaBlog(EntradaBlogDTO e);
}
