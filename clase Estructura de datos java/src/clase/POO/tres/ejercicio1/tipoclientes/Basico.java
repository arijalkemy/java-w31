package clase.POO.tres.ejercicio1.tipoclientes;

import clase.POO.tres.ejercicio1.tipostransacciones.Transaccion;

public class Basico {
    Transaccion deposito;
    Transaccion tranferencia;

    public Basico(Transaccion deposito, Transaccion tranferencia) {
        this.deposito = deposito;
        this.tranferencia = tranferencia;
    }

    public void ejecutarTransaccion(){
        deposito.realizarTransaccion();
        tranferencia.realizarTransaccion();
    }
}
