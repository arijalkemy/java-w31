package com.mercadolibre.groupfive.socialmeli.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mercadolibre.groupfive.socialmeli.model.Product;

@Repository
public class ProductRepositoryImpl implements IProductRepository {
    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Silla gamer", "Razr", "Gamer", "Rojo", ""));
        products.add(new Product(2, "Teclado mecánico", "Logitech", "Gamer", "Negro", ""));
        products.add(new Product(3, "Mouse inalámbrico", "Razer", "Gamer", "Verde", ""));
        products.add(new Product(4, "Monitor 4K", "Samsung", "Electrónica", "Negro", ""));
        products.add(new Product(5, "Auriculares Bluetooth", "Sony", "Audio", "Blanco", ""));
        products.add(new Product(6, "Smartphone", "Apple", "Electrónica", "Gris", ""));
        products.add(new Product(7, "Tablet", "Samsung", "Electrónica", "Negro", ""));
        products.add(new Product(8, "Cámara DSLR", "Canon", "Fotografía", "Negro", ""));
        products.add(new Product(9, "Impresora láser", "HP", "Oficina", "Blanco", ""));
        products.add(new Product(10, "Disco duro externo", "Seagate", "Almacenamiento", "Azul", ""));
        products.add(new Product(11, "Smartwatch", "Garmin", "Electrónica", "Negro", ""));
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }
}
