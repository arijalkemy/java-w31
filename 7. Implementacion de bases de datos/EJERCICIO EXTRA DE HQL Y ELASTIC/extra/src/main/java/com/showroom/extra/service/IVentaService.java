package com.showroom.extra.service;

import com.showroom.extra.dto.VentaDTO;
import com.showroom.extra.model.Prenda;
import com.showroom.extra.model.Venta;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IVentaService {
    //Crear una nueva venta.
    Venta save(VentaDTO ventaDTO);

    //Devolver todas las ventas
    List<Venta> findAll();

    //Devolver una venta en particular
    Optional<Venta> findbyId(Long id);

    //Actualizar una venta en particular
    Venta updateSale(Long id, VentaDTO ventaDTO);

    //Eliminar una venta en particular
    String deleteSale(Long id);

    //Traer todas las prendas de una determinada fecha
    List<Venta> saleByFecha(LocalDate date);

    //Traer la lista completa de prendas de una determinada venta.
    List<Prenda> findBySale(Long id);
}
