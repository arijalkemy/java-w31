package com.mercadolibre.be_java_hisp_w31_g02.repository;

import com.mercadolibre.be_java_hisp_w31_g02.dto.ProductCountDto;
import com.mercadolibre.be_java_hisp_w31_g02.entity.Promotion;
import com.mercadolibre.be_java_hisp_w31_g02.entity.Publication;
import java.util.List;

public interface IPublicationRepository {
    Publication findById(int postId);
    List<Publication> findAll();
    void save(Publication publication);
    ProductCountDto countProduct(Integer userId);
    void addPromotion(Promotion promotion, Integer publicationId);
}
