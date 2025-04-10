package com.blog.blog.service;

import com.blog.blog.dto.EntradaBlogDTO;
import com.blog.blog.exceptions.EntradaExistente;
import com.blog.blog.exceptions.NotFoundException;
import com.blog.blog.mapper.IMapper;
import com.blog.blog.model.EntradaBlog;
import com.blog.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    IMapper mapper;

    @Autowired
    IBlogRepository blogRepository;


    @Override
    public ResponseEntity<String> add(EntradaBlogDTO e) {
        //Mapeo a entity
        EntradaBlog entradaBlog = mapper.entradaBlogDTOToEntradaBlog(e);

        if(blogRepository.getAllEntradaBlog().stream()
        .anyMatch(a-> a.getId().equals(entradaBlog.getId()))) {
            throw new EntradaExistente("El elemento Id: "+entradaBlog.getId()+ " ya existe en la BD");
        }

        blogRepository.save(entradaBlog);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                "El ELEMENTO: \n\nId: " + entradaBlog.getId() +
                        "\nTitulo: " + entradaBlog.getTitulo() +
                        "\nNombre de Autor: " + entradaBlog.getNombreAutor() +
                        "\nFecha Publicación: " + entradaBlog.getFechaPublicacion() +
                        "\n\nFUE CREADO EXITOSAMENTE");
    }

    @Override
    public EntradaBlogDTO findById(Integer id) {
        EntradaBlog entradaBlog = blogRepository.findById(id);

        if(entradaBlog == null){
            throw new NotFoundException("EL ELEMENTO Id: "+id +" NO SE ENCUENTRA EN LA BD");
        }
        //Mapeo a DTO y retorno
        EntradaBlogDTO entradaBlogDTO = mapper.entradaBlogToEntradaBlogDTO(entradaBlog);
        return entradaBlogDTO;
    }

    @Override
    public List<EntradaBlogDTO> getAll() {
        //Mapeo lista
        List<EntradaBlog> entradaBlogList = blogRepository.getAllEntradaBlog();
        List<EntradaBlogDTO> entradaBlogDTOList = new ArrayList<>();

        for(EntradaBlog e:entradaBlogList){
            EntradaBlogDTO entradaBlogDTO = mapper.entradaBlogToEntradaBlogDTO(e);
            entradaBlogDTOList.add(entradaBlogDTO);
        }

        return entradaBlogDTOList;
    }
}
