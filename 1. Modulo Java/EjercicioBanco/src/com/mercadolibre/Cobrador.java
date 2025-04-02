package com.mercadolibre;

public class Cobrador extends Cliente{
    /*Realizan retiro de efectivo y consulta de saldos.*/

    public Cobrador(Double saldoEnCuenta) {
        super(saldoEnCuenta);
    }

    public void retirarEfectivo(Double dineroARetirar){
        RetiroEfectivo re = new RetiroEfectivo(this);
        re.retirarEfectivo(dineroARetirar);
        System.out.println("Saldo actual: " + this.getSaldoEnCuenta());
    }

    public void consultarSaldo(){
        ConsultaDeSaldo consulta = new ConsultaDeSaldo(this);
        consulta.consultarSaldo();
        System.out.println("Saldo actual: " + this.getSaldoEnCuenta());
    }
}
