package com.mercadolibre.be_java_hisp_w31_g02.service;

import com.mercadolibre.be_java_hisp_w31_g02.dto.FollowedPublicationDto;
import com.mercadolibre.be_java_hisp_w31_g02.dto.ProductCountDto;
import com.mercadolibre.be_java_hisp_w31_g02.dto.PublicationDto;

import java.time.LocalDate;
import java.util.List;

public interface IPublicationService {
    String createPublicationOrThrow(PublicationDto publicationDto);
    List<FollowedPublicationDto> getPublicationsFollowedByAnUser(Integer userId, String order);
    void createPromotionOrThrow( Integer postId, Double discount,Integer publicationId,  LocalDate initialDate, LocalDate finalDate);
    ProductCountDto countProduct(Integer userId);
}
