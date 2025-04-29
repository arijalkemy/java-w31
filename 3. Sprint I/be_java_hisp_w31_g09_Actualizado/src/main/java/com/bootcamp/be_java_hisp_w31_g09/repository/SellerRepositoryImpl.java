package com.bootcamp.be_java_hisp_w31_g09.repository;

import com.bootcamp.be_java_hisp_w31_g09.entity.Post;
import com.bootcamp.be_java_hisp_w31_g09.entity.Product;
import com.bootcamp.be_java_hisp_w31_g09.entity.Seller;
import com.bootcamp.be_java_hisp_w31_g09.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w31_g09.utils.IdGenerator;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.Objects;

import java.util.Optional;



@Repository

public class SellerRepositoryImpl implements SellerRepository {
    private List<Seller> sellerList;

    public SellerRepositoryImpl() {
        sellerList = new ArrayList<>(Arrays.asList(
                new Seller(IdGenerator.getNextUserId(), "Juan",
                        new ArrayList<>(Arrays.asList(
                                new Post(IdGenerator.getNextPostId(), IdGenerator.getCurrentUserId(),LocalDate.parse("2025-04-20"),
                                        new Product(1, "Silla Gamer", "Gamer", "Racer", "Red & Black", "Special Edition"),
                                        100, 15000.8, Boolean.TRUE, 0.25)))),
                new Seller(IdGenerator.getNextUserId(), "Maria",
                        new ArrayList<>(Arrays.asList(
                                new Post(IdGenerator.getNextPostId(), IdGenerator.getCurrentUserId(),LocalDate.parse("2025-04-15"),
                                        new Product(2, "Teclado Mecánico", "Gaming", "HyperX", "RGB", "Alloy FPS Pro"),
                                        80, 15000.8, Boolean.TRUE, 0.15)))),
                new Seller(IdGenerator.getNextUserId(), "Carlos",
                        new ArrayList<>(Arrays.asList(
                                new Post(IdGenerator.getNextPostId(), IdGenerator.getCurrentUserId(),LocalDate.parse("2025-03-10"),
                                        new Product(3, "Mouse Inalámbrico", "Accesorios", "Logitech", "Negro", "MX Master 3"),
                                        60, 15000.8, Boolean.FALSE, 0.10)))),
                new Seller(IdGenerator.getNextUserId(), "Ana",
                        new ArrayList<>(Arrays.asList(
                                new Post(IdGenerator.getNextPostId(), IdGenerator.getCurrentUserId(),LocalDate.parse("2025-04-21"),
                                        new Product(4, "Monitor LED", "Pantallas", "Samsung", "Full HD", "SR350"),
                                        150, 15000.8, Boolean.TRUE, 0.20)))),
                new Seller(IdGenerator.getNextUserId(), "Luis",
                        new ArrayList<>(Arrays.asList(
                                new Post(IdGenerator.getNextPostId(), IdGenerator.getCurrentUserId(),LocalDate.parse("2025-04-05"),
                                        new Product(5, "Impresora Láser", "Oficina", "HP", "Blanco y Negro", "LaserJet Pro"),
                                        120, 15000.8, Boolean.FALSE, 0.12)))),
                new Seller(IdGenerator.getNextUserId(), "Sofia",
                        new ArrayList<>(Arrays.asList(
                                new Post(IdGenerator.getNextPostId(), IdGenerator.getCurrentUserId(),LocalDate.parse("2025-04-12"),
                                        new Product(6, "Auriculares", "Audio", "Sony", "Negro", "WH-1000XM4"),
                                        200, 15000.8, Boolean.TRUE, 0.18)))),
                new Seller(IdGenerator.getNextUserId(), "Pedro",
                        new ArrayList<>(Arrays.asList(
                                new Post(IdGenerator.getNextPostId(), IdGenerator.getCurrentUserId(),LocalDate.parse("2025-04-21"),
                                        new Product(7, "Tablet", "Electrónica", "Apple", "Gris Espacial", "iPad Air"),
                                        500, 15000.8, Boolean.FALSE, 0.22)))),
                new Seller(IdGenerator.getNextUserId(), "Laura",
                        new ArrayList<>(Arrays.asList(
                                new Post(IdGenerator.getNextPostId(), IdGenerator.getCurrentUserId(),LocalDate.parse("2025-04-03"),
                                        new Product(8, "Smartwatch", "Tecnología", "Fitbit", "Negro", "Versa 3"),
                                        230, 15000.8, Boolean.TRUE, 0.17)))),
                new Seller(IdGenerator.getNextUserId(), "Daniel",
                        new ArrayList<>(Arrays.asList(
                                new Post(IdGenerator.getNextPostId(), IdGenerator.getCurrentUserId(),LocalDate.parse("2025-04-04"),
                                        new Product(9, "Cámara Digital", "Fotografía", "Canon", "Negra", "EOS Rebel T7"),
                                        400, 15000.8, Boolean.FALSE, 0.20)))),
                new Seller(IdGenerator.getNextUserId(), "Lucia",
                        new ArrayList<>(Arrays.asList(
                                new Post(IdGenerator.getNextPostId(), IdGenerator.getCurrentUserId(),LocalDate.parse("2025-04-18"),
                                        new Product(10, "Portátil", "Computadoras", "Dell", "Plata", "XPS 13"),
                                        900, 15000.8, Boolean.TRUE, 0.25))))
        ));
    }

    //Metodo que chequea id de producto en un post
    public Boolean existIdProduct(Integer  idSeller, Integer idProduct){
        Seller seller = sellerList.stream()
                .filter(a->a.getId().equals(idSeller))
                .findFirst()
                .orElseThrow(()-> new BadRequestException("Vendedor con id: " + idSeller + " no encontrdo"));
        Post post = seller.getPosts().stream()
                .filter(a-> a.getProduct().getId().equals(idProduct))
                .findFirst()
                .orElse(null);
        if(Objects.isNull(post)){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public boolean addPost(Post post, Integer userId) {
        Optional<Seller> sellerOptional = sellerList.stream()
                .filter(s -> s.getId().equals(userId))
                .findFirst();

        if (sellerOptional.isEmpty()) {
            return false;
        }

        Seller seller = sellerOptional.get();
        post.setId(IdGenerator.getNextPostId());
        seller.getPosts().add(post);
        return true;
    }

    @Override
    public Optional<String> getUsernameByID(Integer userId) {
        return sellerList.stream()
                .filter(seller -> seller.getId().equals(userId))
                .map(Seller::getName)
                .findFirst();
    }

    public List<Seller> findAllById(List<Integer> sellerIds) {
        return sellerIds.stream()
                .flatMap(id -> sellerList.stream().filter(seller -> seller.getId().equals(id)))
                .toList();
    }

    @Override
    public Optional<Seller> findById(Integer id) {
        return sellerList.stream()
                .filter(seller -> seller.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Post> getPromoPostsByUser(Integer userId) {
        return sellerList.stream()
                .flatMap(seller -> seller.getPosts().stream())
                .filter(p -> p.getUserId().equals(userId))
                .filter(Post::getHasPromo)
                .toList();
    }


    @Override
    public Optional<Post> findPostById(Integer sellerId, Integer postId) {
        return findById(sellerId)
                .flatMap(seller ->
                        seller.getPosts().stream()
                                .filter(post -> post.getId().equals(postId))
                                .findFirst()
                );
    }

    @Override
    public Optional<List<Post>> findPostsById(Integer sellerId) {
        return findById(sellerId)
                .map(Seller::getPosts);
    }

    @Override
    public List<Seller> getAll() {
        return sellerList;
    }

}
