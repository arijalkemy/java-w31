package org.example.bancoAbstracto;

public enum TIPO_TRANSACCION {
    DEPOSITO(1),
    TRANSFERENCIA(2),
    CONSULTA(3),
    PAGO(4),
    RETIRO(5);

    private final int valor;

    TIPO_TRANSACCION(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public static TIPO_TRANSACCION fromInt(int value) {
        for (TIPO_TRANSACCION type : TIPO_TRANSACCION.values()) {
            if (type.getValor() == value) {
                return type;
            }
        }
        throw new IllegalArgumentException("Valor no válido para TransactionType: " + value);
    }
}
