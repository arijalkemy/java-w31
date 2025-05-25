package com.mercadolibre.obrasliterariases.service;

import com.mercadolibre.obrasliterariases.model.ObraLiteraria;
import com.mercadolibre.obrasliterariases.repository.ObraLiterariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraLiterariaService {
    @Autowired
    private ObraLiterariaRepository repository;

    //1- Crear Obra
    public ObraLiteraria crearObra(ObraLiteraria obra) {
        return repository.save(obra);
    }

    public List<ObraLiteraria> obrasPorAutor(String autor) {
        return repository.findByAutor(autor);
    }

    public List<ObraLiteraria> obrasPorPalabraClave(String palabra) {
        return repository.findByNombreContainingIgnoreCase(palabra);
    }

    public List<ObraLiteraria> top5PorPaginas() {
        return repository.findTop5ByOrderByCantidadPaginasDesc();
    }

    public List<ObraLiteraria> obrasAntesDe(int anio) {
        return repository.findByAnioPublicacionLessThan(anio);
    }

    public List<ObraLiteraria> obrasPorEditorial(String editorial) {
        return repository.findByEditorial(editorial);
    }
}
