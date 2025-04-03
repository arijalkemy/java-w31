package com.mercadolibre.model;

import com.mercadolibre.model.Producto;

import java.util.LinkedList;

public class Reserva {
    private LinkedList<Producto> productos = new LinkedList<>();

    public Reserva() {
    }

    public LinkedList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(LinkedList<Producto> productos) {
        this.productos = productos;
    }

   public void agregarProductoAReserva(Producto p){
        this.productos.add(p);
   }
}
