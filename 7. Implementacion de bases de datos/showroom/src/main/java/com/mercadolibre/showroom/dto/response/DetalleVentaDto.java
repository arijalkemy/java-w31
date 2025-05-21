package com.mercadolibre.showroom.dto.response;

import com.mercadolibre.showroom.model.Prenda;
import com.mercadolibre.showroom.model.Venta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DetalleVentaDto {
    private Long id;
    private int cantidad;
    private Venta venta;
    private Prenda prenda;
}
