package com.miprimerproyecto.pruebaspring.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DecodedMessageDto {
    private String messageDecoded;

    public DecodedMessageDto(String messageDecoded) {
        this.messageDecoded = messageDecoded;
    }
}
