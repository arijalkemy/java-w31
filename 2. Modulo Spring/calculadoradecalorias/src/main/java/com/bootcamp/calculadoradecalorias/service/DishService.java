package com.bootcamp.calculadoradecalorias.service;

import com.bootcamp.calculadoradecalorias.dto.DishDto;
import com.bootcamp.calculadoradecalorias.dto.DishRequestDto;
import com.bootcamp.calculadoradecalorias.dto.DishesRequestDto;

import java.util.List;

public interface DishService {
    public DishDto dishInformation(DishRequestDto dishReq);

    List<DishDto> dishesInformation(DishesRequestDto dishes);
}
