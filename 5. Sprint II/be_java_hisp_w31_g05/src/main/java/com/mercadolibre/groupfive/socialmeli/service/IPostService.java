package com.mercadolibre.groupfive.socialmeli.service;

import java.util.List;
import com.mercadolibre.groupfive.socialmeli.dto.PostDto;

public interface IPostService {

    void createPromoPost(PostDto postDto);

    void createPost(PostDto postDto);

    List<PostDto> findPostsByBrand(String brand);

    List<PostDto> findAllByPriceRange(Double min, Double max);

}
