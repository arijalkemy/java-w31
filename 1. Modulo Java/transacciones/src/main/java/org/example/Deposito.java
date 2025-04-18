package org.example;

public class Deposito extends Transaccion {
    @Override
    public void transaccion(){
        System.out.println("realizando desposito");
        transaccionOk();
    }
}

class Transferencia extends Transaccion {
    @Override
    public void transaccion(){
        System.out.println("realizando trasaccion");
        transaccionOk();
    }
}

class Retiro extends Transaccion {
    @Override
    public void transaccion(){
        System.out.println("realizando retiro");
        transaccionOk();
    }
}

class ConsultaSaldo extends Transaccion {
    @Override
    public void transaccion(){
        System.out.println("realizando consulta saldo");
        transaccionOk();
    }
}

class PagoServicio extends Transaccion {
    @Override
    public void transaccion(){
        System.out.println("realizando pago servicio");
        transaccionOk();
    }
}