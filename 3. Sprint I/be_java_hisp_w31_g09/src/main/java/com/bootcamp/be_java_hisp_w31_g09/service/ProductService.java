package com.bootcamp.be_java_hisp_w31_g09.service;


import com.bootcamp.be_java_hisp_w31_g09.dto.*;

import java.util.List;

public interface ProductService {
    UserPostsResponseDTO getFollowedPostsOrder(int userId, String order);
    ResponseMessageDTO savePost(RequestPostDTO requestPostDTO);
    ResponsePromoPostDTO getPromoPostsByUser(Integer userId);
    ResponseMessageDTO savePromoPost(RequestPromoPostDTO requestPromoPostDTO);
    ResponseMessageDTO updateUserPrices(Integer userId, UpdatePricesDTO updatePricesDTO);
    PromoProductsCountResponseDTO getPromoProductsCount(Integer userId);
    ResponseMessageDTO updateDiscountByPostId(Integer postId, Integer sellerId, DiscountDTO discount);
    ResponseMessageDTO updateDiscountsBySeller(Integer userId, Double discount);
    List<PromoPostDTO> getPostsByPriceRange(Integer userId, Double minPrice, Double maxPrice);
    UserPostsResponseDTO getPostsByUser(Integer user_id);
}
