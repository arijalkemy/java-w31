package co.com.mercadolibre.joyerialasperlas.mappers;

import co.com.mercadolibre.joyerialasperlas.dto.JewelryDto;
import co.com.mercadolibre.joyerialasperlas.model.Jewelry;

public class JewelryMapper {

    public static JewelryDto toDto(Jewelry jewelry){
        return JewelryDto
                .builder()
                    .peso(jewelry.getPeso())
                    .nombre(jewelry.getNombre())
                    .nroIdentificatorio(jewelry.getNroIdentificatorio())
                    .ventaONo(jewelry.isVentaONo())
                    .particularidad(jewelry.getParticularidad())
                    .material(jewelry.getMaterial())
                .build();
    }

    public static Jewelry toEntity(JewelryDto jewelryDto){
        return Jewelry
                .builder()
                    .peso(jewelryDto.getPeso())
                    .nombre(jewelryDto.getNombre())
                    .nroIdentificatorio(jewelryDto.getNroIdentificatorio())
                    .ventaONo(jewelryDto.isVentaONo())
                    .particularidad(jewelryDto.getParticularidad())
                    .material(jewelryDto.getMaterial())
                .build();
    }

}
