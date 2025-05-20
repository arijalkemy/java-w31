package com.mercadolibre.obrasliterarias.service;

import com.mercadolibre.obrasliterarias.domain.Libro;

import java.util.List;

public interface ILibroService {
    public List<Libro> getByAutor(String autor);

    public List<Libro> getByNombre(String nombre);

    public List<Libro> getByYear(Long year);

    public List<Libro> getByEditorial(String editorial);

    public List<Libro> getTopFive();

}
