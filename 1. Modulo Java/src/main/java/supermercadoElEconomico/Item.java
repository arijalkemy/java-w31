package supermercadoElEconomico;

import java.io.Serializable;

public class Item implements Identificable<String> {
    private String nombre;
    private String codigo;
    private float costoUnitario;
    private int cantidad;


    public Item(String nombre, String codigo, float costoUnitario, int cantidad) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.costoUnitario = costoUnitario;
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public float getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(int costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public float getCostoTotal() {
        return costoUnitario * cantidad;
    }

    @Override
    public String getID() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Item{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", costoUnitario=" + costoUnitario +
                ", cantidad=" + cantidad +
                '}';
    }
}
