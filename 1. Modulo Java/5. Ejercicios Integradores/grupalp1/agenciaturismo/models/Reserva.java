package agenciaturismo.models;

public abstract class Reserva {

    private int id;
    private String titulo;
    private String fechaDeInicio;
    private String fechaDeFin;
    private Double precio;

    public Reserva(int id, String titulo, String fechaDeInicio, String fechaDeFin, Double precio) {
        this.id = id;
        this.titulo = titulo;
        this.fechaDeInicio = fechaDeInicio;
        this.fechaDeFin = fechaDeFin;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getFechaDeInicio() {
        return fechaDeInicio;
    }

    public String getFechaDeFin() {
        return fechaDeFin;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setFechaDeInicio(String fechaDeInicio) {
        this.fechaDeInicio = fechaDeInicio;
    }

    public void setFechaDeFin(String fechaDeFin) {
        this.fechaDeFin = fechaDeFin;
    }

    @Override
    public String toString() {
        return "Reserva{"
                + "id=" + id
                + ", titulo='" + titulo + '\''
                + ", fechaDeInicio='" + fechaDeInicio + '\''
                + ", fechaDeFin='" + fechaDeFin + '\''
                + '}';
    }
}
