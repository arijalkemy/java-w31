package interfaces;
public interface Transacciones {
    
    
    public void transaccionOk(String cliente, int transaccion);
    public void transaccionOk(String cliente, int transaccion, String servicio);
    public void transaccionNoOk(String tipoTransaccion);
}
