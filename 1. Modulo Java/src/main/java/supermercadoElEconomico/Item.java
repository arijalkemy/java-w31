package supermercadoElEconomico;

public class Item {
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
}
