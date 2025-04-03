package EjerciciosIntegradores.SupermercadoElEconomico.Bonus;

import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> productos;
    private double total;
    private static Long contadorFacturas = (long) 0;
    private Long id;

    public Factura(Cliente cliente, List<Item> productos) {
        this.cliente = cliente;
        this.productos = productos;
        this.total = calcularTotal();
        this.id = ++contadorFacturas;
    }

    private double calcularTotal() {
        double total = 0;
        for (Item producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }

    public void agregarProducto(Item producto) {
        productos.add(producto);
        total += producto.getPrecio();
    }
    
    public void eliminarProducto(Item producto) {
        productos.remove(producto);
        total -= producto.getPrecio();
    }

    public Cliente getCliente() {
        return cliente;
    }
    public List<Item> getProductos() {
        return productos;
    }
    public double getTotal() {
        return total;
    }
    public Long getId() {
        return id;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public void setProductos(List<Item> productos) {
        this.productos = productos;
        this.total = calcularTotal();
    }
}
