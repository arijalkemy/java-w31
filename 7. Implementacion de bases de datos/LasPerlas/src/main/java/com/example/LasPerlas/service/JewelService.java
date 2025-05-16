package com.example.LasPerlas.service;

import com.example.LasPerlas.model.dto.JewelDTO;
import com.example.LasPerlas.model.entity.Jewel;
import com.example.LasPerlas.model.request.NewJewelRequest;
import com.example.LasPerlas.repository.JewelRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JewelService {

    JewelRepository repository;
    ObjectMapper mapper;

    public JewelDTO createNewJewerly(NewJewelRequest jewerlyRequest) {
        Jewel jewelry = mapper.convertValue(jewerlyRequest, Jewel.class);
        Jewel saved = repository.save(jewelry);
        return mapper.convertValue(saved, JewelDTO.class);
    }

    public List<JewelDTO> getAllJewels() {
        return repository.findAll().stream().map(j -> mapper.convertValue(j, JewelDTO.class)).toList();
    }

    public void deleteJewelById(Long id) {
        repository.deleteById(id);
    }

    public JewelDTO updateJewelById(Long idAModificar, NewJewelRequest modifiedJewel) {
        return repository.findById(idAModificar)
                .map(jewel -> {
                    jewel.setName(modifiedJewel.getName());
                    jewel.setMaterial(modifiedJewel.getMaterial());
                    jewel.setWeight(modifiedJewel.getWeight());
                    jewel.setDetails(modifiedJewel.getDetails());
                    jewel.setHasStone(modifiedJewel.isHasStone());
                    jewel.setForSale(modifiedJewel.isForSale());
                    return mapper.convertValue(repository.save(jewel), JewelDTO.class);
                })
                .orElseThrow();
    }
}
