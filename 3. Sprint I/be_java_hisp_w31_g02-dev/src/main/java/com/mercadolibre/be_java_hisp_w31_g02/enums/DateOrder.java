package com.mercadolibre.be_java_hisp_w31_g02.enums;

public enum DateOrder {
    DATE_ASC,
    DATE_DESC,
    ;

    public static DateOrder fromString(String order) {
        return DateOrder.valueOf(order.trim().toUpperCase());
    }
}
