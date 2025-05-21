package com.mercadolibre.showroom_uno.service;

import com.mercadolibre.showroom_uno.dto.ClotheDto;

import java.util.List;

public interface IShowRoomService {
    void createClothe(ClotheDto clotheDto);
    List<ClotheDto> getAllClothes();
    ClotheDto getClotheByCode(Long code);
    void updateClothe(Long id, ClotheDto clotheDto);
    void deleteClothe(Long code);
    List<ClotheDto> getClothesBySize(String size);
    List<ClotheDto> getClotheByName(String name);

}
