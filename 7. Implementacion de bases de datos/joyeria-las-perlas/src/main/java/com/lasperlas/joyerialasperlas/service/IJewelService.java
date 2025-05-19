package com.lasperlas.joyerialasperlas.service;

import com.lasperlas.joyerialasperlas.dto.JewelDto;

import java.util.List;

public interface IJewelService {
    List<JewelDto> getJewelry();
    JewelDto postJewelry(JewelDto jewelDto);
    void logicalDeletion(Long id);

}
