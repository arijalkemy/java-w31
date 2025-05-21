package com.example.elastic.service;

import com.example.elastic.model.ObraLiteraria;

import java.util.List;
import java.util.Optional;

public interface IObraLiterariaService {

    ObraLiteraria save(ObraLiteraria obra);

    List<ObraLiteraria> findByAuthorContainingIgnoreCase(String author);

    List<ObraLiteraria> findByNameContainingIgnoreCase(String name);

    List<ObraLiteraria> topFiveCountPage();

    public List<ObraLiteraria> publishedBefore(int year);

    public List<ObraLiteraria> findByEditorial(String editorial);
}
