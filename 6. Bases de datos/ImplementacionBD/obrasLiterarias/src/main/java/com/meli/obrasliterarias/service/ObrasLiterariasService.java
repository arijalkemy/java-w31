package com.meli.obrasliterarias.service;

import com.meli.obrasliterarias.model.ObraLiteraria;

import java.util.List;

public interface ObrasLiterariasService {
    String saveObras(List<ObraLiteraria> obraLiteraria);
    List<ObraLiteraria> findAll();
    List<ObraLiteraria> findByAuthor(String author);
    List<ObraLiteraria> findByPalabraClave(String palabraClave);
    List<ObraLiteraria> findTop5ByPaginas();
    List<ObraLiteraria> findByAnoPublicacionBefore(int ano);
    List<ObraLiteraria> findByEditorial(String editorial);
}
