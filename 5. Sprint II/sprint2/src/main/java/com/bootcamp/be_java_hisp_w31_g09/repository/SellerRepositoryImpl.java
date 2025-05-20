package com.bootcamp.be_java_hisp_w31_g09.repository;
import com.bootcamp.be_java_hisp_w31_g09.entity.Post;
import com.bootcamp.be_java_hisp_w31_g09.entity.Seller;
import com.bootcamp.be_java_hisp_w31_g09.utils.IdGenerator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;


@Repository

public class SellerRepositoryImpl implements SellerRepository {
    private List<Seller> sellerList;

    public SellerRepositoryImpl() {
        loadSellersFromJson();
    }

    private void loadSellersFromJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        File file;

        List<Seller> sellers = new ArrayList<>();

        try {
            InputStream inputStream = new ClassPathResource("sellers.json").getInputStream();
            sellers = objectMapper.readValue(inputStream, new TypeReference<List<Seller>>() {});
        } catch (FileNotFoundException e) {
          e.printStackTrace();
          throw new RuntimeException("Failed to find sellers file");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load sellers from JSON", e);
        }

        sellerList = sellers;

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
