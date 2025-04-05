package sistemasuper;

public class Item {
    private Integer codigo;
    private String nombre;
    private Integer cantidadComprada;
    private Double costoUnitario;


    public Item(Integer codigo, String nombre, Integer cantidadComprada, Double costoUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadComprada = cantidadComprada;
        this.costoUnitario = costoUnitario;
    }

    public Double getCostoUnitario() {
        return costoUnitario;
    }

    public Integer getCantidadComprada() {
        return cantidadComprada;
    }

    @Override
    public String toString() {
        return "Item{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", cantidadComprada=" + cantidadComprada +
                ", costoUnitario=" + costoUnitario +
                '}';
    }
}
