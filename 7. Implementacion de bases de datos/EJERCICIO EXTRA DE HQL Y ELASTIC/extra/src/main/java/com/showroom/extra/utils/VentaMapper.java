package com.showroom.extra.utils;

import com.showroom.extra.dto.PrendaDTO;
import com.showroom.extra.dto.VentaDTO;
import com.showroom.extra.model.Prenda;
import com.showroom.extra.model.Venta;
import com.showroom.extra.repository.IPrendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class VentaMapper {

    @Autowired
    private static IPrendaRepository repoPrenda;


    public static Venta toVenta(VentaDTO dto) {
        Venta venta = new Venta();
        venta.setFecha(dto.getFecha());
        venta.setTotal(dto.getTotal());
        venta.setMedioPago(dto.getMedioPago());

        List<Long> listIdPrenda = dto.getPrendasId();
        List<Prenda> prendaList = new ArrayList<>();

        for(Long codigo: listIdPrenda){
            Optional<Prenda> p = repoPrenda.findById(codigo);
            if(p.isPresent()){
                prendaList.add(p.get());
            }
        }

        venta.setPrendas(prendaList);  // aquí pasa la lista de Prenda tal cual
        return venta;
    }

    public static VentaDTO toDTO(Venta venta) {
        VentaDTO dto = new VentaDTO();
        dto.setFecha(venta.getFecha());
        dto.setTotal(venta.getTotal());
        dto.setMedioPago(venta.getMedioPago());


        List<Long> longList = new ArrayList<>();

        for(Prenda i:venta.getPrendas()){
            longList.add(i.getCodigo());
        }

        dto.setPrendasId(longList);

        return dto;
    }

    public static List<Venta> toVentaList(List<VentaDTO> dtoList) {
        return dtoList.stream()
                .map(VentaMapper::toVenta)
                .collect(Collectors.toList());
    }

    public static List<VentaDTO> toDTOList(List<Venta> entityList) {
        return entityList.stream()
                .map(VentaMapper::toDTO)
                .collect(Collectors.toList());
    }
}
