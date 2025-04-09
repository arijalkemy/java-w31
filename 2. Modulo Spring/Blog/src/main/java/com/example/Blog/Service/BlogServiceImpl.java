package com.example.Blog.Service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.Blog.DTO.BlogEntryDTO;
import com.example.Blog.Entities.BlogEntry;
import com.example.Blog.Exceptions.BadRequestException;
import com.example.Blog.Exceptions.EntryAlreadyExistsException;
import com.example.Blog.Exceptions.NotFoundException;
import com.example.Blog.Repository.BlogRepositoryImpl;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepositoryImpl repository;

    @Override
    public ResponseEntity<String> newEntry(BlogEntry entry) {
        if (entry == null) {
            throw new BadRequestException("No se puede crear una entrada de blog vacía.");
        }
        if (repository.getEntry(entry.getId()) != null) {
            throw new EntryAlreadyExistsException("No puede crearse la entrada. Ya existe una entrada con id " + entry.getId());
        }
        repository.newEntry(entry);
        return new ResponseEntity<>("Entrada id " + entry.getId() + " creada exitosamente.", HttpStatus.OK);
    }

    @Override
    public BlogEntryDTO getEntry(String id) {
        BlogEntry entry = repository.getEntry(id);
        if (entry == null) {
            throw new NotFoundException("No se encontró una entrada con id " + id);
        }
        return BlogEntryDTO.blogEntryToDTO(entry);
    }

    @Override
    public List<BlogEntryDTO> getAll() {
        return repository.getAll()
                         .stream()
                         .map(BlogEntryDTO::blogEntryToDTO)
                         .collect(Collectors.toList());
    }
}
