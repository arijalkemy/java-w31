package com.example.consultasElasticsearch.service;

import com.example.consultasElasticsearch.entity.WorkLiterary;

import java.util.List;

public interface IService {
    List<WorkLiterary> save(List<WorkLiterary> workLiteraryList);
}
