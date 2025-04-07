package bootcamp.poo.practica;

import java.util.*;

public class Distribuidora {
    private List<Producto> productos;

    public Distribuidora(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public double calcular() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.calcular(1);
        }
        return total;
    }
}
