package supermercado;

public class ItemDeFactura {

    private int codigo;
    private String nombre;
    private double precioUnitario;
    private int cantidad;
    private double precioTotal;

    public ItemDeFactura(int codigo, String nombre, double precioUnitario, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.precioTotal = precioUnitario * cantidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
        this.precioTotal = precioUnitario * this.cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        this.precioTotal = this.precioUnitario * cantidad;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }
}
