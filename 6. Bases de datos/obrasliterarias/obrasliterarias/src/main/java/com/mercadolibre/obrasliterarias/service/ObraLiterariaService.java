package com.mercadolibre.obrasliterarias.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.obrasliterarias.domain.ObraLiteraria;
import com.mercadolibre.obrasliterarias.dto.ObraLiterariaDto;
import com.mercadolibre.obrasliterarias.repository.IObraLiterariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


@Service
public class ObraLiterariaService implements IObraLiterariaService{
    @Autowired
    IObraLiterariaRepository repository;
    @Override
    public void saveObra(ObraLiterariaDto obraLiterariaDto) {
        ObjectMapper mapper = new ObjectMapper();
        ObraLiteraria obraLiteraria = mapper.convertValue(obraLiterariaDto, ObraLiteraria.class);
        repository.save(obraLiteraria);
    }
    @Override
    public List<ObraLiterariaDto> getObrasPorAutor(String autor) {
        ObjectMapper mapper = new ObjectMapper();
        return repository.buscarPorAutor(autor).stream()
                .map(o -> mapper.convertValue(o, ObraLiterariaDto.class)).toList();
    }

    @Override
    public List<ObraLiterariaDto> buscarPorNombre(String nombre) {
        ObjectMapper mapper = new ObjectMapper();
        return repository.buscarPorNombre(nombre).stream()
                .map(o -> mapper.convertValue(o, ObraLiterariaDto.class)).toList();
    }

    @Override
    public List<ObraLiterariaDto> findTop5ByOrderByCantidadPaginasDesc() {
        ObjectMapper mapper = new ObjectMapper();
        List<ObraLiteraria> top5 = repository.findTop5ByOrderByCantidadPaginasDesc();
        return top5.stream()
                .map(o -> mapper.convertValue(o, ObraLiterariaDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ObraLiterariaDto> findObraLiterariaPublicatedBeforeYear(Integer year) {
        ObjectMapper mapper = new ObjectMapper();
        return repository.findObraLiterariaPublicatedBeforeYear(year).stream()
                .map(o -> mapper.convertValue(o, ObraLiterariaDto.class)).toList();
    }

    @Override
    public List<ObraLiterariaDto> buscarPorEditorial(String editorial) {
        ObjectMapper mapper = new ObjectMapper();
        return repository.buscarPorEditorial(editorial).stream()
                .map(o -> mapper.convertValue(o, ObraLiterariaDto.class)).toList();
    }
}
