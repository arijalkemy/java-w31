package com.company;

public class Main {

    public static void main(String[] args) {
	    Cliente basico = new Basico("Miguel","38.220.103",30);
	    basico.realizarOperacion(new ConsultarSaldo());
	    basico.realizarOperacion(new PagarServicio());
	    basico.realizarOperacion(new RetiroEnEfectivo());

	    Cliente colaborador = new Colaborador("Jose","35.768.819","Nivel 1");
	    colaborador.realizarOperacion(new RetiroEnEfectivo());
	    colaborador.realizarOperacion(new ConsultarSaldo());

	    Cliente ejecutivo = new Ejecutivo("Daniel","34.123.432");
	    ejecutivo.realizarOperacion(new Depositar());
	    ejecutivo.realizarOperacion(new Transferencia());

    }
}
