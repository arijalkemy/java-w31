package com.mercadolibre.showroom.service;

import com.mercadolibre.showroom.dto.ClothingItemDto;
import com.mercadolibre.showroom.exception.NotFoundException;
import com.mercadolibre.showroom.model.ClothingItem;
import com.mercadolibre.showroom.repository.ClothingItemRepository;
import com.mercadolibre.showroom.utils.MapperUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClothesServiceImpl implements IClothesService {

    private ClothingItemRepository clothingItemRepository;

    public ClothesServiceImpl(ClothingItemRepository clothingItemRepository) {
        this.clothingItemRepository = clothingItemRepository;
    }

    @Override
    public ClothingItemDto save(ClothingItemDto clothingItemDto) {
        ClothingItem clothingItem = MapperUtil.toEntity(clothingItemDto, ClothingItem.class);
        clothingItem =  clothingItemRepository.save(clothingItem);
        return MapperUtil.toDto(clothingItem, ClothingItemDto.class);

    }

    @Override
    public List<ClothingItemDto> findAll() {
        List<ClothingItem> clothingItems = clothingItemRepository.findAll();
        return clothingItems.stream().map(item -> MapperUtil.toDto(item, ClothingItemDto.class))
                .toList();
    }

    @Override
    public ClothingItemDto update(Long id, ClothingItemDto clothingItemDto) {
        Optional<ClothingItem> clothingItemOptional = clothingItemRepository.findById(id);
        if(clothingItemOptional.isEmpty()){
            throw new NotFoundException("Clothing Item Not Found");
        }
        ClothingItem clothingItem = clothingItemOptional.get();
        clothingItem.setName(clothingItemDto.getName());
        clothingItem.setType(clothingItemDto.getType());
        clothingItem.setQuantity(clothingItemDto.getQuantity());
        clothingItem.setColor(clothingItemDto.getColor());
        clothingItem.setSize(clothingItemDto.getSize());
        clothingItem.setSalePrice(clothingItemDto.getSalePrice());
        clothingItem.setBrand(clothingItemDto.getBrand());
        clothingItem = clothingItemRepository.save(clothingItem);
        return MapperUtil.toDto(clothingItem, ClothingItemDto.class);
    }

    @Override
    public ClothingItemDto findById(Long id) {
        Optional<ClothingItem> clothingItemOptional = clothingItemRepository.findById(id);
        if(clothingItemOptional.isEmpty()){
            throw new NotFoundException("Clothing Item Not Found");
        }
        return MapperUtil.toDto(clothingItemOptional.get(), ClothingItemDto.class);
    }

    @Override
    public void delete(Long id) {
        Optional<ClothingItem> clothingItemOptional = clothingItemRepository.findById(id);
        if(clothingItemOptional.isEmpty()){
            throw new NotFoundException("Clothing Item Not Found");
        }
        clothingItemRepository.delete(clothingItemOptional.get());
    }

    @Override
    public List<ClothingItemDto> findByName(String name){
        List<ClothingItem> clothingItems = clothingItemRepository.findByNameContainingIgnoreCase(name);
        return clothingItems.stream().map(item -> MapperUtil.toDto(item, ClothingItemDto.class))
                .toList();
    }

    @Override
    public List<ClothingItemDto> findBySize(String size){
        List<ClothingItem> clothingItems = clothingItemRepository.findBySizeContainingIgnoreCase(size);
        return clothingItems.stream().map(item -> MapperUtil.toDto(item, ClothingItemDto.class))
                .toList();
    }
}
