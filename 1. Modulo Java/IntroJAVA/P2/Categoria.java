package IntroJAVA.P2;

public class Categoria {
    private static int contadorParticipantes = 0;

    private int id;
    private String nombre;
    private String descripcion;

    public Categoria(String nombre, String descripcion) {
        this.id = contadorParticipantes++;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public int getId() {
        return this.id;
    }
}
