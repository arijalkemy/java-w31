package com.mercadolibre.groupfive.socialmeli.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mercadolibre.groupfive.socialmeli.model.Product;

@Repository
public class ProductRepositoryImpl implements IProductRepository {
    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Silla gamer", "Gamer", "Razr", "Rojo", ""));
        products.add(new Product(2, "Teclado mecánico", "Gamer", "Logitech", "Negro", ""));
        products.add(new Product(3, "Mouse inalámbrico", "Gamer", "Razer", "Verde", ""));
        products.add(new Product(4, "Monitor 4K", "Electrónica", "Samsung", "Negro", ""));
        products.add(new Product(5, "Auriculares Bluetooth", "Audio", "Sony", "Blanco", ""));
        products.add(new Product(6, "Smartphone", "Electrónica", "Apple", "Gris", ""));
        products.add(new Product(7, "Tablet", "Electrónica", "Samsung", "Negro", ""));
        products.add(new Product(8, "Cámara DSLR", "Fotografía", "Canon", "Negro", ""));
        products.add(new Product(9, "Impresora láser", "Oficina", "HP", "Blanco", ""));
        products.add(new Product(10, "Disco duro externo", "Almacenamiento", "Seagate", "Azul", ""));
        products.add(new Product(11, "Smartwatch", "Electrónica", "Garmin", "Negro", ""));
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }
}
