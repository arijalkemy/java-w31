package com.blog.blog.service;

import com.blog.blog.dto.EntradaBlogDTO;
import com.blog.blog.exceptions.EntradaExistente;
import com.blog.blog.exceptions.NotFoundException;
import com.blog.blog.repository.BlogRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogRepositoryImpl blogRepository;

    @Override
    public ResponseEntity<String> addEntrdaBlog(EntradaBlogDTO e) {
        if(blogRepository.getAllEntradaBlog().stream()
        .anyMatch(a-> a.getId().equals(e.getId()))) {
            throw new EntradaExistente("El elemento Id: "+e.getId()+ " ya existe en la BD");
        }
        blogRepository.addEntradaBlog(e);
        return ResponseEntity.status(201).body("Elemento creado con id: "+e.getId()+" creado exitosamente");
    }

    @Override
    public EntradaBlogDTO getEntradaBlog(Integer id) {
        EntradaBlogDTO entradaBlogDTO = blogRepository.getAllEntradaBlog().stream()
                .filter(a-> a.getId().equals(id))
                .findFirst()
                .orElse(null);
        if(entradaBlogDTO == null){
            throw new NotFoundException("Elemento con id: "+id +" no encontrado en la BD");
        }
        return entradaBlogDTO;
    }

    @Override
    public List<EntradaBlogDTO> getAllEntradaBlog() {
        return blogRepository.getAllEntradaBlog();
    }
}
