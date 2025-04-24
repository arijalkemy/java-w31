package com.bootcamp.be_java_hisp_w31_g09.repository;

import com.bootcamp.be_java_hisp_w31_g09.entity.Post;
import com.bootcamp.be_java_hisp_w31_g09.entity.Seller;

import java.util.List;
import java.util.Optional;

public interface SellerRepository {
    List<Seller> getAll();
    boolean addPost(Post post, Integer userId);
    Optional<String> getUsernameByID(Integer userId);
    List<Seller> findAllById(List<Integer> sellerIds);
    Optional<Seller> findById(Integer id);
    List<Post> getPromoPostsByUser(Integer userId);
    Optional<Post> findPostById(Integer sellerId, Integer postId);
    Optional<List<Post>> findPostsById(Integer user_id);
}
