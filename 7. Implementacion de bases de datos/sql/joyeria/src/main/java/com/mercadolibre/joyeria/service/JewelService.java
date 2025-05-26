package com.mercadolibre.joyeria.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.joyeria.dto.JewelRequestDTO;
import com.mercadolibre.joyeria.dto.JewelResponseDTO;
import com.mercadolibre.joyeria.model.Jewel;
import com.mercadolibre.joyeria.repository.IJewelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JewelService implements IJewelService {

    @Autowired
    private IJewelRepository jewelRepository;
    @Autowired
    private ObjectMapper mapper;


    @Override
    public List<JewelResponseDTO> getJewels() {
        List<Jewel> foundJewels = jewelRepository.findAll().stream()
                .filter(Jewel::getOn_sale)
                .toList();

        return mapper.convertValue(
                foundJewels,
                new TypeReference<>() {
                });
    }

    @Override
    public Long saveJewel(JewelRequestDTO jewel) {
        Jewel savedJewel = jewelRepository.save(
                mapper.convertValue(jewel, Jewel.class));

        return savedJewel.getId();
    }

    @Override
    public JewelResponseDTO updateJewel(JewelRequestDTO jewel, Long id) {
        Jewel foundJewel = jewelRepository.findById(id)
                            .orElseThrow();

        foundJewel = mapper.convertValue(jewel, Jewel.class);
        foundJewel.setId(id);
        jewelRepository.save(foundJewel);

        return mapper.convertValue(foundJewel, JewelResponseDTO.class);
    }

    @Override
    public void deleteJewel(Long id) {
        Jewel foundJewel = jewelRepository.findById(id).orElseThrow();
        foundJewel.setOn_sale(false);
        jewelRepository.save(foundJewel);
    }

    @Override
    public JewelResponseDTO findJewelById(Long id) {
        return mapper.convertValue(
                jewelRepository.findById(id),
                JewelResponseDTO.class
        );
    }
}
