package org.example.models.ejerciciodos;

import java.util.ArrayList;

public class Distribuidora {
    private ArrayList<Producto> productos = new ArrayList<>();

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }
}
