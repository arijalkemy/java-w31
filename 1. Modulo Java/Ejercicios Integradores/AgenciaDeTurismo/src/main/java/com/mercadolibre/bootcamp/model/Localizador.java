package com.mercadolibre.bootcamp.model;

import java.util.ArrayList;
import java.util.List;

public class Localizador {

    private Long id;
    private Cliente cliente;
    private List<Producto> productos;
    private Double total;

    public Localizador(Long id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.total = 0.0;
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
        calcularTotal();
    }

    public Double calcularTotal() {
        total = productos.stream().mapToDouble(p -> p.getPrecio()).sum();
        return total;
    }

    public void calculaDescuentos(){
        Double descuento = 0.0;
        if(cliente.getLocalizadores().size() >= 2){
            descuento += 0.05;
        }
        if(esPaqueteCompleto()){
            descuento += 0.1;
        }
        if(productos.stream().filter(p -> p.getTipo().equals(TipoProducto.BOLETOS_DE_VIAJE)).count() >= 2){
            aplicarDescuentoBoletoViaje();
        }
        if(productos.stream().filter(p -> p.getTipo().equals(TipoProducto.RESERVA_HOTEL)).count() >= 2){
            aplicarDescuentoHotel();
        }
        total = calcularTotal() - (calcularTotal()*descuento);

    }

    private void aplicarDescuentoHotel() {
        for (Producto producto : productos) {
            if(producto.getTipo().equals(TipoProducto.RESERVA_HOTEL)){
                producto.setPrecio(producto.getPrecio()  - (producto.getPrecio() * 0.05));
            }
        }
    }

    private void aplicarDescuentoBoletoViaje() {
        for (Producto producto : productos) {
            if(producto.getTipo().equals(TipoProducto.BOLETOS_DE_VIAJE)){
                producto.setPrecio(producto.getPrecio()  - (producto.getPrecio() * 0.05));
            }
        }
    }

    public boolean esPaqueteCompleto() {
        boolean hotel = false, boletos = false, comida = false, transporte = false;
        for (Producto producto : productos) {
            if(producto.getTipo().equals(TipoProducto.COMIDA)){
                comida = true;
            }else if(producto.getTipo().equals(TipoProducto.RESERVA_HOTEL)){
                hotel = true;
            }else if(producto.getTipo().equals(TipoProducto.BOLETOS_DE_VIAJE)){
                boletos = true;
            } else if (producto.getTipo().equals(TipoProducto.TRANSPORTE)) {
                transporte = true;
            }
            if(hotel && boletos && transporte && comida){
                return true;
            }
        }
        return false;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "id=" + id +
                ", total=" + total +
                ", cliente=" + cliente.getDni() +
                ", productos=" + productos +
                '}';
    }
}
