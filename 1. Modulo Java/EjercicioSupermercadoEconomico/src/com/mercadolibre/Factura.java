package com.mercadolibre;

import java.util.LinkedList;
import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Producto> productos;
    private Double totalDeCompra = 0.0;

    public Factura(Cliente cliente, List<Producto> productos) {
        this.cliente = cliente;
        this.productos = productos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Double getTotalDeCompra() {
        return totalDeCompra;
    }

    public void setTotalDeCompra(Double totalDeCompra) {
        this.totalDeCompra = totalDeCompra;
    }

    public Double calcularTotal(){
       this.totalDeCompra += this.productos.stream().mapToDouble(Producto::getCostoUnitario)
                                .sum();
        return totalDeCompra;
    }
}
