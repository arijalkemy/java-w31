package com.mercadolibre.obrasliterariases.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.time.Duration;


@Configuration
@EnableElasticsearchRepositories(basePackages = "com.mercadolibre.obrasliterariases.repository")
public class ElasticsearchConfig extends ElasticsearchConfiguration {

    @Override
    public ClientConfiguration clientConfiguration() {
        return ClientConfiguration.builder()
                .connectedTo("localhost:9200")
                .withSocketTimeout(Duration.ofMillis(30000))
                .withConnectTimeout(Duration.ofMillis(10000))
                .build();
    }
}