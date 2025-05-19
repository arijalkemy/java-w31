package com.mercadolibre.be_java_hisp_w31_g02.enums;

import com.mercadolibre.be_java_hisp_w31_g02.exception.ConflictException;

public enum DateOrder {
    DATE_ASC,
    DATE_DESC,
    DATE_NULL;

    public static DateOrder fromString(String order) {
        try{
            return order == ""
                    ? DATE_NULL
                    : DateOrder.valueOf(order.trim().toUpperCase());
        } catch (IllegalArgumentException e){
            return DATE_NULL;
        }
    }
}
