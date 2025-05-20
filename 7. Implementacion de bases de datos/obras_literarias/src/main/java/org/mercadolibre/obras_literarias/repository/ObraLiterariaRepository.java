package org.mercadolibre.obras_literarias.repository;

import org.mercadolibre.obras_literarias.entity.ObraLiteraria;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria, String> {
}
