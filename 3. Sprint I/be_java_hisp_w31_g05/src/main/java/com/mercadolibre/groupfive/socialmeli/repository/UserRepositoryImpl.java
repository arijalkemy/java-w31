package com.mercadolibre.groupfive.socialmeli.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.mercadolibre.groupfive.socialmeli.model.Post;
import com.mercadolibre.groupfive.socialmeli.model.Product;
import org.springframework.stereotype.Repository;

import com.mercadolibre.groupfive.socialmeli.model.User;

@Repository
public class UserRepositoryImpl implements IUserRepository {
    private static List<User> users;

    private static List<Product> products = new ArrayList<>();
    private static List<Post> posts = new ArrayList<>();

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

        posts.add(new Post(3, 1, LocalDate.of(2025, 3, 28), products.get(8), 120, 100.0));
        posts.add(new Post(3, 2, LocalDate.of(2025, 4, 12), products.get(0), 50, 200.0));
        posts.add(new Post(3, 3, LocalDate.of(2025, 4, 5), products.get(1), 30, 150.0));
        posts.add(new Post(3, 4, LocalDate.of(2025, 4, 7), products.get(2), 70, 80.0));
        posts.add(new Post(3, 5, LocalDate.of(2025, 4, 11), products.get(3), 90, 300.0));
        posts.add(new Post(5, 6, LocalDate.of(2025, 4, 4), products.get(4), 40, 120.0));
        posts.add(new Post(5, 7, LocalDate.of(2025, 4, 14), products.get(5), 60, 1000.0));
        posts.add(new Post(5, 8, LocalDate.of(2025, 4, 16), products.get(6), 80, 500.0));
        posts.add(new Post(2, 9, LocalDate.of(2025, 4, 13), products.get(7), 20, 700.0));
        posts.add(new Post(2, 10, LocalDate.of(2025, 4, 11), products.get(9), 100, 250.0));
        posts.add(new Post(2, 11, LocalDate.of(2025, 4, 5), products.get(10), 110, 300.0));

        users = new ArrayList<>();
        users.add(new User(1, "Michell", new ArrayList<>(Arrays.asList(2, 3, 4, 5)),
                new ArrayList<>(Arrays.asList(2, 4, 6, 8)), new ArrayList<>()));
        users.add(
                new User(2, "John", new ArrayList<>(Arrays.asList(3, 4, 5, 6)), new ArrayList<>(), new ArrayList<>()));
        users.add(new User(3, "Jane", new ArrayList<>(), new ArrayList<>(), posts));
        users.add(new User(4, "Alice", new ArrayList<>(), new ArrayList<>(Arrays.asList(2, 3, 5)), new ArrayList<>()));
        users.add(new User(5, "Bob", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        users.add(new User(6, "Charlie", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        users.add(new User(7, "Diana", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        users.add(new User(8, "Eve", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        users.add(new User(9, "Frank", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        users.add(new User(10, "Grace", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        users.add(new User(11, "Hank", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
    }

    @Override
    public Optional<User> findById(Integer userId) {
        return users.stream()
                .filter(user -> user.getId().equals(userId))
                .findFirst();
    }

    @Override
    public void follow(Integer userId, Integer userIdToFollow) {
        User user = this.findById(userId).get();
        User userToFollow = this.findById(userIdToFollow).get();
        user.addFollowed(userToFollow.getId());
        userToFollow.addFollower(user.getId());
    }

    @Override
    public void unfollow(Integer userId, Integer userIdToUnfollow) {
        User user = this.findById(userId).get();
        User userToUnfollow = this.findById(userIdToUnfollow).get();
        user.removeFollowed(userToUnfollow.getId());
        userToUnfollow.removeFollowers(user.getId());
    }

    @Override
    public List<User> findAll() {
        return users;
    }

}
