package clase.POO.integrador1.agenciaturismo.models;

public class Comida extends Reserva {

    public Comida(int id, String nombre, String fechaDeInicio, String fechaDeFin, Double precio, int cantidadPersonas) {
        super(id, nombre, fechaDeInicio, fechaDeFin, precio);
    }
}
