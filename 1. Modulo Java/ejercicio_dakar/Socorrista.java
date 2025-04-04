package ejercicio_dakar;

public interface Socorrista<T extends Vehiculo> {
    public void socorrer(T vehiculo);
}
