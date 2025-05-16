package com.meli.jewelry.app.service;

import com.meli.jewelry.app.dto.JewelDto;
import com.meli.jewelry.app.exception.NotFoundException;
import com.meli.jewelry.app.model.Jewel;
import com.meli.jewelry.app.repository.JewelRepository;
import com.meli.jewelry.app.utils.MapperUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JewelServiceImpl implements IJewelService{

    private JewelRepository jewelRepository;

    public JewelServiceImpl(JewelRepository jewelRepository) {
        this.jewelRepository = jewelRepository;
    }

    @Override
    public List<JewelDto> getAllJewels() {
        List<Jewel> jewels = jewelRepository.findAll();
        return jewels.stream().map(MapperUtil::toDto).toList();
    }

    @Override
    public JewelDto findJewel(Long id) {
        Optional<Jewel> jewel = jewelRepository.findById(id);
        if(jewel.isEmpty()){
            throw new NotFoundException("Jewel not found");
        }
        return MapperUtil.toDto(jewel.get());
    }

    @Override
    public void save(JewelDto jewel) {
        Jewel jewelDto = MapperUtil.toEntity(jewel);
        jewelRepository.save(jewelDto);
    }

    @Override
    public void delete(Long id) {
        jewelRepository.deleteById(id);
    }

    @Override
    public void update(Long id, JewelDto jewelDto) {
        Optional<Jewel> optionalJewel = jewelRepository.findById(id);
        if (optionalJewel.isEmpty()) {
            throw new NotFoundException("Jewel not found");
        }
        Jewel existingJewel = optionalJewel.get();
        existingJewel.setName(jewelDto.getName());
        existingJewel.setMaterial(jewelDto.getMaterial());
        existingJewel.setWeight(jewelDto.getWeight());
        existingJewel.setFeature(jewelDto.getFeature());
        existingJewel.setHasStone(jewelDto.isHasStone());
        existingJewel.setForSale(jewelDto.isForSale());
        jewelRepository.save(existingJewel);
    }
}
