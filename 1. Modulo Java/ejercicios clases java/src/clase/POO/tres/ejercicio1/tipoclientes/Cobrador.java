package clase.POO.tres.ejercicio1.tipoclientes;

import clase.POO.tres.ejercicio1.tipostransacciones.Transaccion;

public class Cobrador implements Transaccion{
    Transaccion consultaDeSaldo;
    Transaccion tranferencia;
    Transaccion retiro;

    public Cobrador(Transaccion consultaDeSaldo, Transaccion tranferencia, Transaccion retiro) {
        this.consultaDeSaldo = consultaDeSaldo;
        this.tranferencia = tranferencia;
        this.retiro = retiro;
    }
    public void ejecutarTransaccion(){
        consultaDeSaldo.realizarTransaccion();
        consultaDeSaldo.realizarTransaccion();
        tranferencia.realizarTransaccion();
        retiro.realizarTransaccion();
    }

    @Override
    public void realizarTransaccion() {

    }
}
