package com.example.elastic.repository;

import com.example.elastic.model.Article;
import org.elasticsearch.common.collect.HppcMaps;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface ArticleRepository extends ElasticsearchRepository<Article, Integer> {

    @Query ("{\n" +
            "  \"query\": {\n" +
            "    \"match_all\": {}\n" +
            "  }")
    public List<Article> findAll();

}
