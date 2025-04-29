package com.mercadolibre.be_java_hisp_w31_g02.repository;

import com.mercadolibre.be_java_hisp_w31_g02.entity.Promotion;

import java.util.List;

public interface IPromotionRepository {
    void createPromotion(Promotion promotion, Integer publicationId);
}
