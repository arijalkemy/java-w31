package P2.Ejercicio2;

import java.util.ArrayList;
import java.util.List;

/*
 * Crear una clase ejecutable llamada Distribuidora donde van a
 * crear un array de productos, imprimir el precio total al
 * vender 5 productos de cada tipo. Crear los elementos del array
 * con los datos que quieras.
 */
public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<Producto>();

        productos.add(new Producto("Alfombra", 1000.0));
        productos.add(new Producto("Cuchillo", 60.0));
        productos.add(new Producto("Mesa", 1100.0));
        productos.add(new Producto("Tenedor",50.0));
        productos.add(new Producto("Cortina", 900.0));

        productos.add(new Perecedero(5, "Leche", 20.0));
        productos.add(new Perecedero(4, "Queso", 22.0));
        productos.add(new Perecedero(3, "Huevos", 19.0));
        productos.add(new Perecedero(7, "Pan", 21.0));
        productos.add(new Perecedero(6, "Jamón", 23.0));

        productos.add(new NoPerecedero("Decoración", "Cuadro", 500.0));
        productos.add(new NoPerecedero("Decoración", "Planta Interior", 600.0));
        productos.add(new NoPerecedero("Ropa", "Camisa", 550.0));
        productos.add(new NoPerecedero("Ropa", "Campera", 700.0));
        productos.add(new NoPerecedero("Ropa", "Pantalón", 800.0));

        double precioTotal = 0.0;

        for (Producto producto : productos) {
            double precioProducto = producto.getPrecio();
            precioTotal += precioProducto;
            System.out.println("Producto: " + producto + ", Precio por unidad: $" + precioProducto);
        }

        System.out.println("===========================================");
        System.out.println("Total a pagar por todos los productos: $" + precioTotal);
    }
}

