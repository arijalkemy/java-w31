package com.bootcamp.productos.dto;

import com.bootcamp.productos.domain.Producto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductoDto {
    private String id;
    private String nombre;
    private String tipo;
    private Double precioVenta;
    private Double precioCosto;
    private Integer stock;

    public static ProductoDto fromEntity(Producto producto) {
        return new ProductoDto(
                producto.getId(),
                producto.getNombre(),
                producto.getTipo(),
                producto.getPrecioVenta(),
                producto.getPrecioCosto(),
                producto.getStock());
    }

    public Producto toProduct() {
        Producto producto = new Producto();
        producto.setId(id);
        producto.setNombre(nombre);
        producto.setTipo(tipo);
        producto.setPrecioVenta(precioVenta);
        producto.setPrecioCosto(precioCosto);
        producto.setStock(stock);

        return producto;
    }
}
