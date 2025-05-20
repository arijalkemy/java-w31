package com.mercadolibre.obrasliterarias.service;

import com.mercadolibre.obrasliterarias.domain.Libro;
import com.mercadolibre.obrasliterarias.repository.ILibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
 @Service
public class LibroServiceImpl implements ILibroService{

    private ILibroRepository libroRepository;

     public LibroServiceImpl(ILibroRepository libroRepository) {
         this.libroRepository = libroRepository;
     }

     @Override
    public List<Libro> getByAutor(String autor) {
        return libroRepository.findLibroByAutor(autor);
    }

     @Override
     public List<Libro> getByNombre(String nombre) {
         return libroRepository.findByNombre(nombre);
     }

     @Override
     public List<Libro> getByYear(Long year) {
         return libroRepository.findByYear(year);
     }

     @Override
     public List<Libro> getByEditorial(String editorial) {
         return libroRepository.findLibroByEditorial(editorial);
     }

     @Override
     public List<Libro> getTopFive() {
         return libroRepository.findTop5ByOrderByCantidadPaginasDesc();
     }


 }
