package com.mercadolibre.groupfive.socialmeli.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.mercadolibre.groupfive.socialmeli.model.Post;
import com.mercadolibre.groupfive.socialmeli.model.Product;

@Repository
public class PostRepositoryImpl implements IPostRepository {
    private static List<Post> posts = new ArrayList<>();

    private static List<Product> products = new ArrayList<>();
    private Integer idCounter;

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

        posts.add(new Post(1, 1, LocalDate.now(), products.get(8), 120, 100.0));
        posts.add(new Post(2, 2, LocalDate.now(), products.get(0), 50, 200.0));
        posts.add(new Post(3, 3, LocalDate.now(), products.get(1), 30, 150.0));
        posts.add(new Post(4, 4, LocalDate.now(), products.get(2), 70, 80.0));
        posts.add(new Post(5, 5, LocalDate.now(), products.get(3), 90, 300.0));
        posts.add(new Post(6, 6, LocalDate.now(), products.get(4), 40, 120.0));
        posts.add(new Post(7, 7, LocalDate.now(), products.get(5), 60, 1000.0));
        posts.add(new Post(8, 8, LocalDate.now(), products.get(6), 80, 500.0));
        posts.add(new Post(9, 9, LocalDate.now(), products.get(7), 20, 700.0));
        posts.add(new Post(10, 10, LocalDate.now(), products.get(9), 100, 250.0));
        posts.add(new Post(11, 11, LocalDate.now(), products.get(10), 110, 300.0));
    }

    @Override
    public void save(Post post) {
        idCounter = posts.size() + 1;
        post.setPostId(idCounter);
        posts.add(post);
    }

    @Override
    public List<Post> findAllByBrand(String brand) {
        return posts.stream()
                .filter(postsFiltered -> postsFiltered.getProduct().getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());
    }

    @Override
    public List<Post> findAllByPriceRange(Double min, Double max) {
        return posts.stream()
                .filter(post -> post.getPrice() >= min && post.getPrice() <= max)
                .toList();
    }
}
