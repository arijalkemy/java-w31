package com.example.LasPerlas.service;

import com.example.LasPerlas.dto.JewelryDTO;
import com.example.LasPerlas.mapper.JewelryMapper;
import com.example.LasPerlas.model.Jewelry;
import com.example.LasPerlas.repository.JewelryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JewelryService {
    private final JewelryRepository jewelryRepository;

    public JewelryService(JewelryRepository jewelryRepository) {
        this.jewelryRepository = jewelryRepository;
    }

    public JewelryDTO createJewelry(JewelryDTO jewelryDTO) {
        Jewelry jewelry = JewelryMapper.toEntity(jewelryDTO);
        Jewelry savedJewelry = jewelryRepository.save(jewelry);
        return JewelryMapper.toDTO(savedJewelry);
    }

    public List<JewelryDTO> getAllJewelry() {
        return jewelryRepository.findAll().stream()
                .map(JewelryMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<JewelryDTO> getAvailableJewelry() {
        return jewelryRepository.findByAvailableForSaleTrue().stream()
                .map(JewelryMapper::toDTO)
                .collect(Collectors.toList());
    }

    public JewelryDTO updateJewelry(Long id, JewelryDTO jewelryDTO) {
        return jewelryRepository.findById(id)
                .map(jewelry -> {
                    jewelry.setName(jewelryDTO.getName());
                    jewelry.setMaterial(jewelryDTO.getMaterial());
                    jewelry.setWeight(jewelryDTO.getWeight());
                    jewelry.setCharacteristic(jewelryDTO.getCharacteristic());
                    jewelry.setHasStone(jewelryDTO.isHasStone());
                    jewelry.setAvailableForSale(jewelryDTO.isAvailableForSale());
                    Jewelry updated = jewelryRepository.save(jewelry);
                    return JewelryMapper.toDTO(updated);
                }).orElse(null);
    }

    public boolean deleteJewelry(Long id) {
        return jewelryRepository.findById(id)
                .map(jewelry -> {
                    jewelry.setAvailableForSale(false);
                    jewelryRepository.save(jewelry);
                    return true;
                }).orElse(false);
    }
}
