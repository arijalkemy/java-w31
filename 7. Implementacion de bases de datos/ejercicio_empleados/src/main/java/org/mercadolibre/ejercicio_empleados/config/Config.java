package org.mercadolibre.ejercicio_empleados.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.mercadolibre.ejercicio_empleados.repository")
public class Config extends ElasticsearchConfiguration {

    @Override
    public ClientConfiguration clientConfiguration(){
        return ClientConfiguration.builder().connectedTo("localhost:9200")
                .withSocketTimeout(30000)
                .withConnectTimeout(1000)
                .build();
    }
}
