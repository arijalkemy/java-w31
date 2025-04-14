package com.bootcamp.ej_blog.service;

import com.bootcamp.ej_blog.exception.BlogAlreadyExistsException;
import com.bootcamp.ej_blog.exception.BlogNotFoundException;
import com.bootcamp.ej_blog.model.EntradaBlog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BlogService {
    private final Map<Integer, EntradaBlog> blogRepository = new HashMap<>();
    private int nextId = 1;

    public EntradaBlog crearEntrada(String titulo, String autor) {
        //verificacion si ya existe id
        if(blogRepository.containsKey(nextId)){
            throw new BlogAlreadyExistsException(nextId);
        }
        EntradaBlog nuevaEntrada = new EntradaBlog(nextId, titulo, autor, java.time.LocalDate.now());
        blogRepository.put(nextId, nuevaEntrada);
        nextId++;
        return nuevaEntrada;
    }

    public EntradaBlog obtenerEntradaPorId(int id) {
        EntradaBlog entradaBlog = blogRepository.get(id);
        if (entradaBlog == null) {
            throw new BlogNotFoundException(nextId);
        }
        return entradaBlog;
    }

    public List<EntradaBlog> listarEntradas() {
        return new ArrayList<>(blogRepository.values());
    }
}
