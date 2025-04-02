package INT_CarreraDeLaSelva;

public class Categoria {
    private int id;
    private String nombre;
    private String descripcion;

    // Constructor
    public Categoria(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
