package com.blog.blog.service;

import com.blog.blog.dto.EntradaBlogDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IBlogService {
    public ResponseEntity<?> add(EntradaBlogDTO e);
    public EntradaBlogDTO findById(Integer id);
    public List<EntradaBlogDTO> getAll();
}
