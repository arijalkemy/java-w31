package enumeradores;

public enum Descuentos {
    LOCALIZADORES_PREVIOS(5,3), //CUENTA EL ACTUAL
    PAQUETE_COMPLETO(10, 0),
    RESERVAS_MISMO_TIPO(5, 2);

    private final int porcentaje;
    private final int cantidadValidaParaDescuento;

    Descuentos(int descuento, int cantidadValidaParaDescuento) {
        this.porcentaje = descuento;
        this.cantidadValidaParaDescuento = cantidadValidaParaDescuento;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public int getCantidadValidaParaDescuento() {
        return cantidadValidaParaDescuento;
    }
}
