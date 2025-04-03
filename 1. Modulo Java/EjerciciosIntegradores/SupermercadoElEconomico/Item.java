package EjerciciosIntegradores.SupermercadoElEconomico;

public class Item {
    private static Long contadorProductos = (long) 0;
    private Long codigo;
    private String nombre;
    private int cantidadComprada;
    private double costoUnitario;

    public Item(String nombre, int cantidadComprada, double costoUnitario) {
        this.codigo = ++contadorProductos;
        this.nombre = nombre;
        this.cantidadComprada = cantidadComprada;
        this.costoUnitario = costoUnitario;
    }

    public Long getCodigo() {
        return codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public int getCantidadComprada() {
        return cantidadComprada;
    }
    public double getCostoUnitario() {
        return costoUnitario;
    }
    public double getPrecio() {
        return costoUnitario * cantidadComprada;
    }
}
