package agenciaturismo.models;

public class Hotel extends Reserva {

    public Hotel(int id, String nombre, String fechaDeInicio, String fechaDeFin, Double precio, int cantidadPersonas) {
        super(id, nombre, fechaDeInicio, fechaDeFin, precio);
    }
}
