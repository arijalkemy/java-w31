package com.mercadolibre.obrasliterarias.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.mercadolibre.obrasliterarias.repository")
public class Config extends ElasticsearchConfiguration {

    @Override
    public ClientConfiguration clientConfiguration()
    {
        return ClientConfiguration.builder()
                .connectedTo("localhost:9200")
                .build();
    }

//    @Bean
//    public ElasticsearchOperations elasticsearchTemplate(ElasticsearchClient esClient){
//        return new ElasticsearchTemplate(esClient);
    //}
}
