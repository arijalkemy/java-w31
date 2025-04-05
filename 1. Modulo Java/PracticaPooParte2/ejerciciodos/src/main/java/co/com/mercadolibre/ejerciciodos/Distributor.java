package co.com.mercadolibre.ejerciciodos;

import co.com.mercadolibre.ejerciciodos.domain.NonPerishable;
import co.com.mercadolibre.ejerciciodos.domain.Product;

public class Distributor {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Product product = new NonPerishable("Atun en lomitos", 800.50, "peanut butter");
        Product product1 = new NonPerishable("Atun en lomitos", 800.50, "peanut butter");
        Product product2 = new NonPerishable("Atun en lomitos", 800.50, "peanut butter");
        Product product3 = new NonPerishable("Atun en lomitos", 800.50, "peanut butter");
        Product product4 = new NonPerishable("Atun en lomitos", 800.50, "peanut butter");

        double precioTotal = 0;
        Product[] products = new Product[5];
        products[0] = product;
        products[1] = product1;
        products[2] = product2;
        products[3] = product3;
        products[4] = product4;

        for (Product p : products) {
            precioTotal += p.calcular(5);
        }

        System.out.println("El precio total por 5 productos es de: " + precioTotal);


    }
}