package com.mercadolibre.demo.dto;

import com.mercadolibre.demo.utils.Material;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoyaDTO {

        private Long id;

        private String name;

        private Material material;

        private Double pesoEnGramos;

        private String particularidad;

        private Boolean poseePiedra;

        private Boolean ventaONo;


}
