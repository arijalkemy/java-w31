import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> productos;
    private Double total;

    public Factura(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void agregarProducto(Item item) {
        productos.add(item);
    }

    public Double getTotal() {
        return productos.stream()
                .mapToDouble(producto -> {
                    double v = producto.getCostoUnitario() * producto.getCantidad();
                })
                .sum();
    }
}
