package co.com.mercadolibre.calculadoradecalorias.dto;

import java.util.List;

public class DishListResponseDto {
    
    private List<DishResponseDto> dishes;

    public List<DishResponseDto> getDishes() {
        return dishes;
    }

    public void setDishes(List<DishResponseDto> dishes) {
        this.dishes = dishes;
    }
}
