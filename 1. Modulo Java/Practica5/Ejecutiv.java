package Practica5;

import Practica5.Cliente;
import Practica5.Deposito;
import Practica5.Transferencia;

public class Ejecutiv extends Cliente {

    private Transferencia trasnferencia = new Transferencia();
    private Deposito deposito = new Deposito();

    public Ejecutiv(String nombre, int id) {
        super(nombre, id);
    }

    @Override
    public void realizarOperacion() {
        trasnferencia.transaccionNoOk();
        deposito.transaccionOk();
    }
}
