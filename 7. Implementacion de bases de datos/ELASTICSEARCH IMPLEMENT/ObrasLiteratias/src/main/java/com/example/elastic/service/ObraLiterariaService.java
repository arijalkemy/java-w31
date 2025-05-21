package com.example.elastic.service;

import com.example.elastic.model.ObraLiteraria;
import com.example.elastic.repository.ObraLiterariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ObraLiterariaService implements IObraLiterariaService {
    @Autowired
    ObraLiterariaRepository repository;

    public ObraLiteraria save(ObraLiteraria obra) {
        return repository.save(obra);
    }

    public List<ObraLiteraria> findByAuthorContainingIgnoreCase(String author) {
        return repository.findByAuthorContainingIgnoreCase(author);
    }

    public List<ObraLiteraria> findByNameContainingIgnoreCase(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    public List<ObraLiteraria> topFiveCountPage() {
        return repository.findAll().stream()
                .sorted(Comparator.comparingInt(ObraLiteraria::getCountPage).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }

    public List<ObraLiteraria> publishedBefore(int year) {
        return repository.findByYearPublicationLessThan(year);
    }

    public List<ObraLiteraria> findByEditorial(String editorial) {
        return repository.findByEditorialIgnoreCase(editorial);
    }
}
