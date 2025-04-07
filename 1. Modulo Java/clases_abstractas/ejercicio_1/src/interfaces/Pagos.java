package interfaces;
public interface Pagos extends Transacciones {
    public void hacerPago(String servicio, int cantidad);
}
