package com.example.consultasElasticsearch.service;

import com.example.consultasElasticsearch.entity.WorkLiterary;
import com.example.consultasElasticsearch.repository.IRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements IService {
    IRepository repository;

    public ServiceImpl(IRepository repository) {
        this.repository = repository;
    }

    public List<WorkLiterary> save(List<WorkLiterary> workLiteraryList){
        return (List<WorkLiterary>) repository.saveAll(workLiteraryList);
    }
}

