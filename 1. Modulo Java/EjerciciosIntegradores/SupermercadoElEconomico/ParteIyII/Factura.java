package EjerciciosIntegradores.SupermercadoElEconomico.ParteIyII;

import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> productos;
    private double total;
    private static Long contadorFacturas = (long) 0;
    private Long numeroFactura;

    public Factura(Cliente cliente, List<Item> productos) {
        this.cliente = cliente;
        this.productos = productos;
        this.total = calcularTotal();
        this.numeroFactura = ++contadorFacturas;
    }

    private double calcularTotal() {
        double total = 0;
        for (Item producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
