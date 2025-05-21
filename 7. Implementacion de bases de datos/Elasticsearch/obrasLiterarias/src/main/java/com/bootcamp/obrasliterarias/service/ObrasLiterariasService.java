package com.bootcamp.obrasliterarias.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.bootcamp.obrasliterarias.domain.ObraLiteraria;
import com.bootcamp.obrasliterarias.dto.ObraLiterariaDto;
import com.bootcamp.obrasliterarias.exception.BadRequestException;
import com.bootcamp.obrasliterarias.exception.ObraNotFoundException;
import com.bootcamp.obrasliterarias.repository.ObraLiterariaRepository;

@Service
public class ObrasLiterariasService implements IObrasLiterariasService {
    private final ObraLiterariaRepository repository;

    public ObrasLiterariasService(ObraLiterariaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ObraLiterariaDto> getAllObrasLiterarias() {
        Iterable<ObraLiteraria> obras = repository.findAll();
        List<ObraLiterariaDto> obrasDto = new ArrayList<>();

        for (ObraLiteraria obra : obras) {
            obrasDto.add(ObraLiterariaDto.fromEntity(obra));
        }
        if (obrasDto.isEmpty()) {
            throw new ObraNotFoundException("No se encontraron obras literarias");
        }

        return obrasDto;
    }

    @Override
    public String createObraLiteraria(ObraLiterariaDto obraLiterariaDto) {
        if (obraLiterariaDto == null) {
            throw new BadRequestException("No se puede agregar una obra literaria nula.");
        }

        ObraLiteraria obraLiteraria = obraLiterariaDto.toEntity();
        repository.save(obraLiteraria);

        return obraLiteraria.getId();
    }

    @Override
    public List<ObraLiterariaDto> getObrasLiterariasByAutor(String autor) {
        Iterable<ObraLiteraria> obras = repository.findByAutor(autor);
        List<ObraLiterariaDto> obrasDto = new ArrayList<>();

        for (ObraLiteraria obra : obras) {
            obrasDto.add(ObraLiterariaDto.fromEntity(obra));
        }
        if (obrasDto.isEmpty()) {
            throw new ObraNotFoundException("No se encontraron obras literarias de " + autor);
        }

        return obrasDto;
    }

    @Override
    public List<ObraLiterariaDto> getObrasLiterariasByKeyword(String keyword) {
        Iterable<ObraLiteraria> obras = repository.findByNombre(keyword);
        List<ObraLiterariaDto> obrasDto = new ArrayList<>();

        for (ObraLiteraria obra : obras) {
            obrasDto.add(ObraLiterariaDto.fromEntity(obra));
        }
        if (obrasDto.isEmpty()) {
            throw new ObraNotFoundException("No se encontraron obras literarias que coincidan con " + keyword);
        }

        return obrasDto;
    }

    @Override
    public List<ObraLiterariaDto> getFiveLongestObrasLiterarias() {
        Iterable<ObraLiteraria> obrasOrdenadas = repository.findAll(Sort.by(Sort.Direction.DESC, "cantidadDePaginas"));
        List<ObraLiterariaDto> obrasOrdenadasDto = new ArrayList<>();

        for (ObraLiteraria obra : obrasOrdenadas) {
            obrasOrdenadasDto.add(ObraLiterariaDto.fromEntity(obra));
        }
        if (obrasOrdenadasDto.isEmpty()) {
            throw new ObraNotFoundException("No se encontraron obras literarias");
        }

        return obrasOrdenadasDto.stream().limit(5).toList();
    }

    @Override
    public List<ObraLiterariaDto> getObrasLiterariasBeforeYear(Integer year) {
        Iterable<ObraLiteraria> obras = repository.findByAnioPublicacionBefore(year);
        List<ObraLiterariaDto> obrasDto = new ArrayList<>();

        for (ObraLiteraria obra : obras) {
            obrasDto.add(ObraLiterariaDto.fromEntity(obra));
        }
        if (obrasDto.isEmpty()) {
            throw new ObraNotFoundException("No se encontraron obras literarias anteriores al año " + year);
        }

        return obrasDto;
    }

    @Override
    public List<ObraLiterariaDto> getObrasLiterariasByEditorial(String editorial) {
        Iterable<ObraLiteraria> obras = repository.findByEditorial(editorial);
        List<ObraLiterariaDto> obrasDto = new ArrayList<>();

        for (ObraLiteraria obra : obras) {
            obrasDto.add(ObraLiterariaDto.fromEntity(obra));
        }
        if (obrasDto.isEmpty()) {
            throw new ObraNotFoundException("No se encontraron obras literarias de la editorial " + editorial);
        }

        return obrasDto;
    }

}
