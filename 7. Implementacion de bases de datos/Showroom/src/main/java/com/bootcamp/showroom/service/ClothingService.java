package com.bootcamp.showroom.service;

import com.bootcamp.showroom.dto.ClothingDTO;
import com.bootcamp.showroom.mapper.ClothingMapper;
import com.bootcamp.showroom.repository.ClothingRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClothingService {
    private final ClothingRepository repository;

    public ClothingDTO save(ClothingDTO dto){
        return ClothingMapper.toDTO(repository.save(ClothingMapper.toEntity(dto)));
    }

    public List<ClothingDTO> findAll(){
        return repository.findAll().stream().map(ClothingMapper::toDTO).toList();
    }

    public ClothingDTO findByCode(String code){
        return ClothingMapper.toDTO(repository.findByCode(code));
    }

    public ClothingDTO update(String code, ClothingDTO dto) {
        if (!repository.existsByCode(code)) throw new RuntimeException("Not found");
        return ClothingMapper.toDTO(repository.save(ClothingMapper.toEntity(dto)));
    }

    @Transactional
    public void delete(String code) {
        repository.deleteByCode(code);
    }

    public List<ClothingDTO> findBySize(String size) {
        return repository.findBySize(size).stream().map(ClothingMapper::toDTO).toList();
    }

    public List<ClothingDTO> searchByName(String keyword) {
        return repository.findByNameContainingIgnoreCase(keyword).stream().map(ClothingMapper::toDTO).toList();
    }
}
