package com.mercadolibreexample.starwarnames;

import com.mercadolibreexample.starwarnames.repository.IRepository;
import com.mercadolibreexample.starwarnames.repository.Repository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StarWarNamesApplication {
    public static void main(String[] args) {
        SpringApplication.run(StarWarNamesApplication.class, args);
    }
}