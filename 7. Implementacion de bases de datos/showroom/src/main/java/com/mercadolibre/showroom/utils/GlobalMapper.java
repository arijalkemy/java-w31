package com.mercadolibre.showroom.utils;

import com.mercadolibre.showroom.dto.request.PrendaDetalleRequestDto;
import com.mercadolibre.showroom.dto.request.PrendaRequestDto;
import com.mercadolibre.showroom.dto.request.VentaRequestDto;
import com.mercadolibre.showroom.dto.response.DetalleVentaDto;
import com.mercadolibre.showroom.dto.response.PrendaResponseDto;
import com.mercadolibre.showroom.dto.response.VentaResponseDto;
import com.mercadolibre.showroom.model.DetalleVenta;
import com.mercadolibre.showroom.model.Prenda;
import com.mercadolibre.showroom.model.Venta;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class GlobalMapper {

    //PRENDA

    public static Prenda dtoToentity(PrendaRequestDto dto){
        return new Prenda(
                null,
                dto.getCodigo(),
                dto.getNombre(),
                dto.getTipo(),
                dto.getMarca(),
                dto.getColor(),
                dto.getTalle(),
                dto.getCantidad(),
                dto.getPrecio()
        );
    }

    public static PrendaResponseDto entityToDto(Prenda prenda){
        return new PrendaResponseDto(
                prenda.getId(),
                prenda.getCodigo(),
                prenda.getNombre(),
                prenda.getTipo(),
                prenda.getMarca(),
                prenda.getColor(),
                prenda.getTalle(),
                prenda.getCantidad(),
                prenda.getPrecio()
        );
    }

    public static Prenda updateEntityFromDto(Prenda prenda, PrendaRequestDto dto) {
        prenda.setNombre(dto.getNombre());
        prenda.setTipo(dto.getTipo());
        prenda.setMarca(dto.getMarca());
        prenda.setColor(dto.getColor());
        prenda.setTalle(dto.getTalle());
        prenda.setCantidad(dto.getCantidad());
        prenda.setPrecio(dto.getPrecio());
        return prenda;
    }

    public static List<PrendaResponseDto> listEntityToDto(List<Prenda> prendas){
        return prendas.stream().map(GlobalMapper::entityToDto).toList();
    }

    public static PrendaDetalleRequestDto prentaToDetalle(Prenda prenda){
        return new PrendaDetalleRequestDto(
                prenda.getCodigo(),
                prenda.getCantidad()
        );
    }


    //VENTAS

    public static Venta ventaDtoToentity(VentaRequestDto dto, List<Prenda> prendas){
        return new Venta(
                null,
                dto.getNumero(),
                dto.getFecha(),
                dto.getTotal(),
                dto.getMedioDePago(),
                prendas
        );
    }

    public static VentaResponseDto ventaEntityToDto(Venta entity){
        return new VentaResponseDto(
                entity.getId(),
                entity.getNumero(),
                entity.getFecha(),
                entity.getTotal(),
                entity.getMedioDePago(),
                entity.getPrendas().stream().map(GlobalMapper::prentaToDetalle).toList()
        );
    }

    public static List<VentaResponseDto> ventaListEntityToDto(List<Venta> ventas){
        return ventas.stream().map(GlobalMapper::ventaEntityToDto).toList();
    }

    public static Venta ventaUpdateEntityFromDto(Venta venta, VentaRequestDto dto, List<Prenda> prendas) {
        venta.setNumero(dto.getNumero());
        venta.setFecha(dto.getFecha());
        venta.setTotal(dto.getTotal());
        venta.setMedioDePago(dto.getMedioDePago());
        venta.setPrendas(prendas);
        return venta;
    }

}
