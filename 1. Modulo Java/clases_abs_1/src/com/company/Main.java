package com.company;

public class Main {

    public static void main(String[] args) {
	   Cobradores cobrador = new Cobradores();
	   cobrador.retirarEfectivo();

	   Ejecutivo ejecutivo = new Ejecutivo();
	   ejecutivo.hacerDeposito(30000.0);
	   ejecutivo.transaccionOk();

	   Basico basico = new Basico();
	   basico.pagarServicios("Luz");
	   basico.transaccionNoOk();
    }
}
