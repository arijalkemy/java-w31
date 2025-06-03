package com.example.consultasElasticsearch.controller;

import com.example.consultasElasticsearch.entity.WorkLiterary;
import com.example.consultasElasticsearch.service.IService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/work")
public class Controller {
    private final IService service;

    public Controller(IService service) {
        this.service = service;
    }

    @PostMapping("/literary")
    public List<WorkLiterary> addWorksLiterary(@RequestBody List<WorkLiterary> workLiteraryList){
      return service.save(workLiteraryList);
    }

}
