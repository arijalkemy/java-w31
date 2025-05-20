package com.mercadolibre.elastic.repository;

import com.mercadolibre.elastic.domain.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ArticleRepository extends ElasticsearchRepository<Article, String> {

}
