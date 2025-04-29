package com.mercadolibre.be_java_hisp_w31_g02.enums;

import com.mercadolibre.be_java_hisp_w31_g02.exception.ConflictException;

public enum UserOrder {
    NAME_ASC,
    NAME_DESC,
    NAME_NULL;

    // Opcional: método para convertir strings en enum, ignorando mayúsculas/minúsculas y guiones bajos
    public static UserOrder fromString(String value) {
        try{
            return value == ""
                    ? NAME_NULL
                    : UserOrder.valueOf(value.trim().toUpperCase());
        } catch (IllegalArgumentException e){
            throw new ConflictException("Invalid type order: the possibilities are name_desc, name_asc or nothing");
        }

    }
}
