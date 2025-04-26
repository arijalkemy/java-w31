package com.bootcamp.calculadoradecalorias.repository;

import com.bootcamp.calculadoradecalorias.model.Food;

import java.util.List;

public interface IFoodRepository {
    List<Food> findAll();
}
