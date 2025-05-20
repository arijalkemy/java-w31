package com.bootcamp.showroom.service;

import aj.org.objectweb.asm.commons.Remapper;
import com.bootcamp.showroom.dto.ClothingDTO;
import com.bootcamp.showroom.dto.SaleDTO;
import com.bootcamp.showroom.mapper.ClothingMapper;
import com.bootcamp.showroom.mapper.SaleMapper;
import com.bootcamp.showroom.model.Clothing;
import com.bootcamp.showroom.model.Sale;
import com.bootcamp.showroom.repository.ClothingRepository;
import com.bootcamp.showroom.repository.SaleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleService {
    private final SaleRepository saleRepository;
    private final ClothingRepository clothesRepository;

    public List<SaleDTO> getAll() {
        return saleRepository.findAll().stream().map(SaleMapper::toDTO).toList();
    }

    public SaleDTO getByNumber(String number) {
        return SaleMapper.toDTO(saleRepository.findByNumber(number));
    }

    public SaleDTO create(SaleDTO dto) {
        List<Clothing> clothes = clothesRepository.findAllByCodeIn(
                dto.getClothesList().stream().map(ClothingDTO::getCode).toList()
        );
        Sale sale = saleRepository.save(SaleMapper.toEntity(dto, clothes));
        return SaleMapper.toDTO(sale);
    }

    @Transactional
    public void delete(String number) {
        saleRepository.deleteByNumber(number);
    }

    public List<ClothingDTO> getClothesFromSale(String number) {
        Sale sale = saleRepository.findByNumber(number);
        return sale.getClothesList().stream().map(ClothingMapper::toDTO).toList();
    }

    public List<SaleDTO> getByDate(String date) {
        return saleRepository.findByDate(LocalDate.parse(date)).stream().map(SaleMapper::toDTO).toList();
    }

    @Transactional
    public SaleDTO update(String number, SaleDTO dto) {
        Sale existing = saleRepository.findByNumber(number);

        existing.setDate(dto.getDate());
        existing.setTotal(dto.getTotal());
        existing.setPaymentMethod(dto.getPaymentMethod());

        // Actualizar prnedas
        List<Clothing> clothes = clothesRepository.findAllByCodeIn(
                dto.getClothesList().stream().map(ClothingDTO::getCode).toList()
        );
        existing.setClothesList(clothes);

        return SaleMapper.toDTO(saleRepository.save(existing));
    }
}
