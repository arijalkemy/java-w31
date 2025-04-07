package ejercicio1;

public interface Transaccion {
    void transaccionOk(String tipoTransacc);
    void transaccionNoOk(String tipoTransacc);
}
