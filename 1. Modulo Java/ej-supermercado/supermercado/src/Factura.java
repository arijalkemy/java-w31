import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> items;
    private Double total;

    public Factura(Cliente cliente, List<Item> items, Double total) {
        this.cliente = cliente;
        this.items = items;
        this.total = calcularTotal();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
        this.total = calcularTotal();
    }

    public Double getTotal() {
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

    private Double calcularTotal() {
        Double total = 0D;

        for (Item i : this.items) {
            total += i.getCosto() * i.getCantidad();
        }

        return total;
    }
}
