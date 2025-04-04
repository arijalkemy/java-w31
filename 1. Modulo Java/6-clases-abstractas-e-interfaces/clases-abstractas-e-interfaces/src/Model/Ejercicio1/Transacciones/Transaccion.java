package Model.Ejercicio1.Transacciones;

public interface Transaccion {

    // estos metodos por default son abstractos (Java interpreta public abstract), por lo que
    // no hace falta poner "abstract"
    public Boolean transaccionOk();
    public Boolean transaccionNoOk();

}
