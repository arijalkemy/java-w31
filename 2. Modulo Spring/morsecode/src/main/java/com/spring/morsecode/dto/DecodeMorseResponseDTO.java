package com.spring.morsecode.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DecodeMorseResponseDTO {
    private String decodedMorse;
}
