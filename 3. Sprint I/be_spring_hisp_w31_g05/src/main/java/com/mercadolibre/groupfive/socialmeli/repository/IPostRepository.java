package com.mercadolibre.groupfive.socialmeli.repository;

import java.util.List;

import com.mercadolibre.groupfive.socialmeli.model.Post;

import java.util.List;

public interface IPostRepository {

    void save(Post post);

    List<Post> findAllByBrand(String brand);
    
    List<Post> findAllByPriceRange(Double min, Double max);

}
