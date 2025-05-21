package com.mercadolibre.showroom_uno.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.showroom_uno.dto.ClotheDto;
import com.mercadolibre.showroom_uno.dto.SaleClotheDto;
import com.mercadolibre.showroom_uno.dto.SaleDto;
import com.mercadolibre.showroom_uno.model.Clothe;
import com.mercadolibre.showroom_uno.model.Sale;
import com.mercadolibre.showroom_uno.model.SaleClothe;
import com.mercadolibre.showroom_uno.repository.IClothesRepository;
import com.mercadolibre.showroom_uno.repository.ISaleRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShowRoomService implements IShowRoomService {

    @Autowired
    IClothesRepository repository;
    @Autowired
    ISaleRepository saleRepository;
    @Autowired
    private ObjectMapper mapper;
    /* POST  /api/clothes Crear una nueva prenda.*/
    @Override
    public void createClothe(ClotheDto clotheDto) {
        clotheDto.setId(null);
        Clothe clothe = mapper.convertValue(clotheDto, Clothe.class);
        repository.save(clothe);
    }

    @Override
    public List<ClotheDto> getAllClothes() {
       return repository.findAll().stream().map(c -> mapper.convertValue(c, ClotheDto.class)).toList();
    }

    @Override
    public ClotheDto getClotheByCode(Long code) {
      Optional<Clothe> clothe = repository.findById(code);
        Clothe clotheObtained = repository.findById(code)
                .orElseThrow(() -> new RuntimeException("Prenda no encontrada con código: " + code));
      return mapper.convertValue(clotheObtained, ClotheDto.class);
    }

    @Override
    public void updateClothe(Long id, ClotheDto clotheDto) {
        Clothe existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prenda no encontrada para actualizar."));

        existing.setCantidad(clotheDto.getCantidad());
        existing.setNombre(clotheDto.getNombre());
        existing.setMarca(clotheDto.getMarca());
        existing.setTipo(clotheDto.getTipo());
        existing.setTalle(clotheDto.getTalle());
        existing.setColor(clotheDto.getColor());
        existing.setPrecioVenta(clotheDto.getPrecioVenta());
        repository.save(existing);
    }

    @Override
    public void deleteClothe(Long code) {
        Optional<Clothe> clothe = repository.findById(code);
        Clothe clotheObtained = repository.findById(code)
                .orElseThrow(() -> new RuntimeException("Prenda no encontrada con código: " + code));
        repository.delete(clotheObtained);
    }

    @Override
    public List<ClotheDto> getClothesBySize(String size) {
       List<Clothe> clothes = repository.findAll().stream().filter(c -> c.getTalle().equalsIgnoreCase(size))
               .toList();
       return clothes.stream().map(c -> mapper.convertValue(c, ClotheDto.class)).toList();
    }

    @Override
    public List<ClotheDto> getClotheByName(String name) {
        List<Clothe> clothes = repository.findAll().stream()
                .filter(c -> c.getNombre().toLowerCase().contains(name))
                .toList();
        return clothes.stream().map(c -> mapper.convertValue(c, ClotheDto.class)).toList();
    }
    /*POST api/sale Crear una nueva venta.*/
    @Override
    public void createSale(SaleDto saleDto) {
        saleDto.setId(null);
        Sale sale = mapper.convertValue(saleDto, Sale.class);
        saleRepository.save(sale);
    }
    /* GET /api/sale Devolver todas las ventas*/

    @Override
    public List<SaleDto> getAllSales() {
        return saleRepository.findAll().stream().map(s -> mapper.convertValue(s, SaleDto.class)).toList();
    }
    /* GET /api/sale/{number} Devolver una venta en particular*/
    @Override
    public SaleDto getSaleByNumber(Long id) {
        Optional<Sale> sale = saleRepository.findById(id);
        Sale saleObtained = saleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prenda no encontrada con código: " + id));
        return mapper.convertValue(saleObtained, SaleDto.class);
    }
    /* PUT /api/sale/{number} Actualizar una venta en particular*/
    @Override
    public void updateSale(Long id, SaleDto saleDto) {
        Sale existing = saleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada para actualizar."));
        existing.setFecha(saleDto.getFecha());
        existing.setTotal(saleDto.getTotal());
        existing.setMedioDePago(saleDto.getMedioDePago());
        existing.setSaleClothes(saleDto.getSaleClothes());
        saleRepository.save(existing);
    }
    /* DELETE /api/sale/{number] Eliminar una venta en particular*/
    @Override
    public void deleteSale(Long id) {
        Optional<Sale> sale = saleRepository.findById(id);
        Sale saleObtained = saleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada con código: " + id));
        saleRepository.delete(saleObtained);
    }
    @Override
    public List<SaleDto> getSalesBeforeDate(String dateString) throws BadRequestException {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(dateString, formatter);
            return saleRepository.findByFechaBefore(date).stream()
                    .map(sale -> mapper.convertValue(sale, SaleDto.class))
                    .toList();
        } catch (DateTimeParseException ex) {
            throw new BadRequestException("Formato de fecha inválido. Usa dd/MM/yyyy.");
        }
    }
    @Override
    public List<SaleClotheDto> getClothesBySale(Long id) {
        Sale sale = saleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));

        SaleClotheDto dto = new SaleClotheDto();
        dto.setFecha(sale.getFecha());
        dto.setTotal(sale.getTotal());

        List<ClotheDto> clothes = sale.getSaleClothes().stream()
                .map(saleClothe -> mapper.convertValue(saleClothe.getClothe(), ClotheDto.class))
                .toList();

        dto.setClotheDtoList(clothes);
        dto.setCantidad(sale.getSaleClothes().stream().mapToInt(SaleClothe::getCantidad).sum());

        return List.of(dto);
    }


}
