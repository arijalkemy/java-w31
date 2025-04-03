public class Item {
    private Integer codigo;
    private String nombre;
    private Double costoUnitario;
    private Integer cantidad;

    public Item(Integer codigo, String nombre, Double costoUnitario, Integer cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.costoUnitario = costoUnitario;
        this.cantidad = cantidad;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getCostoUnitario() {
        return costoUnitario;
    }

    public Integer getCantidad() {
        return cantidad;
    }
}
