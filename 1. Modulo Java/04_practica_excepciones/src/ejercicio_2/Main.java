package ejercicio_2;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();
        Producto procutouno = new Producto("Producto 1", 1.0);
        Perecedero productodos = new Perecedero("Perecedero", 2.0, 1);
        NoPerecedero productotres = new NoPerecedero("NoPerecedero", 3.0, "TipoA");

        productos.add(procutouno);
        productos.add(productodos);
        productos.add(productotres);

        productos.forEach( prod -> {
            System.out.println(prod.calcular(2));
        });
    }
}
