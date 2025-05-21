package com.mercadolibre.demo.utils;

public enum Material {
    ORO("Oro"),
    PLATA("Plata"),
    BRONCE("Bronce"),
    COBRE("Cobre"),
    ACERO("Acero inoxidable"),
    TITANIO("Titanio"),
    ALUMINIO("Aluminio");

    private final String displayName;

    Material(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
