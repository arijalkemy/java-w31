package com.blog.blog.service;

import com.blog.blog.dto.EntradaBlogDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BlogService {
    public ResponseEntity<String> addEntrdaBlog(EntradaBlogDTO e);
    public EntradaBlogDTO getEntradaBlog(Integer id);
    public List<EntradaBlogDTO> getAllEntradaBlog();
}
