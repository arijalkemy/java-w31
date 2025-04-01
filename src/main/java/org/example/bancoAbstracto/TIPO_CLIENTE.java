package org.example.bancoAbstracto;

public enum TIPO_CLIENTE {
    EJECUTIVO(1),
    BASICO(2),
    COBRADOR(3);

    private final int valor;

    TIPO_CLIENTE(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public static TIPO_CLIENTE fromInt(int value) {
        for (TIPO_CLIENTE type : TIPO_CLIENTE.values()) {
            if (type.getValor() == value) {
                return type;
            }
        }
        throw new IllegalArgumentException("Valor no permitido para clientes: " + value);
    }
}
