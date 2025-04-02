package clase.POO.tres.ejercicio1.tipoclientes;

import clase.POO.tres.ejercicio1.tipostransacciones.Transaccion;

public class Ejecutivo {
    Transaccion consultaDeSaldo;
    Transaccion retiro;

    public Ejecutivo(Transaccion consultaDeSaldo, Transaccion retiro) {
        this.consultaDeSaldo = consultaDeSaldo;
        this.retiro = retiro;
    }

    public void ejecutarTransaccion(){
        consultaDeSaldo.realizarTransaccion();
        retiro.realizarTransaccion();
    }
}
