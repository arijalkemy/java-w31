package exercisePoo2.distribuidora;

import java.util.ArrayList;

public class Distribuidora {
    public static void main(String[] args) {
        ArrayList<Products> listProducts = new ArrayList<>();
        // producto base
        listProducts.add(new Products("Zapato", 7800.00));

        // productos perecedores
        listProducts.add(new Perecedero("Pollo", 12000.00, 1));
        listProducts.add(new Perecedero("Leche", 7800.00, 2));
        // No perecedero
        listProducts.add(new NoPerecederos("Silla", 5000.00, "Muebles"));
        listProducts.add(new NoPerecederos("Portatil", 135000.00, "tecnologia"));
        int cantidad = 5;
        for (Products product : listProducts) {
            double total = product.calculo(cantidad);
            System.out.println(" El total para el producto " + product.getNombre()
                    + " para la cantidad: " + cantidad + " es : " + total);

        }

    }
}
