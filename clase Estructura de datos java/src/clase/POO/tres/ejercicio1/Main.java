package clase.POO.tres.ejercicio1;

import clase.POO.tres.ejercicio1.tipoclientes.Basico;
import clase.POO.tres.ejercicio1.tipoclientes.Cobrador;
import clase.POO.tres.ejercicio1.tipoclientes.Ejecutivo;
import clase.POO.tres.ejercicio1.tipostransacciones.*;

public class Main {
    public static void main(String[] args) {
        Transaccion consultaDeSaldo = new ConsultaDeSaldo();
        Transaccion deposito = new Deposito();
        Transaccion pagoDeServicios = new PagoDeServicios();
        Transaccion retiro = new RetiroDeEfectivo();
        Transaccion transferencia = new Transferencia();


        Basico clienteBasico = new Basico(deposito, transferencia);
        clienteBasico.ejecutarTransaccion();

        Cobrador clienteCobrador = new Cobrador(consultaDeSaldo, pagoDeServicios, retiro);
        clienteCobrador.ejecutarTransaccion();

        Ejecutivo clienteEjecutivo = new Ejecutivo(retiro,consultaDeSaldo);
        clienteEjecutivo.ejecutarTransaccion();
    }
}
