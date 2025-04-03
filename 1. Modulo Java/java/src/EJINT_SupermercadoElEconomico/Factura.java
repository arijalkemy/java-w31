package EJINT_SupermercadoElEconomico;
import java.util.ArrayList;
import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> items;
    private double total;

    public Factura(Cliente cliente) {
        this.cliente = cliente;
        this.items = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void agregarItem(Item item) {
        this.items.add(item);
        total+= item.getTotal();
    }
    public double calcularTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getTotal(); // suma los totales de cada item
        }
        return total;
    }
    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", items=" + items +
                ", total=" + total +
                '}';
    }
}
