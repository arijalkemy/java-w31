package com.mercadolibre.be_java_hisp_w31_g02.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.be_java_hisp_w31_g02.entity.Promotion;
import lombok.Getter;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Repository
public class PromotionRepository implements IPromotionRepository {
    private List<Promotion> promotions;
    private final AtomicInteger idGenerator = new AtomicInteger(1);
    private final IPublicationRepository publicationRepository;
    private final ObjectMapper mapper;

    private void loadData(String jsonPath) throws IOException {
        File file;
        file= ResourceUtils.getFile("classpath:"+jsonPath);
        this.promotions = mapper.readValue(file,new TypeReference<List<Promotion>>(){});

        promotions.forEach(promo -> { publicationRepository.findById(promo.getPublicationId())
                .getPromotionList().add(promo);
        });

    }

    public PromotionRepository(List<Promotion> promotions, IPublicationRepository publicationRepository, ObjectMapper mapper) throws IOException {
        this.promotions = promotions;
        this.publicationRepository = publicationRepository;
        this.mapper = mapper;
        loadData("promotions.json");
    }

    public void createPromotion(Promotion promotion, Integer publicationId) {
        promotion.setPromotionId(idGenerator.getAndIncrement()); // promotionId is automatically generated when saved to the repository
        promotions.add(promotion);
        publicationRepository.addPromotion(promotion, publicationId);
    }

}
