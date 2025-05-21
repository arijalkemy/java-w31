package com.showroom.extra.utils;

import com.showroom.extra.dto.PrendaDTO;
import com.showroom.extra.model.Prenda;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PrendaMapper {
    public static Prenda toPrenda(PrendaDTO dto) {
        Prenda prenda = new Prenda();
        prenda.setNombre(dto.getNombre());
        prenda.setTipo(dto.getTipo());
        prenda.setMarca(dto.getMarca());
        prenda.setColor(dto.getColor());
        prenda.setTalle(dto.getTalle());
        prenda.setCantidad(dto.getCantidad());
        prenda.setPrecioVenta(dto.getPrecioVenta());
        return prenda;
    }

    public static PrendaDTO toDTO(Prenda prenda) {
        PrendaDTO dto = new PrendaDTO();
        dto.setNombre(prenda.getNombre());
        dto.setTipo(prenda.getTipo());
        dto.setMarca(prenda.getMarca());
        dto.setColor(prenda.getColor());
        dto.setTalle(prenda.getTalle());
        dto.setCantidad(prenda.getCantidad());
        dto.setPrecioVenta(prenda.getPrecioVenta());
        return dto;
    }

    public static List<Prenda> toPrendaList(List<PrendaDTO> dtoList) {
        return dtoList.stream()
                .map(PrendaMapper::toPrenda)
                .collect(Collectors.toList());
    }

    public static List<PrendaDTO> toDTOList(List<Prenda> entityList) {
        return entityList.stream()
                .map(PrendaMapper::toDTO)
                .collect(Collectors.toList());
    }
}
