package com.mercadolibre.elasticsearch2.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.elasticsearch2.dto.ObraLiterariaDto;
import com.mercadolibre.elasticsearch2.model.ObraLiteraria;
import com.mercadolibre.elasticsearch2.repository.IObraLiterariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObraLiterariaService implements IObraLiterariaService {

    @Autowired
    IObraLiterariaRepository obraLiterariaRepository;


    @Override
    public ObraLiterariaDto save(ObraLiterariaDto obraLiteraria) {
        ObjectMapper objectMapper = new ObjectMapper();
        ObraLiteraria parsedObraLiteraria = objectMapper.convertValue(obraLiteraria, ObraLiteraria.class);
        return objectMapper.convertValue(obraLiterariaRepository.save(parsedObraLiteraria), ObraLiterariaDto.class);
    }

    @Override
    public List<ObraLiterariaDto> getByAutor(String autor) {
        ObjectMapper objectMapper = new ObjectMapper();
        return obraLiterariaRepository.findAllByAutor(autor).stream().map(ol -> objectMapper.convertValue(ol, ObraLiterariaDto.class)).toList();

    }

    @Override
    public List<ObraLiterariaDto> getByNombre(String nombre) {
        ObjectMapper objectMapper = new ObjectMapper();
        return obraLiterariaRepository.findAllByNombreContains(nombre).stream().map(ol -> objectMapper.convertValue(ol, ObraLiterariaDto.class)).toList();
    }

    @Override
    public List<ObraLiterariaDto> getByEditorial(String editorial) {
        ObjectMapper objectMapper = new ObjectMapper();
        return obraLiterariaRepository.findAllByEditorial(editorial).stream().map(ol -> objectMapper.convertValue(ol, ObraLiterariaDto.class)).toList();

    }

    @Override
    public List<ObraLiterariaDto> getTop5MasPaginas() {
        ObjectMapper objectMapper = new ObjectMapper();
        return obraLiterariaRepository.findTop5ByOrderByCantidadDePaginasDesc().stream().map(ol -> objectMapper.convertValue(ol, ObraLiterariaDto.class)).toList();

    }

    @Override
    public List<ObraLiterariaDto> getPublicadasAntesDelAnio(Integer anio) {
        ObjectMapper objectMapper = new ObjectMapper();
        return obraLiterariaRepository.findAllByAñoPublicacionBefore(anio).stream().map(ol -> objectMapper.convertValue(ol, ObraLiterariaDto.class)).toList();

    }


}
