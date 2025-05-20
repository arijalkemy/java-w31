package com.bootcamp.clothes_nosql.service;

import com.bootcamp.clothes_nosql.dto.ClothingDTO;
import com.bootcamp.clothes_nosql.mapper.ClothingMapper;
import com.bootcamp.clothes_nosql.model.Clothing;
import com.bootcamp.clothes_nosql.repository.ClothingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ClothingService {

    private final ClothingRepository repository;

    public ClothingDTO create(ClothingDTO dto) {
        Clothing saved = repository.save(ClothingMapper.toEntity(dto));
        return ClothingMapper.toDTO(saved);
    }

    public List<ClothingDTO> getAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(ClothingMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ClothingDTO getByCode(String code) {
        return repository.findById(code)
                .map(ClothingMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("No se encontró"));
    }

    public void delete(String code) {
        repository.deleteById(code);
    }

    public List<ClothingDTO> getBySize(String size) {
        return repository.findBySize(size).stream().map(ClothingMapper::toDTO).toList();
    }

    public List<ClothingDTO> getByNameContains(String name) {
        return repository.findByNameContainingIgnoreCase(name).stream().map(ClothingMapper::toDTO).toList();
    }
}
