package com.example.showroomrelacional.service;

import com.example.showroomrelacional.entity.*;
import com.example.showroomrelacional.repository.ClothesRepository;
import com.example.showroomrelacional.repository.SalesRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SalesService {

    private SalesRepository saleRepository;
    private ClothesRepository clothesRepository;
    private ObjectMapper mapper;

    public SaleDTO createSale(CreateSaleRequest req) {
        Sale sale = new Sale();
        sale.setDate(req.getDate());
        sale.setTotalPrice(req.getTotalPrice());
        sale.setPaymentMethod(req.getPaymentMethod());

        List<Cloth> clothes = clothesRepository.findAllById(req.getClothesIds());
        sale.setClothes(clothes);

        Sale saved = saleRepository.save(sale);
        return toDTO(saved);
    }

    public List<SaleDTO> getAllSales() {
        return saleRepository.findAll().stream().map(this::toDTO).toList();
    }

    public SaleDTO getSaleById(Long id) {
        return saleRepository.findById(id).map(this::toDTO).orElseThrow();
    }

    public SaleDTO updateSale(Long id, CreateSaleRequest req) {
        Sale sale = saleRepository.findById(id).orElseThrow();
        if (req.getDate() != null) sale.setDate(req.getDate());
        if (req.getTotalPrice() != null) sale.setTotalPrice(req.getTotalPrice());
        if (req.getPaymentMethod() != null) sale.setPaymentMethod(req.getPaymentMethod());
        if (req.getClothesIds() != null) {
            List<Cloth> clothes = clothesRepository.findAllById(req.getClothesIds());
            sale.setClothes(clothes);
        }

        Sale updated = saleRepository.save(sale);
        return toDTO(updated);
    }

    public void deleteSale(Long id) {
        saleRepository.deleteById(id);
    }

    public List<SaleDTO> getSalesByDate(LocalDate date) {
        return saleRepository.findByDate(date).stream().map(this::toDTO).toList();
    }

    public List<ClothDTO> getClothesOfSale(Long saleId) {
        Sale sale = saleRepository.findById(saleId).orElseThrow();
        return sale.getClothes().stream().map(cloth -> mapper.convertValue(cloth, ClothDTO.class)).toList();
    }

    private SaleDTO toDTO(Sale s) {
        List<ClothDTO> cloths = s.getClothes().stream().map(c -> mapper.convertValue(c, ClothDTO.class)).toList();
        return new SaleDTO(s.getId(), s.getDate(), s.getTotalPrice(), s.getPaymentMethod(), cloths);
    }
}