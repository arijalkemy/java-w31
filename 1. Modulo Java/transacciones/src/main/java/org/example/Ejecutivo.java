package org.example;

public class Ejecutivo extends Cliente{
    public Ejecutivo(String nombre) {
        super(nombre);
    }

    @Override
    public void mostrarOperaciones() {
        System.out.println("Ejecutivo: " + nombre);
        new Deposito().transaccion();
        new Transferencia().transaccion();
    }
}

class Basico extends Cliente{
    public Basico(String nombre) {
        super(nombre);
    }

    @Override
    public void mostrarOperaciones() {
        System.out.println("Basico: " + nombre);
        new ConsultaSaldo().transaccion();
        new PagoServicio().transaccion();
        new Retiro().transaccion();
    }
}

class Cobrador extends Cliente{
    public Cobrador(String nombre) {
        super(nombre);
    }

    @Override
    public void mostrarOperaciones() {
        System.out.println("Cobrador: " + nombre);
        new Retiro().transaccion();
        new ConsultaSaldo().transaccion();
    }
}
