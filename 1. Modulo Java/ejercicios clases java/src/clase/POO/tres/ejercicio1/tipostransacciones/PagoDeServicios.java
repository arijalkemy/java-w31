package clase.POO.tres.ejercicio1.tipostransacciones;

public class PagoDeServicios implements Transaccion {
    public void realizarTransaccion() {
        System.out.println("Pagando servicios");
        transaccionOk();
    }
}
