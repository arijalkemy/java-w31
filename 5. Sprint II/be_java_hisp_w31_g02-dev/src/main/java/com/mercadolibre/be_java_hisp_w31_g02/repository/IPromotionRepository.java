package com.mercadolibre.be_java_hisp_w31_g02.repository;

import com.mercadolibre.be_java_hisp_w31_g02.entity.Promotion;


public interface IPromotionRepository {
    void createPromotion(Promotion promotion, Integer publicationId);
}
