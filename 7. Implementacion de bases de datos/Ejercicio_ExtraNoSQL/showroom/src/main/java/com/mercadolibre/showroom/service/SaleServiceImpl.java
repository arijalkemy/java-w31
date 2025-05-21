package com.mercadolibre.showroom.service;

import com.mercadolibre.showroom.dto.ClothingItemDto;
import com.mercadolibre.showroom.dto.SaleDto;
import com.mercadolibre.showroom.exception.NotFoundException;
import com.mercadolibre.showroom.model.ClothingItem;
import com.mercadolibre.showroom.model.Sale;
import com.mercadolibre.showroom.repository.ClothingItemRepository;
import com.mercadolibre.showroom.repository.SaleRepository;
import com.mercadolibre.showroom.utils.MapperUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SaleServiceImpl implements ISaleService{

    private final SaleRepository saleRepository;
    private final ClothingItemRepository clothingItemRepository;

    public SaleServiceImpl(SaleRepository saleRepository, ClothingItemRepository clothingItemRepository) {
        this.saleRepository = saleRepository;
        this.clothingItemRepository = clothingItemRepository;
    }


    @Override
    public SaleDto save(SaleDto saleDto) {
        Sale sale = MapperUtil.toEntity(saleDto, Sale.class);
        sale = saleRepository.save(sale);
        return MapperUtil.toDto(sale, SaleDto.class);
    }

    @Override
    public void delete(String id) {
        Optional<Sale> saleOptional = saleRepository.findById(id);
        if (saleOptional.isEmpty()) {
            throw new NotFoundException("Sale not found");
        }
        saleRepository.deleteById(id);
    }

    @Override
    public SaleDto findById(String id) {
        Optional<Sale> saleOptional = saleRepository.findById(id);
        if (saleOptional.isEmpty()) {
            throw new NotFoundException("Sale not found");
        }
        return MapperUtil.toDto(saleOptional.get(), SaleDto.class);

    }

    @Override
    public List<SaleDto> findAll() {
        List<Sale> saleList = saleRepository.findAll();
        return saleList.stream().map(sale -> MapperUtil.toDto(sale, SaleDto.class)).toList();
    }

    @Override
    public SaleDto update(String id, SaleDto saleDto) {
        Optional<Sale> saleOptional = saleRepository.findById(id);
        if (saleOptional.isEmpty()) {
            throw new NotFoundException("Sale not found");
        }

        Sale sale = saleOptional.get();

        List<String> clothingItemIds = saleDto.getClothingItems().stream()
                .map(ClothingItemDto::getCode)
                .toList();

        List<ClothingItem> items = clothingItemRepository.findAllByCode(clothingItemIds);

        sale.setClothingItems(items);
        sale.setDate(saleDto.getDate());
        sale.setPaymentMethod(saleDto.getPaymentMethod());
        sale.setTotal(saleDto.getTotal());

        sale = saleRepository.save(sale);
        return MapperUtil.toDto(sale, SaleDto.class);
    }


    @Override
    public List<SaleDto> findByDate(LocalDate parsedDate) {
        List<Sale> saleList = saleRepository.findByDate(parsedDate);
        return saleList.stream().map(sale -> MapperUtil.toDto(sale, SaleDto.class)).toList();
    }

    @Override
    public List<ClothingItemDto> getClothingItemsBySaleNumber(String number) {
        Optional<Sale> saleOptional = saleRepository.findById(number);
        if (saleOptional.isEmpty()) {
            throw new NotFoundException("Sale not found");
        }
        List<ClothingItem> clothingItems = saleOptional.get().getClothingItems();
        return clothingItems.stream().map(item -> MapperUtil.toDto(item, ClothingItemDto.class)).toList();
    }

}
