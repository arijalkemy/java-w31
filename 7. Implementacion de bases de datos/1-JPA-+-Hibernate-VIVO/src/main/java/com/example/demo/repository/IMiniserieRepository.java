package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.MiniSerie;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface IMiniserieRepository extends JpaRepository< MiniSerie, Long >{
    
}
