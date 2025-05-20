package com.example.showroomrelacional.service;

import com.example.showroomrelacional.entity.Cloth;
import com.example.showroomrelacional.entity.ClothDTO;
import com.example.showroomrelacional.entity.CreateClothRequest;
import com.example.showroomrelacional.repository.ClothesRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClothesService {

    private ClothesRepository repository;
    private ObjectMapper mapper;

    public ClothDTO createNewCloth(CreateClothRequest newCloth) {
        return mapper.convertValue(repository.save(mapper.convertValue(newCloth, Cloth.class)), ClothDTO.class);
    }

    public List<ClothDTO> getAllClothes() {
        return repository.findAll().stream().map(c -> mapper.convertValue(c, ClothDTO.class)).toList();
    }

    public ClothDTO getClothById(Long id) {
        return repository.findById(id).map(c -> mapper.convertValue(c, ClothDTO.class)).orElseThrow(RuntimeException::new);
    }

    public ClothDTO updateCloth(Long id, CreateClothRequest edited) {
        Cloth cloth = repository.findById(id).orElseThrow();
        if (edited.getName() != null) {
            cloth.setName(edited.getName());
        }
        if (edited.getType() != null) {
            cloth.setType(edited.getType());
        }
        if (edited.getBrand() != null) {
            cloth.setBrand(edited.getBrand());
        }
        if (edited.getColor() != null) {
            cloth.setColor(edited.getColor());
        }
        if (edited.getSize() != null) {
            cloth.setSize(edited.getSize());
        }
        if (edited.getAmount() != null) {
            cloth.setAmount(edited.getAmount());
        }
        if (edited.getPrice() != null) {
            cloth.setPrice(edited.getPrice());
        }

        return mapper.convertValue(repository.save(cloth), ClothDTO.class);
    }

    public void deleteClothById(Long id) {
        repository.deleteById(id);
    }

    public List<ClothDTO> getClothesBySize(String size) {
        return repository.getClothsBySize(size).stream().map(c -> mapper.convertValue(c, ClothDTO.class)).toList();
    }

    public List<ClothDTO> getClothesByMatchingName(String query) {
        return repository.getClothsByNameContainingIgnoreCase(query);
    }
}
