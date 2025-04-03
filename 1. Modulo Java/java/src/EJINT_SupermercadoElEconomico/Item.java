package EJINT_SupermercadoElEconomico;

public class Item {
    private String nombre;
    private String codigo;
    private int cantidad;
    private double costoUnitario;

    public Item(String nombre, int cantidad, double costoUnitario, String codigo) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;
        this.codigo = codigo;
    }

    public double getTotal() {
        return cantidad*costoUnitario;
    }

    @Override
    public String toString() {
        return "Item{" +
                "costoUnitario=" + costoUnitario +
                ", cantidad=" + cantidad +
                ", codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
