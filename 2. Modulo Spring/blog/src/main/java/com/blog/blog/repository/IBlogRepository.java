package com.blog.blog.repository;

import com.blog.blog.dto.EntradaBlogDTO;
import com.blog.blog.model.EntradaBlog;

import java.util.List;

public interface IBlogRepository {
    public void init();
    public List<EntradaBlog> getAllEntradaBlog();
    public void save(EntradaBlog e);
    public EntradaBlog findById(Integer id);
}
