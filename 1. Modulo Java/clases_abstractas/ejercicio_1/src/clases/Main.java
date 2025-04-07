package clases;

public class Main {

    public static void main (String[] args) {
        Basic basic1 = new Basic(200, "Aaron");
        basic1.consultaSaldo();
        basic1.hacerPago("Netflix", 100);
        basic1.consultaSaldo();
        basic1.hacerRetiro(40);
        basic1.consultaSaldo();
        Ejecutivo ejecutivo1 = new Ejecutivo(400, "Jefe");
        Ejecutivo ejecutivo2 = new Ejecutivo(100, "Empleado");
        ejecutivo1.hacerTransferencia(200, ejecutivo2);
        Cobrador cobrador1 = new Cobrador(200, "Mario");
        cobrador1.consultaSaldo();
        cobrador1.hacerRetiro(200);
        cobrador1.consultaSaldo();
    }
}