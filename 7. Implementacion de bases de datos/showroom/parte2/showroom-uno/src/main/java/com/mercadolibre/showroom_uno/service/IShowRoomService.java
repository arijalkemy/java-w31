package com.mercadolibre.showroom_uno.service;

import com.mercadolibre.showroom_uno.dto.ClotheDto;
import com.mercadolibre.showroom_uno.dto.SaleClotheDto;
import com.mercadolibre.showroom_uno.dto.SaleDto;
import org.apache.coyote.BadRequestException;

import java.time.LocalDate;
import java.util.List;

public interface IShowRoomService {
    void createClothe(ClotheDto clotheDto);
    List<ClotheDto> getAllClothes();
    ClotheDto getClotheByCode(Long code);
    void updateClothe(Long id, ClotheDto clotheDto);
    void deleteClothe(Long code);
    List<ClotheDto> getClothesBySize(String size);
    List<ClotheDto> getClotheByName(String name);
    /*POST api/sale Crear una nueva venta.*/
    void createSale(SaleDto saleDto);
    /* GET /api/sale Devolver todas las ventas*/
    List<SaleDto> getAllSales();
    /* GET /api/sale/{number} Devolver una venta en particular*/
    SaleDto getSaleByNumber(Long id);
    /* PUT /api/sale/{number} Actualizar una venta en particular*/
    void updateSale(Long id, SaleDto saleDto);
    /* DELETE /api/sale/{number] Eliminar una venta en particular*/
    void deleteSale(Long id);
    /* GET /api/sale?date=22/05/2022Traer todas las prendas de una determinada fecha*/
    public List<SaleDto> getSalesBeforeDate(String dateString) throws BadRequestException;
    /* GET /api/sale/clothes/{number} Traer la lista completa de prendas de una determinada venta.*/
    public List<SaleClotheDto> getClothesBySale(Long id);
}
