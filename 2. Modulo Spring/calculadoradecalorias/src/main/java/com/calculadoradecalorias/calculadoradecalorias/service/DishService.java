package com.calculadoradecalorias.calculadoradecalorias.service;

import com.calculadoradecalorias.calculadoradecalorias.dto.DishDataResponseTDO;
import com.calculadoradecalorias.calculadoradecalorias.dto.DishRequestDTO;

import java.util.List;

public interface DishService {
    public DishDataResponseTDO calculateDish(DishRequestDTO d);
    public List<DishDataResponseTDO> calculateMultipleDishes(List<DishRequestDTO> dishes);

}
