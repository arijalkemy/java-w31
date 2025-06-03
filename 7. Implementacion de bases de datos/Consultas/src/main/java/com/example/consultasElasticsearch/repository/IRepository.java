package com.example.consultasElasticsearch.repository;

import com.example.consultasElasticsearch.entity.WorkLiterary;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IRepository  extends ElasticsearchRepository<WorkLiterary, String> {

}
