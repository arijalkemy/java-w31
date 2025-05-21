package com.mercadolibre.showroom.repository;

import com.mercadolibre.showroom.model.Sale;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SaleRepository extends ElasticsearchRepository<Sale, String> {

    List<Sale> findAll();
    List<Sale> findByDate(LocalDate date);
}
