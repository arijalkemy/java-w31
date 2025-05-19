package com.lasperlas.joyerialasperlas.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lasperlas.joyerialasperlas.dto.JewelDto;
import com.lasperlas.joyerialasperlas.model.Jewel;
import com.lasperlas.joyerialasperlas.repository.IJewelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JewelServiceImpl implements IJewelService {

    @Autowired
    private IJewelRepository jewelRepository;

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public List<JewelDto> getJewelry() {
        List<Jewel> jewelry = jewelRepository.findAll();
        return jewelry.stream()
                .map(j -> mapper.convertValue(j,JewelDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public JewelDto postJewelry(JewelDto jewelDto) {
        Jewel jewel = mapper.convertValue(jewelDto, Jewel.class);
        jewel.setUpForSale(true);
        return mapper.convertValue(jewelRepository.save(jewel), JewelDto.class);
    }

    @Override
    public void logicalDeletion(Long id) {
        Optional<Jewel> jewel = jewelRepository.findById(id);

        if (jewel.isEmpty()) {
            // throw exception
        }

        jewel.get().setUpForSale(false);
        jewelRepository.save(jewel.get());
    }

}
